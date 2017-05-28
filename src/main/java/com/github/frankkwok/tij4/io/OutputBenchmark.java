package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 691
 * Exercise 14: Starting with BasicFileOutput.java, write a program that compares the performance of writing to a file
 * when using buffered and unbuffered I/O.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class OutputBenchmark {
    private static final String INPUT_FILENAME = "C:\\Users\\Frank\\Codes\\Source\\jdk-8u121-docs-all.zip";
    private static final int TIMES = 1;
    private static final String BUFFERED_WRITE_OUT = "Buffered.out";
    private static final String UNBUFFERED_WRITE_OUT = "Unbuffered.out";

    public static void main(String[] args) {
        System.out.println(bufferedWrite());
        System.out.println(unbufferedWrite());
    }

    private static long bufferedWrite() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(INPUT_FILENAME));
                 BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(BUFFERED_WRITE_OUT))) {
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (System.currentTimeMillis() - start) / TIMES;
    }

    private static long unbufferedWrite() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < TIMES; i++) {
            try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(INPUT_FILENAME));
                 OutputStream out = new FileOutputStream(UNBUFFERED_WRITE_OUT)) {
                int b;
                while ((b = in.read()) != -1) {
                    out.write(b);
                }
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return (System.currentTimeMillis() - start) / TIMES;
    }
}
