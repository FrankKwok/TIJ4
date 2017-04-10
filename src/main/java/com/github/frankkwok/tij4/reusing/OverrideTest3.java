package com.github.frankkwok.tij4.reusing;

/**
 * Page 209
 * Exercise 21: Create a class with a final method. Inherit from that class and attempt to overwrite that method.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class OverrideTest3 extends WithFinal {
    public static void main(String[] args) {

    }

    // Error:(12, 10) java: com.github.frankkwok.tij4.reusing.OverrideTest3中的f()无法覆盖
    // com.github.frankkwok.tij4.reusing.WithFinal中的f() 被覆盖的方法为final

    //    @Override
    /*void f() {

    }*/
}

class WithFinal {
    final void f() {

    }
}
