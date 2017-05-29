package com.github.frankkwok.tij4.util;

import java.util.Random;

/**
 * @author Frank Kwok on 2017/5/29.
 */
public class Enums {
    private static Random rand = new Random();

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
