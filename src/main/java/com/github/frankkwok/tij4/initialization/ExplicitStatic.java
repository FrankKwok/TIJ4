package com.github.frankkwok.tij4.initialization;

/**
 * Page 153
 * Exercise 13: Verify the statements in the previous paragraph.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);  // (1)
    }

     static Cups cups1 = new Cups();  // (2)
     static Cups cups2 = new Cups();  // (2)
}

class Cup {
    Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}
