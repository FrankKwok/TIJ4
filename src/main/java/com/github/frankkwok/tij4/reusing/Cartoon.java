package com.github.frankkwok.tij4.reusing;

/**
 * Page 192
 * Exercise 3: Prove the previous sentence.
 * Exercise 4: Prove that the base-class constructors are (a) always called and (b) called before derived-class
 * constructors.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class Cartoon extends Drawing {
    public static void main(String[] args) {
        Cartoon cartoon = new Cartoon();
    }
}

class Art {
    Art() {
        System.out.println("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructor");
    }
}
