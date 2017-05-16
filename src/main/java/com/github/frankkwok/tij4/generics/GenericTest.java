package com.github.frankkwok.tij4.generics;

/**
 * Page 488
 * Exercise 20: Create an interface with two methods, and a class that implements that interface and adds another
 * method. In another class, create a generic method with an argument type that is bounded by the interface, and show
 * that the methods in the interface are callable inside this generic method. In main( ), pass an instance of the
 * implementing class to the generic method.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class GenericTest {
    public static void main(String[] args) {
        test(new BoundClass());
    }

    static <T extends BoundInterface> void test(T t) {
        t.f();
        t.g();
        if (t instanceof BoundClass) {
            ((BoundClass) t).h();
        }
    }
}

interface BoundInterface {
    void f();

    void g();
}

class BoundClass implements BoundInterface {
    @Override
    public void f() {
        System.out.println("BoundClass.f()");
    }

    @Override
    public void g() {
        System.out.println("BoundClass.g()");
    }

    void h() {
        System.out.println("BoundClass.h()");
    }
}
