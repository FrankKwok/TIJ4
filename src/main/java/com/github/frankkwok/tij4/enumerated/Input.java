package com.github.frankkwok.tij4.enumerated;

import java.util.Random;

/**
 * @author Frank Kwok on 2017/5/29.
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        public int amount() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        @Override
        public int amount() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    private static Random rand = new Random(47);

    public static Input randomSelection() {
        return values()[rand.nextInt(values().length - 1)];
    }

    int value;

    Input(int value) {
        this.value = value;
    }

    Input() {
    }

    int amount() {
        return value;
    }
}
