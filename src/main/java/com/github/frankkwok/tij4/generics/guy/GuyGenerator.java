package com.github.frankkwok.tij4.generics.guy;

import com.github.frankkwok.tij4.util.Generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Frank Kwok on 2017/5/16.
 */
public class GuyGenerator implements Generator<StoryCharacters> {
    private static List<Class<? extends StoryCharacters>> goodGuys = new ArrayList<>();
    private static List<Class<? extends StoryCharacters>> badGuys = new ArrayList<>();

    static {
        goodGuys.add(ABao.class);
        goodGuys.add(Alice.class);
        goodGuys.add(Batman.class);
        goodGuys.add(WhiteQueen.class);

        badGuys.add(DaLong.class);
        badGuys.add(Joker.class);
        badGuys.add(RedQueen.class);
    }

    private Random random = new Random();

    public static void main(String[] args) {
        GuyGenerator guyGenerator = new GuyGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(guyGenerator.next());
        }
    }

    @Override
    public StoryCharacters next() {
        Class<? extends StoryCharacters> clazz;
        if (Math.random() < 0.5) {
            clazz = goodGuys.get(random.nextInt(goodGuys.size()));
        } else {
            clazz = badGuys.get(random.nextInt(badGuys.size()));
        }

        try {
            return clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
