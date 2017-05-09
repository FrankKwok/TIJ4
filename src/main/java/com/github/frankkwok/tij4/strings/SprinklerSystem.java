package com.github.frankkwok.tij4.strings;

/**
 * Page 381
 * Exercise 1: Analyze SprinklerSystem.toString( ) in reusing/SprinklerSystem.java to discover whether writing the
 * toString( ) with an explicit StringBuilder will save any StringBuilder creations.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class SprinklerSystem {
    private String valve1, valve2, valve3, valve4;
    private WaterSource source = new WaterSource();
    private int i;
    private float f;

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("valve1 = ");
        builder.append(valve1);
        builder.append(" ");
        builder.append("valve2 = ");
        builder.append(valve2);
        builder.append(" ");
        builder.append("valve3 = ");
        builder.append(valve3);
        builder.append("\n");
        builder.append("i = ");
        builder.append(i);
        builder.append(" ");
        builder.append("f = ");
        builder.append(f);
        builder.append(" ");
        builder.append("source = ");
        builder.append(source);
        return builder.toString();
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklers = new SprinklerSystem();
        System.out.println(sprinklers);
    }
}

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    public String toString() {
        return s;
    }
}
