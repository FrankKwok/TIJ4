package com.github.frankkwok.tij4.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * Page 23
 * Exercise 23: Create and test a utility method to print the contents of a CharBuffer up to the point where the characters are no longer printable.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class CharBufferTest {
    public static void main(String[] args) throws IOException {
        try (FileChannel in = new FileInputStream(ReadFileByLine.GIT_IGNORE).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int) in.size());
            in.read(buffer);
            buffer.flip();
            printCharBuffer(StandardCharsets.UTF_8.decode(buffer));
        }
    }

    private static void printCharBuffer(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
        System.out.println();
    }
}
