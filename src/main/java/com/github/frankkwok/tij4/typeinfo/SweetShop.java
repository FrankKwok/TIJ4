package com.github.frankkwok.tij4.typeinfo;

/**
 * Page 421
 * Exercise 7: Modify SweetShop.java so that each type of object creation is controlled by a command-line argument. That
 * is, if your command line is "Java Sweetshop Candy," then only the Candy object is created. Notice how you can control
 * which Class objects are loaded via the commandline argument.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class SweetShop {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please enter (Candy, Gum or Cookie)");
        }
        try {
            Class.forName("com.github.frankkwok.tij4.typoinfo." + args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("You enter wrong class name");
        }
    }
}

class Candy {
    static {
        System.out.println("Loading Candy");
    }
}

class Gum {
    static {
        System.out.println("Loading Gum");
    }
}

class Cookie {
    static {
        System.out.println("Loading Cookie");
    }
}
