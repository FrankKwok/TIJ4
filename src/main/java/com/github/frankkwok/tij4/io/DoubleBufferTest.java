package com.github.frankkwok.tij4.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Page 707
 * Exercise 24: Modify IntBufferDemo.java to use doubles.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class DoubleBufferTest {
    private static final int SIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocateDirect(SIZE);
        DoubleBuffer doubleBuffer = bb.asDoubleBuffer();
        doubleBuffer.put(new double[]{1.1, 4.2, 4.7, 9.9, 1.43, 8.11, 1.016});
        System.out.println(doubleBuffer.get(3));
        doubleBuffer.put(3, 1.811);
        doubleBuffer.flip();
        while (doubleBuffer.hasRemaining()) {
            System.out.println(doubleBuffer.get());
        }
    }
}
