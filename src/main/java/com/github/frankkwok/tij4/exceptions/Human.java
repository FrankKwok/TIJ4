package com.github.frankkwok.tij4.exceptions;

/**
 * Page 374
 * Exercise 30: Modify Human.java so that the exceptions inherit from RuntimeException. Modify main( ) so that the
 * technique in TurnOffChecking.java is used to handle the different types of exceptions.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Human {
    public static void main(String[] args) {
        WrapCheckedException wce = new WrapCheckedException();
        wce.throwRuntimeException(3);
        for (int i = 0; i < 4; i++)
            try {
                if (i < 3)
                    wce.throwRuntimeException(i);
                else
                    throw new SomeOtherException();
            } catch (SomeOtherException e) {
                System.out.println("SomeOtherException: " + e);
            } catch (RuntimeException re) {
                try {
                    throw re.getCause();
                } catch (Sneeze e) {
                    System.out.println("Sneeze: " + e);
                } catch (Annoyance e) {
                    System.out.println("Annoyance: " + e);
                } catch (Throwable e) {
                    System.out.println("Throwable: " + e);
                }
            }
    }
}

class WrapCheckedException {
    void throwRuntimeException(int type) {
        try {
            switch (type) {
                case 0:
                    throw new Sneeze();
                case 1:
                    throw new Annoyance();
                case 2:
                    throw new RuntimeException("Where am I?");
                default:
                    return;
            }
        } catch (Exception e) { // Adapt to unchecked:
            throw new RuntimeException(e);
        }
    }
}

class Annoyance extends RuntimeException {
}

class Sneeze extends Annoyance {
}

class SomeOtherException extends Exception {
}
