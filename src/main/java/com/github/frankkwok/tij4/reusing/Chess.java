package com.github.frankkwok.tij4.reusing;

/**
 * Page 193
 * Exercise 6: Using Chess.java, prove the statements in the previous paragraph.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class Chess extends BoardGame {
    Chess() {
        super(11);
        System.out.println("Chess constructor");
//        super(11);
    }

    public static void main(String[] args) {

    }
}

class Game {
    Game(int i) {
        System.out.println("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }
}
