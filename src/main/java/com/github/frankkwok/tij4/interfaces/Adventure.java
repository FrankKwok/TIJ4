package com.github.frankkwok.tij4.interfaces;

/**
 * Page 253
 * Exercise 12: In Adventure.java, add an interface called CanClimb, following the form of the other interfaces.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class Adventure {
    public static void main(String[] args) {
        Hero h = new Hero();
        t(h);
        u(h);
        v(h);
        w(h);
        x(h);
    }

    public static void t(CanFight x) {
        x.fight();
    }

    private static void u(CanSwim x) {
        x.swim();
    }

    private static void v(CanFly x) {
        x.fly();
    }

    private static void w(ActionCharacter x) {
        x.fight();
    }

    private static void x(CanClimb x) {
        x.climb();
    }
}

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly, CanClimb {
    @Override
    public void swim() {
    }

    @Override
    public void fly() {
    }

    @Override
    public void climb() {

    }
}

interface CanClimb {
    void climb();
}
