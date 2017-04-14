package com.github.frankkwok.tij4.innerclasses;

import java.util.Random;

/**
 * Page 278
 * Exercise 17: Modify the solution to Exercise 19 from the Interfaces chapter to use anonymous inner classes.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class TossingFactoryTest {
    public static void main(String[] args) {
        toss(CoinTossing.tossingFactory);
        toss(DiceTossing.tossingFactory);
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
    public static TossingFactory tossingFactory = CoinTossing::new;
    private Random random = new Random();

    @Override
    public int toss() {
        return random.nextInt(2);
    }
}

class DiceTossing implements Tossing {
    public static TossingFactory tossingFactory = DiceTossing::new;
    private Random random = new Random();

    @Override
    public int toss() {
        return random.nextInt(6) + 1;
    }
}
