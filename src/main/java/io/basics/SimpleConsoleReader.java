package io.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * {@link SimpleConsoleReader} reads a line from the console.
 * Class demonstrates transformation of InputStream (bytes) to BufferedReader(characters) by using
 * {@link java.io.InputStreamReader} & {@link java.io.BufferedReader}
 */
public class SimpleConsoleReader {

    public static String readFromConsole() {
        String lineFromConsole = null;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) { // System.in returns InputStream
            lineFromConsole = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineFromConsole;
    }

    public static void main(String[] args) {
        System.out.println(readFromConsole());
    }
}
