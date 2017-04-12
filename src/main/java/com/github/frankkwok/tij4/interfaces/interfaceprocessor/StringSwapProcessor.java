package com.github.frankkwok.tij4.interfaces.interfaceprocessor;

/**
 * Page 251
 * Exercise 11: Create a class with a method that takes a String argument and produces a result that swaps each pair of
 * characters in that argument. Adapt the class so that it works with interfaceprocessor.Apply.process( ).
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class StringSwapProcessor implements Processor {
    public static void main(String[] args) {
        Apply.process(new StringSwapProcessor(), "hello, world");
    }

    @Override
    public String name() {
        return getClass().getSimpleName();
    }

    @Override
    public String process(Object input) {
        String text = (String) input;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i += 2) {
            if (i + 1 < chars.length) {
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
            }
        }
        return new String(chars);
    }
}
