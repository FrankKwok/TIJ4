package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 639
 * Exercise 26: Add a char field to CountedString that is also initialized in the constructor, and modify the hashCode()
 * and equals() methods to include the value of this char.
 * Exercise 27: Modify the hashCode( ) in CountedString.java by removing the combination with id, and demonstrate that
 * CountedString still works as a key. What is the problem with this approach?
 * Hash冲突会变多
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class CountedString {
    private static List<String> created = new ArrayList<>();

    private String string;
    private int id = 0;
    private char c;

    public CountedString(String string, char c) {
        this.string = string;
        this.c = c;
        created.add(this.string);
        for (String s : created) {
            if (s.equals(this.string)) {
                id++;
            }
        }
    }

    public static void main(String[] args) {
        Map<CountedString, Integer> map = new HashMap<>();
        CountedString[] cs = new CountedString[5];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = new CountedString("hi", 'c');
            map.put(cs[i], i);
        }
        System.out.println(map);
        for (CountedString cstring : cs) {
            System.out.println("Looking up " + cstring);
            System.out.println(map.get(cstring));
        }
    }

    @Override
    public String toString() {
        return "String: " + string + " id: " + id + " hashCode(): " + hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(string, c);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof CountedString)) {
            return false;
        }
        CountedString other = (CountedString) otherObject;
        return Objects.equals(string, other.string) && id == other.id && c == other.c;
    }
}
