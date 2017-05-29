package com.github.frankkwok.tij4.enumerated;

import com.github.frankkwok.tij4.util.Generator;

import java.util.Random;

/**
 * Page 754
 * Exercise 2: Instead of implementing an interface, make next( ) a static method. What are the benefits and drawbacks
 * of this approach?
 *
 * static next()这种形式比较简单，清晰；实现接口的方式更具通用性，可以传参给需要接口的方法
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class EnumGeneratorTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(CartoonCharacter.next() + " ");
        }
    }
}

enum CartoonCharacter {
    SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;

    private static Generator<CartoonCharacter> generator = () -> {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    };

    static CartoonCharacter next() {
        return generator.next();
    }
}
