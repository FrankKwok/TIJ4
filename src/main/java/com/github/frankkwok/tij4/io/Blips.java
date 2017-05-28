package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 732
 * Exercise 28 : In Blips.java, copy the file and rename it to BlipCheck.java and rename the class Blip2 to BlipCheck
 * (making it public and removing the public scope from the class Blips in the process). Remove the //! marks in the
 * file and execute the program, including the offending lines. Next, comment out the default constructor for BlipCheck.
 * Run it and explain why it works. Note that after compiling, you must execute the program with "Java Blips" because
 * the main( ) method is still in the class Blips.
 * <p>
 * Because the compiler will generate an empty public constructor for a public class that without a constructor.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects:");
        Blip1 b1 = new Blip1();
        BlipCheck b2 = new BlipCheck();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(b1);
        o.writeObject(b2);
        o.close();
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        b1 = (Blip1) in.readObject();
        System.out.println(b1);
        System.out.println("Recovering b2:");
        b2 = (BlipCheck) in.readObject();
        System.out.println(b2);
    }
}

class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 Constructor");
    }

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("Blip1.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip1.readExternal");
    }
}
