package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 11: Turn the AllTheColorsOfTheRainbow example into a program that compiles and runs.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class AllTheColorsOfTheRainbow {
    private int anIntegerRepresentingColors;

    public static void main(String[] args) {
        AllTheColorsOfTheRainbow a = new AllTheColorsOfTheRainbow();
        System.out.println("color int: " + a.anIntegerRepresentingColors);
        a.changeTheHueOfTheColor(5);
        System.out.println("color int: " + a.anIntegerRepresentingColors);
    }

    private void changeTheHueOfTheColor(int newHue) {
        anIntegerRepresentingColors = newHue;
    }
}
