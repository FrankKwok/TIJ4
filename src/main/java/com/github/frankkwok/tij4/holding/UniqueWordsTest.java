package com.github.frankkwok.tij4.holding;

import com.github.frankkwok.tij4.util.TextFile;

import java.util.*;

/**
 * Page 320
 * Exercise 21: Using a Map<String,Integer>, follow the form of UniqueWords.java to create a program that counts the
 * occurrence of words in a file. Sort the results using Collections.sort( ) with a second argument of
 * String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort), and display the result.
 * <p>
 * Page 320
 * Exercise 22: Modify the previous exercise so that it uses a class containing a String and a count field to store each
 * different word, and a Set of these objects to maintain the list of words.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class UniqueWordsTest {
    public static void main(String[] args) {
        List<String> list = new TextFile(".gitignore", "\\W+");

        Map<String, Integer> map = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (String string : list) {
            map.put(string, map.getOrDefault(string, 0) + 1);
        }
        System.out.println(map);

        Set<StringCount> set = new TreeSet<>();
        for (String string : list) {
            StringCount sc = containsWord(set, string);
            if (sc == null) {
                sc = new StringCount(string);
                set.add(sc);
            } else {
                sc.addCount();
            }
        }
        System.out.println(set);
    }

    private static StringCount containsWord(Set<StringCount> set, String string) {
        StringCount stringCount = null;
        for (StringCount sc : set) {
            if (sc.getWord().equals(string)) {
                stringCount = sc;
            }
        }
        return stringCount;
    }
}

class StringCount implements Comparable<StringCount> {
    private String word;
    private int count;

    public StringCount(String word) {
        this.word = word;
        count = 1;
    }

    public String getWord() {
        return word;
    }

    public void addCount() {
        count++;
    }

    @Override
    public int compareTo(StringCount other) {
        return String.CASE_INSENSITIVE_ORDER.compare(word, other.word);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        StringCount other = (StringCount) otherObject;
        return Objects.equals(word, other.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + "=" + count;
    }
}
