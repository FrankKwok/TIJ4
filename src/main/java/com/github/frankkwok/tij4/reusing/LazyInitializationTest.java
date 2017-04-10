package com.github.frankkwok.tij4.reusing;

/**
 * Page 189
 * Exercise 1: Create a simple class. Inside a second class, define a reference to an object of the first class. Use
 * lazy initialization to instantiate this object.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class LazyInitializationTest {
    private LazyInitialization li;

    public static void main(String[] args) {
        System.out.println("Create LazyInitializationTest: ");
        LazyInitializationTest lt = new LazyInitializationTest();
        System.out.println("\nPrint LazyInitializationTest: ");
        System.out.println(lt);
    }

    @Override
    public String toString() {
        if (li == null) {
            li = new LazyInitialization();
        }
        return "li=" + li;
    }
}

class LazyInitialization {
    LazyInitialization() {
        System.out.println("Create LazyInitialization");
    }

    @Override
    public String toString() {
        return "LazyInitialization";
    }
}
