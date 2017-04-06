package com.github.frankkwok.tij4.control;

/**
 * Page 121
 * Exercise 6: Modify the two test( ) methods in the previous two programs so that they take two extra arguments, begin
 * and end, and so that testval is tested to see if it is within the range between (and including) begin and end.
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class IfElse2Test {
    public static void main(String[] args) {
        System.out.println(test(10, 5, 9));
        System.out.println(test(5, 10, 15));
        System.out.println(test(5, 5, 9));
    }

    private static int test(int testval, int begin, int end) {
        if (testval < begin) {
            return -1;
        } else if (testval > end) {
            return 1;
        } else {
            return 0;
        }
    }
}
