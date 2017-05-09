package com.github.frankkwok.tij4.strings;

import java.util.Formatter;

/**
 * Page 387
 * Exercise 4: Modify Receipt.java so that the widths are all controlled by a single set of constant values. The goal
 * is to allow you to easily change a width by changing a single value in one place.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Receipt {
    private double total = 0;
    private Formatter f = new Formatter(System.out);

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }

    public void printTitle() {
        String titleFormatString = titleFormatString(15, 5, 10);
        f.format(titleFormatString, "Item", "Qty", "Price");
        f.format(titleFormatString, "----", "---", "-----");
    }

    private static String titleFormatString(int w1, int w2, int w3) {
        return String.format("%%-%ds %%%ds %%%ds\n", w1, w2, w3);
    }

    public void print(String name, int qty, double price) {
        String formatString = formatString(15, 5, 10);
        f.format(formatString, name, qty, price);
        total += price;
    }

    private static String formatString(int nameWidth, int qtyWidth, int priceWidth) {
        return String.format("%%-%1$d.%1$ds %%%2$dd %%%3$d.2f\n", nameWidth, qtyWidth, priceWidth);
    }

    public void printTotal() {
        String totalFormatString = totalFormatString(15, 5, 10, 2);
        String titleFormatString = titleFormatString(15, 5, 10);
        f.format(totalFormatString, "Tax", "", total * 0.06);
        f.format(titleFormatString, "", "", "-----");
        f.format(totalFormatString, "Total", "",
                total * 1.06);
    }

    private static String totalFormatString(int w1, int w2, int w3, int p4) {
        return String.format("%%-%ds %%%ds %%%d.%df\n", w1, w2, w3, p4);
    }
}
