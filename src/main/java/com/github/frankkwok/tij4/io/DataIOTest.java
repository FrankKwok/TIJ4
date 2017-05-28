package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 692
 * Exercise 15: Look up DataOutputStream and DataInputStream in the JDK documentation. Starting with
 * StoringAndRecoveringData.java, create a program that stores and then retrieves all the different possible types
 * provided by the DataOutputStream and DataInputStream classes. Verify that the values are stored and retrieved
 * accurately.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class DataIOTest {
    private static final String FILE_NAME = "DataIOTest.out";

    public static void main(String[] args) {
        String string = "hello,world";
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeBoolean(true);
            out.writeByte(2);
            out.writeShort(3);
            out.writeChar('d');
            out.writeInt(5);
            out.writeLong(6L);
            out.writeFloat(7.0F);
            out.writeDouble(8.0);
            out.writeUTF(string);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println(in.readBoolean());
            System.out.println(in.readByte());
            System.out.println(in.readShort());
            System.out.println(in.readChar());
            System.out.println(in.readInt());
            System.out.println(in.readLong());
            System.out.println(in.readFloat());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
