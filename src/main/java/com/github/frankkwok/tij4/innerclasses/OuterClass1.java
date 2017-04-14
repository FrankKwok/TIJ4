package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 271
 * Exercise 7: Create a class with a private field and a private method. Create an inner class with a method that
 * modifies the outer-class field and calls the outer-class method. In a second outer-class method, create an object of
 * the inner class and call its method, then show the effect on the outer-class object.
 * Exercise 8: Determine whether an outer class has access to the private elements of its inner class.
 * <p>
 * Page 276
 * Exercise 12: Repeat Exercise 7 using an anonymous inner class
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class OuterClass1 {
    private int i;

    public static void main(String[] args) {
        OuterClass1 oc1 = new OuterClass1();
        oc1.callInner();
        System.out.println();
        oc1.callInner2();
    }

    private void f() {
        System.out.println("OuterClass1.f()");
    }

    private void callInner() {
        Inner inner = new Inner();
        inner.change(10);
        System.out.println("after call private inner change(): i = " + i);
    }

    private void callInner2() {
        new Inner() {
            @Override
            void change(int i) {
                OuterClass1.this.i = i * i;
                f();
                System.out.println("is changing i = " + OuterClass1.this.i);
            }
        }.change(10);
    }

    private class Inner {
        private int innerI;

        void change(int i) {
            OuterClass1.this.i = i;
            f();
        }
    }
}
