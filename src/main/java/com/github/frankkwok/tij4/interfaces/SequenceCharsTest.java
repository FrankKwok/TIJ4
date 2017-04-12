package com.github.frankkwok.tij4.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Page 257
 * Exercise 16: Create a class that produces a sequence of chars. Adapt this class so that it can be an input to a
 * Scanner object.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class SequenceCharsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new SequenceCharsAdapter(new SequenceChars()));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

class SequenceChars {
    private static Random rand = new Random();
    private static final char[] alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    char[] next() {
        char[] chars = new char[rand.nextInt(20)];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = alphabets[rand.nextInt(alphabets.length)];
        }
        return chars;
    }
}

class SequenceCharsAdapter implements Readable {
    private SequenceChars sc;

    SequenceCharsAdapter(SequenceChars sc) {
        this.sc = sc;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        char[] chars = sc.next();
        if (chars.length < 2) {
            return -1;
        }
        for (char c : chars) {
            cb.append(c);
        }
        cb.append(' ');
        return chars.length + 1;
    }
}
