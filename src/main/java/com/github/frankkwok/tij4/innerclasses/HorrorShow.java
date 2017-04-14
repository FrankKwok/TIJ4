package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 276
 * Exercise 14: Modify interfaces/HorrorShow.java to implement DangerousMonster and Vampire using anonymous classes.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class HorrorShow {
    public static void main(String[] args) {
        DangerousMonster barney = new DangerousMonster() {
            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };
        u(barney);
        v(barney);
        Vampire vlad = new Vampire() {
            @Override
            public void drinkBlood() {

            }

            @Override
            public void destroy() {

            }

            @Override
            public void kill() {

            }

            @Override
            public void menace() {

            }
        };
        u(vlad);
        v(vlad);
        w(vlad);
    }

    static void u(Monster b) {
        b.menace();
    }

    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }

    static void w(Lethal l) {
        l.kill();
    }
}

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

class DragonZilla implements DangerousMonster {
    public void menace() {
    }

    public void destroy() {
    }
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

class VeryBadVampire implements Vampire {
    public void menace() {
    }

    public void destroy() {
    }

    public void kill() {
    }

    public void drinkBlood() {
    }
}
