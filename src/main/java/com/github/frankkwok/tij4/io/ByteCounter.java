package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.BinaryFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Page 697
 * Exercise 19: Using BinaryFile and a Map<Byte,Integer>, create a program that counts the occurrence of all the
 * different bytes in a file.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class ByteCounter {
    public static void main(String[] args) throws IOException {
        Map<Byte, Integer> map = new HashMap<>();
        for (byte b : BinaryFile.read(ReadFileByLine.GIT_IGNORE)) {
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        System.out.println(map);
    }
}
