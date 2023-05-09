package io.basics;

import java.io.ByteArrayInputStream;

/**
 * {@link SimpleByteArrayInputStream} class demonstrates usage of {@link java.io.ByteArrayInputStream}
 */
public class SimpleByteArrayInputStream {
    public static void main(String[] args) {

        byte[] arr = new byte[] {1, 4, 6, 3};
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arr);
        int temp;
        while ((temp = byteArrayInputStream.read()) != -1) {
            System.out.println(temp);
        }
        // output: 1, 4, 6, 3

        String str = "Hello";
        byte[] arr2 = str.getBytes();
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(arr2, 1, 3); // start from 2nd symbol and capture 3 symbols
        int temp2;
        while ((temp2 = byteArrayInputStream2.read()) != -1) {
            System.out.println((char) temp2);
        }
        // output: e l l
    }
}
