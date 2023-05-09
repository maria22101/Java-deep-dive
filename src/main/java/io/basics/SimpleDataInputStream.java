package io.basics;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * {@link SimpleDataInputStream} demonstrates {@link java.io.DataInputStream} & {@link java.io.DataOutputStream}
 * usage for writing and reading primitive java data types
 */
public class SimpleDataInputStream {
    private static final String SOURCE_FILE = "dataOut.txt";

    public static void main(String[] args) {

        try (DataOutputStream out =
                     new DataOutputStream( // stream of bytes
                                 new BufferedOutputStream( // buffered
                                         new FileOutputStream(SOURCE_FILE)));
             DataInputStream in =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(SOURCE_FILE)
                             )
                     )) { //if no relative or absolute path indicated, file will be written to the root (scr)

            //writing to a source file:
            out.writeShort(1000);
            out.writeInt(111);
            out.writeLong(222L);
            out.writeUTF("Hello World");
            out.flush(); // clearing buffer and pushing all values

            //reading from the source file and outputting to the console:
            System.out.println("Short: " + in.readShort());
            System.out.println("Int " + in.readInt());
            System.out.println("Long " + in.readLong());
            System.out.println("UTF " + in.readUTF());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
