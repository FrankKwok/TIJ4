package com.github.frankkwok.tij4.enumerated;

import java.util.*;

/**
 * Page 759
 * Exercise 5: Modify control/VowelsAndConsonants.java so that it uses three enum types: VOWEL, SOMETIMES_A_VOWEL, and
 * CONSONANT. The enum constructor should take the various letters that describe that particular category. Hint: Use
 * varargs, and remember that varargs automatically creates an array for you.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class VowelsAndConsonants {
    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            int c = rand.nextInt(26) + 'a';
            System.out.print((char) c + ", " + c + ": ");
            switch (Alphabet.type((char) c)) {
                case VOWEL:
                    System.out.println("vowel");
                    break;
                case SOMETIMES_A_VOWEL:
                    System.out.println("Sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }
}

enum Alphabet {
    VOWEL('a', 'e', 'i', 'o', 'u'), SOMETIMES_A_VOWEL('y', 'w'), CONSTANT();

    private Collection<Character> characters;

    Alphabet(char... chars) {
        List<Character> charList = new ArrayList<>();
        for (char c : chars) {
            charList.add(c);
        }
        characters = Collections.unmodifiableCollection(charList);
    }

    public static Alphabet type(char c) {
        if (VOWEL.characters.contains(c)) {
            return VOWEL;
        } else if (SOMETIMES_A_VOWEL.characters.contains(c)) {
            return SOMETIMES_A_VOWEL;
        } else {
            return CONSTANT;
        }
    }
}
