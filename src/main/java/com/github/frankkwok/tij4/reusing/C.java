package com.github.frankkwok.tij4.reusing;

/**
 * Page 192
 * Exercise 5: Create two classes, A and B, with default constructors (empty argument lists) that announce themselves.
 * Inherit a new class called C from A, and create a member of class B inside C. Do not create a constructor for C.
 * Create an object of class C and observe the results.
 * <p>
 * Page 193
 * Exercise 7: Modify Exercise 5 so that A and B have constructors with arguments instead of default constructors.
 * Write a constructor for C and perform all initialization within C’s constructor.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class C extends A {
    private B b;

    C() {
        super(11);
        b = new B(11);
    }

    public static void main(String[] args) {
        C c = new C();
    }
}

class A {
    A(int i) {
        System.out.println("Create A");
    }
}

class B {
    B(int i) {
        System.out.println("Create B");
    }
}
