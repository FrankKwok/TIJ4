package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 279
 * Exercise 19: Create a class containing an inner class that itself contains an inner class. Repeat this using nested
 * classes. Note the names of the .class files produced by the compiler.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class MoreInnerClassTest {
    public static void main(String[] args) {
        MoreInnerClassTest mict = new MoreInnerClassTest();
        InnerLevel1 il1 = mict.new InnerLevel1();
        InnerLevel1.InnerLevel2 il2 = il1.new InnerLevel2();
    }

    class InnerLevel1 {
        class InnerLevel2 {

        }
    }
}
