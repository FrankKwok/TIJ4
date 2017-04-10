package com.github.frankkwok.tij4.access;

/**
 * Page 183
 * Exercise 8: Following the form of the example Lunch.java, create a class called ConnectionManager that manages a
 * fixed array of Connection objects. The client programmer must not be able to explicitly create Connection objects,
 * but can only get them via a static method in ConnectionManager. When the ConnectionManager runs out of objects, it
 * returns a null reference. Test the classes in main( ).
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class Connection {
    Connection() {

    }

    public void connect() {
        System.out.println("Connection.connect()");
    }
}
