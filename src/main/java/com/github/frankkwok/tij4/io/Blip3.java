package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 732
 * Exercise 29: In Blip3.java, comment out the two lines after the phrases "You must do this:" and run the program.
 * Explain the result and why it differs from when the two lines are in the program.
 * <p>
 * if you implements Externalizable, you need to all the serialize process in your class
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 Constructor");
    }

    public Blip3(String x, int a) {
        System.out.println("Blip3(String x, int a)");
        s = x;
        i = a;
    }

    public static void main(String[] args)
            throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip3 b3 = new Blip3("A String ", 47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving object:");
        o.writeObject(b3);
        o.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3:");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }

    @Override
    public String toString() {
        return s + i;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal");
        // You must do this:
        /*out.writeObject(s);
        out.writeInt(i);*/
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.readExternal");
        // You must do this:
        /*s = (String) in.readObject();
        i = in.readInt();*/
    }
}
