package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Page 696
 * Exercise 17: Using TextFile and a Map<Character,Integer>, create a program that counts the occurrence of all the
 * different characters in a file. (So if there are 12 occurrences of the letter ‘a’ in the file, the Integer associated
 * with the Character containing ‘a’ in the Map contains ‘12’).
 * Exercise 18: Modify TextFile.java so that it passes IOExceptions out to the caller.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class CharacterCounter {
    public static void main(String[] args) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        for (String line : new TextFile(ReadFileByLine.GIT_IGNORE)) {
            for (char c : line.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        System.out.println(map);
    }
}
