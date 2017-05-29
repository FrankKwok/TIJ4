package com.github.frankkwok.tij4.enumerated;

import com.github.frankkwok.tij4.util.Generator;
import com.github.frankkwok.tij4.util.TextFile;

import java.io.IOException;
import java.util.EnumMap;
import java.util.Iterator;

import static com.github.frankkwok.tij4.enumerated.Input.*;

/**
 * Page 773
 * Exercise 10: Modify class VendingMachine (only) using EnumMap so that one program can have multiple instances of
 * VendingMachine. // todo
 * <p>
 * Page 774
 * Exercise 11: In a real vending machine you will want to easily add and change the type of vended items, so the limits
 * imposed by an enum on Input are impractical (remember that enums are for a restricted set of types). Modify
 * VendingMachine.java so that the vended items are represented by a class instead of being part of Input, and
 * initialize an Array List of these objects from a text file (using net.mindview.util.TextFile). // todo
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class VendingMachine {
    private static State state = State.RESTING;
    private static int amount = 0;
    private static Input selection = null;

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1) {
            gen = new FileInputGenerator(args[0]);
        }
        vendingMachine.run(gen);
    }

    private void run(Generator<Input> gen) {
        while (state != State.TERMINAL) {
            state.next(gen.next());
            while (state.isTransient) {
                state.next();
            }
            state.output();
        }
    }

    enum StateDuration {
        TRANSIENT
    }

    enum State {
        RESTING {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        state = ADDING_MONEY;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        ADDING_MONEY {
            @Override
            void next(Input input) {
                switch (Category.categorize(input)) {
                    case MONEY:
                        amount += input.amount();
                        break;
                    case ITEM_SELECTION:
                        selection = input;
                        if (amount < selection.amount()) {
                            System.out.println("Insufficient money for " + selection);
                        } else {
                            state = DISPENSING;
                        }
                        break;
                    case QUIT_TRANSACTION:
                        state = GIVING_CHANGE;
                        break;
                    case SHUT_DOWN:
                        state = TERMINAL;
                    default:
                }
            }
        },
        DISPENSING(StateDuration.TRANSIENT) {
            @Override
            void next() {
                System.out.println("here is your " + selection);
                amount -= selection.amount();
                state = GIVING_CHANGE;
            }
        },
        GIVING_CHANGE(StateDuration.TRANSIENT) {
            @Override
            void next() {
                if (amount > 0) {
                    System.out.println("Your change: " + amount);
                    amount = 0;
                }
                state = RESTING;
            }
        },
        TERMINAL {
            @Override
            void output() {
                System.out.println("Halted");
            }
        };

        private boolean isTransient = false;

        State() {
        }

        State(StateDuration trans) {
            isTransient = true;
        }

        void next(Input input) {
            throw new RuntimeException("Only call " +
                    "next(Input input) for non-transient states");
        }

        void next() {
            throw new RuntimeException("Only call next() for " +
                    "StateDuration.TRANSIENT states");
        }

        void output() {
            System.out.println(amount);
        }
    }
}

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);

    private static EnumMap<Input, Category> categories = new EnumMap<>(Input.class);

    private Input[] values;

    static {
        for (Category c : Category.class.getEnumConstants()) {
            for (Input type : c.values) {
                categories.put(type, c);
            }
        }
    }

    Category(Input... types) {
        values = types;
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

class RandomInputGenerator implements Generator<Input> {
    @Override
    public Input next() {
        return Input.randomSelection();
    }
}

class FileInputGenerator implements Generator<Input> {
    private Iterator<String> input;

    /*package*/ FileInputGenerator(String fileName) {
        try {
            input = new TextFile(fileName, ";").iterator();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Input next() {
        if (!input.hasNext()) {
            return null;
        }
        return Enum.valueOf(Input.class, input.next().trim());
    }
}
