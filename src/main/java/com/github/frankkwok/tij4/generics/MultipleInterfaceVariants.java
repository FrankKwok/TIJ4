package com.github.frankkwok.tij4.generics;

/**
 * Page 518
 * Exercise 31: Remove all the generics from MultipleInterfaceVariants.java and modify the code so that the example
 * compiles.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class MultipleInterfaceVariants {
    public static void main(String[] args) {

    }
}

interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}
