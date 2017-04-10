package com.github.frankkwok.tij4.reusing;

/**
 * Page 191
 * Exercise 2: Inherit a new class from class Detergent. Override scrub( ) and add a new method called sterilize( ).
 * Exercise 11: Modify Detergent.java so that it uses delegation.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class LaundryDetergent {
    private Detergent detergent = new Detergent();

    public static void main(String[] args) {
        LaundryDetergent x = new LaundryDetergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        x.sterilize();
        System.out.println(x);
        System.out.println("Testing base classes:");
        Detergent.main(args);
    }

    void sterilize() {
        append(" sterilize()");
    }

    void foam() {
        detergent.foam();
    }

    void append(String a) {
        detergent.append(a);
    }

    void dilute() {
        detergent.dilute();
    }

    void apply() {
        detergent.apply();
    }

    void scrub() {
        append(" LaundryDetergent.scrub()");
        detergent.scrub();
    }

    public String toString() {
        return detergent.toString();
    }
}

class Cleanser {
    private String s = "Cleanser";

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        System.out.println(x);
    }

    void append(String a) {
        s += a;
    }

    void dilute() {
        append(" dilute()");
    }

    void apply() {
        append(" apply()");
    }

    void scrub() {
        append(" scrub()");
    }

    @Override
    public String toString() {
        return s;
    }
}

class Detergent {
    private Cleanser cleanser = new Cleanser();

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        System.out.println(x);
        System.out.println("Testing base class:");
        Cleanser.main(args);
    }

    void foam() {
        append(" foam()");
    }

    void append(String a) {
        cleanser.append(a);
    }

    void dilute() {
        cleanser.dilute();
    }

    void apply() {
        cleanser.apply();
    }

    void scrub() {
        append(" Detergent.scrub()");
        cleanser.scrub();
    }

    public String toString() {
        return cleanser.toString();
    }
}
