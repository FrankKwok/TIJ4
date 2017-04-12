package com.github.frankkwok.tij4.interfaces;

import java.util.Random;

/**
 * Page 263
 * Exercise 19: Create a framework using Factory Methods that performs both coin tossing and dice tossing.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class TossingFactoryTest {
    public static void main(String[] args) {
        toss(new CoinTossingFactory());
        toss(new DiceTossingFactory());
    }

    private static void toss(TossingFactory tossingFactory) {
        System.out.println("Tossing result " + tossingFactory.getTossing().toss());
    }
}

interface Tossing {
    int toss();
}

interface TossingFactory {
    Tossing getTossing();
}

class CoinTossing implements Tossing {
    private Random random = new Random();

    @Override
    public int toss() {
        return random.nextInt(2);
    }
}

class CoinTossingFactory implements TossingFactory {
    @Override
    public Tossing getTossing() {
        return new CoinTossing();
    }
}

class DiceTossing implements Tossing {
    private Random random = new Random();

    @Override
    public int toss() {
        return random.nextInt(6) + 1;
    }
}

class DiceTossingFactory implements TossingFactory {
    @Override
    public Tossing getTossing() {
        return new DiceTossing();
    }
}
