package com.github.frankkwok.tij4.object;
//: initialization/Overloading.java
// Demonstration of both constructor
// and ordinary method overloading.

import static java.lang.System.out;

/**
 * Page 62
 * <p>
 * Exercise 16: In the Initialization & Cleanup chapter, locate the Overloading.java example and add Javadoc
 * documentation. Extract this comment documentation into an HTML file using Javadoc and view it with your Web browser.
 */
public class Overloading {
    /**
     * Create Tree object to test overloading
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded method");
        }
        // Overloaded constructor:
        new Tree();
    }
}

class Tree {
    /**
     * the height of tree
     */
    private int height;

    /**
     * Construct tree seedling
     */
    Tree() {
        out.println("Planting a seedling");
        height = 0;
    }

    /**
     * Construct a tree with a height
     *
     * @param initialHeight the height of tree
     */
    Tree(int initialHeight) {
        height = initialHeight;
        out.println("Creating new Tree that is " +
                height + " feet tall");
    }

    /**
     * print tree info
     */
    void info() {
        out.println("Tree is " + height + " feet tall");
    }

    /**
     * print tree info
     *
     * @param s the more info
     */
    void info(String s) {
        out.println(s + ": Tree is " + height + " feet tall");
    }
}
/* Output:
Creating new Tree that is 0 feet tall
Tree is 0 feet tall
overloaded method: Tree is 0 feet tall
Creating new Tree that is 1 feet tall
Tree is 1 feet tall
overloaded method: Tree is 1 feet tall
Creating new Tree that is 2 feet tall
Tree is 2 feet tall
overloaded method: Tree is 2 feet tall
Creating new Tree that is 3 feet tall
Tree is 3 feet tall
overloaded method: Tree is 3 feet tall
Creating new Tree that is 4 feet tall
Tree is 4 feet tall
overloaded method: Tree is 4 feet tall
Planting a seedling
*///:~
