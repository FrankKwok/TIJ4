package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 727
 * Exercise 27: (1) Create a Serializable class containing a reference to an object of a second Serializable class.
 * Create an instance of your class, serialize it to disk, then restore it and verify that the process worked correctly.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class SerialTest implements Serializable {
    private static final String FILE_NAME = "SerialTest.out";
    private String string;

    public SerialTest(String string) {
        this.string = string;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            SerialTest test = new SerialTest("hello, world");
            out.writeObject(test);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            SerialTest test = (SerialTest) in.readObject();
            System.out.println(test);
        }
    }

    @Override
    public String toString() {
        return string;
    }
}
