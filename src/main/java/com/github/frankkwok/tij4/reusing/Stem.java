package com.github.frankkwok.tij4.reusing;

/**
 * Page 193
 * Exercise 9: Create a class called Root that contains an instance of each of the classes (that you also create) named
 * Component1, Component2, and Component3. Derive a class Stem from Root that also contains an instance of each
 * “component.” All classes should have default constructors that print a message about that class.
 * Exercise 10: Modify the previous exercise so that each class only has non-default constructors.
 * <p>
 * Page 199
 * Exercise 12: Add a proper hierarchy of dispose( ) methods to all the classes in Exercise 9.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class Stem extends Root {
    private Component1 c1;
    private Component2 c2;
    private Component3 c3;

    Stem(int i) {
        super(i);
        c1 = new Component1(i);
        c2 = new Component2(i);
        c3 = new Component3(i);
        System.out.println("Create Stem");
    }

    public static void main(String[] args) {
        Stem stem = new Stem(1);
        stem.dispose();
    }

    @Override
    void dispose() {
        System.out.println("dispose Stem");
        c3.dispose();
        c2.dispose();
        c1.dispose();
        super.dispose();
    }
}

class Root {
    private Component1 c1;
    private Component2 c2;
    private Component3 c3;

    Root(int i) {
        c1 = new Component1(i);
        c2 = new Component2(i);
        c3 = new Component3(i);
        System.out.println("Create Root");
    }

    void dispose() {
        System.out.println("dispose Root");
        c3.dispose();
        c2.dispose();
        c1.dispose();
    }
}

class Component1 {
    Component1(int i) {
        System.out.println("Create Component1");
    }

    void dispose() {
        System.out.println("dispose Component1");
    }
}

class Component2 {
    Component2(int i) {
        System.out.println("Create Component2");
    }

    void dispose() {
        System.out.println("dispose Component2");
    }
}

class Component3 {
    Component3(int i) {
        System.out.println("Create Component3");
    }

    void dispose() {
        System.out.println("dispose Component3");
    }
}
