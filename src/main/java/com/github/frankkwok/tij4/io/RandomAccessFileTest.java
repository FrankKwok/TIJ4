package com.github.frankkwok.tij4.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Page 694
 * Exercise 16: Look up RandomAccessFile in the JDK documentation. Starting with UsingRandomAccessFile.java, create a
 * program that stores and then retrieves all the different possible types provided by the RandomAccessFile class.
 * Verify that the values are stored and retrieved accurately.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class RandomAccessFileTest {
    private static final String FILE_NAME = "RandomAccessFileTest.out";

    public static void main(String[] args) {
        String string = "hello,world";
        try (RandomAccessFile ras = new RandomAccessFile(FILE_NAME, "rw")) {
            ras.writeBoolean(true);
            ras.writeByte(2);
            ras.writeShort(3);
            ras.writeChar('d');
            ras.writeInt(5);
            ras.writeLong(6L);
            ras.writeFloat(7.0F);
            ras.writeDouble(8.0);
            ras.writeUTF(string);

            ras.seek(0);

            System.out.println(ras.readBoolean());
            System.out.println(ras.readByte());
            System.out.println(ras.readShort());
            System.out.println(ras.readChar());
            System.out.println(ras.readInt());
            System.out.println(ras.readLong());
            System.out.println(ras.readFloat());
            System.out.println(ras.readDouble());
            System.out.println(ras.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
