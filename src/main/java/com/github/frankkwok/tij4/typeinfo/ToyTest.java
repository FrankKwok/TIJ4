package com.github.frankkwok.tij4.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Page 420
 * Exercise 1: In ToyTest.java, comment out Toy’s default constructor and explain what happens.
 * Exercise 2: Incorporate a new kind of interface into ToyTest.java and verify that it is detected and displayed
 * properly.
 * <p>
 * Page 442
 * Exercise 19: In ToyTest.java, use reflection to create a Toy object using the non-default constructor.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class ToyTest {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("com.github.frankkwok.tij4.typeinfo.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e) {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());


        // use reflection create a Toy object using the non-default constructor
        Class<Toy> toyClass = Toy.class;
        try {
            Constructor<Toy> toyConstructor = toyClass.getConstructor(int.class);
            Toy toy = toyConstructor.newInstance(5);
            System.out.println(toy);
        } catch (NoSuchMethodException |
                IllegalAccessException |
                InstantiationException |
                InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }
}

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

interface AnotherInterface {

}

class Toy {
    /*Toy() {
    }*/

    Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, AnotherInterface {
    FancyToy() {
        super(1);
    }
}
