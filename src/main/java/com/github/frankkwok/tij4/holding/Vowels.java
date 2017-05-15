package com.github.frankkwok.tij4.holding;

import com.github.frankkwok.tij4.util.TextFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page 317
 * Exercise 16: Create a Set of the vowels. Working from UniqueWords.Java, count and display the number of vowels in
 * each input word, and also display the total number of vowels in the input file.
 * <p>
 * Page 320
 * Exercise 20: Modify Exercise 16 so that you keep a count of the occurrence of each vowel.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class Vowels {
    public static void main(String[] args) {
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);

        List<String> list = new TextFile(".gitignore", "\\W+");

        int totalCount = 0;
        for (String string : list) {
            char[] chars = string.toLowerCase().toCharArray();
            int count = 0;
            for (char c : chars) {
                if (vowels.keySet().contains(c)) {
                    count++;
                    vowels.put(c, vowels.get(c) + 1);
                }
            }
            totalCount += count;
            System.out.println(string + " contains " + count + " vowels.");
        }
        System.out.println("All strings contains " + totalCount + " vowels.");
        System.out.println(vowels);
    }
}
