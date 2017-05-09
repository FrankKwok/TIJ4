package com.github.frankkwok.tij4.exceptions;

/**
 * Page 362
 * Exercise 20: Modify StormyInning.java by adding an UmpireArgument exception type and methods that throw this
 * exception. Test the modified hierarchy.
 * <p>
 * Page 373
 * Exercise 29: Modify all the exception types in Stormylnning.java so that they extend RuntimeException, and show that
 * no exception specifications or try blocks are necessary. Remove the ‘//!’ comments and show how the methods can be
 * compiled without specifications.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class StormyInning extends Inning implements Storm {
    public StormyInning() throws RainedOut, BaseballException {
    }

    public StormyInning(String s) throws Foul, BaseballException {
    }

    public static void main(String[] args) {
        StormyInning si = new StormyInning();
        si.atBat();
        Inning i = new StormyInning();
        i.atBat();
    }

    @Override
    public void walk() throws PopFoul {
    }

    @Override
    public void event() throws RainedOut {
    }

    @Override
    public void rainHard() throws RainedOut {
    }

    /*@Override
    public void event() {
    }*/

    @Override
    public void atBat() throws PopFoul {
    }
}

class BaseballException extends RuntimeException {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

class UmpireArgument extends RuntimeException {

}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {
    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() throws UmpireArgument {
    }
}

class StormException extends RuntimeException {
}

class RainedOut extends StormException {
}

class PopFoul extends Foul {
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}
