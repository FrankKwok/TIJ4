package com.github.frankkwok.tij4.io;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Page 732
 * Exercise 28 : In Blips.java, copy the file and rename it to BlipCheck.java and rename the class Blip2 to BlipCheck
 * (making it public and removing the public scope from the class Blips in the process). Remove the //! marks in the
 * file and execute the program, including the offending lines. Next, comment out the default constructor for BlipCheck.
 * Run it and explain why it works. Note that after compiling, you must execute the program with "Java Blips" because
 * the main( ) method is still in the class Blips.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class BlipCheck implements Externalizable {
    /*BlipCheck() {
        System.out.println("BlipCheck Constructor");
    }*/

    @Override
    public void writeExternal(ObjectOutput out)
            throws IOException {
        System.out.println("BlipCheck.writeExternal");
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("BlipCheck.readExternal");
    }
}
