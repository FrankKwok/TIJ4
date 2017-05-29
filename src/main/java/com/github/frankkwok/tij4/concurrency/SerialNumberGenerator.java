package com.github.frankkwok.tij4.concurrency;

/**
 * Page 858
 * Exercise 13: Repair SerialNumberChecker.java using the synchronized keyword. Can you demonstrate that it is now
 * correct?
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    static synchronized int nextSerialNumber() {
        return serialNumber++;
    }
}
