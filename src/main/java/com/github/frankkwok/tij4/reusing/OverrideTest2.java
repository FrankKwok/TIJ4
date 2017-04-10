package com.github.frankkwok.tij4.reusing;

/**
 * Page 209
 * Exercise 20: Show that @Override annotation solves the problem in this section.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class OverrideTest2 {
}

class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        System.out.println("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        System.out.println("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    //    @Override
    private final void f() {
        System.out.println("OverridingPrivate.f()");
    }

    //    @Override
    private void g() {
        System.out.println("OverridingPrivate.g()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    //    @Override
    public final void f() {
        System.out.println("OverridingPrivate2.f()");
    }

    //    @Override
    public void g() {
        System.out.println("OverridingPrivate2.g()");
    }
}
