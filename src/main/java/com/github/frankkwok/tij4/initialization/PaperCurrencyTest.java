package com.github.frankkwok.tij4.initialization;

/**
 * Page 165
 * Exercise 21: Create an enum of the least-valuable six types of paper currency. Loop through the values( ) and print
 * each value and its ordinal( ).
 * Exercise 22: Write a switch statement for the enum in the previous example. For each case, output a description of
 * that particular currency.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class PaperCurrencyTest {
    public static void main(String[] args) {
        for (PaperCurrency pc : PaperCurrency.values()) {
            switch (pc) {
                case ONE:
                    System.out.println("￥1");
                    break;
                case FIVE:
                    System.out.println("￥5");
                    break;
                case TEN:
                    System.out.println("￥10");
                    break;
                case TWENTY:
                    System.out.println("￥20");
                    break;
                case FIFTY:
                    System.out.println("￥50");
                    break;
                case HUNDRED:
                    System.out.println("￥100");
                    break;
            }
        }
    }
}

enum PaperCurrency {
    ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
}
