package com.github.frankkwok.tij4.initialization;

/**
 * Page 131
 * Exercise 2: Create a class with a String field that is initialized at the point of definition, and another one that
 * is initialized by the constructor. What is the difference between the two approaches?
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class StringTest {
    private String string1 = "hello";
    private String string2;

    private StringTest(String string2) {
        this.string2 = string2;
    }

    public static void main(String[] args) {
        StringTest st = new StringTest("hello");
        System.out.println("st.string1: " + st.string1);
        System.out.println("st.string2: " + st.string2);
    }
}
