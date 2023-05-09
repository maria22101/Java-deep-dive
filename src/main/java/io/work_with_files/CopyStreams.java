package io.work_with_files;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * {@link CopyStreams} demonstrates unified usage of different implementations of
 * InputStream while copying bytes from different sources
 */
public class CopyStreams {
    private static final String SOURCE_FILE_NAME = "src/main/java/io/basics/text-file.txt";
    private static final String DESTINATION_FILE_NAME = "src/main/java/io/basics/text-file_copy.txt";
    private static final String SOURCE_URL = "https://www.udemy.com/user/devstudy-net/";
    private static final String DESTINATION_FILE_FOR_URL = "src/main/java/io/basics/devstudy-net.html/";
    private static final String TEXT_FILE_NAME = "src/main/java/io/basics/text.txt";

    public static void main(String[] args) throws IOException {
        // case 1: copying from file to file
        try (InputStream in = new FileInputStream(SOURCE_FILE_NAME);
             OutputStream out = new FileOutputStream(DESTINATION_FILE_NAME)) {
            System.out.println(copy(in, out) + " bytes copied while copying file to file");
        }

        // case 2: copying from html to file
        try(InputStream in = new URL(SOURCE_URL).openStream();
            OutputStream out = new FileOutputStream(DESTINATION_FILE_FOR_URL)) {
            System.out.println(copy(in, out) + " bytes copied while copying html to file");
        }

        // case 3: copying a string to file
        String text = "This text should be saved into file";
        try(InputStream in = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
            OutputStream out = new FileOutputStream(TEXT_FILE_NAME)) {
            System.out.println(copy(in, out) + " bytes copied while copying string to file");
        }
    }

    private static long copy(InputStream in, OutputStream out) throws IOException {
        long countCopied = 0;
        byte[] buffer = new byte[4096];
        while (true) {
            int read = in.read(buffer);
            if (read == -1) {
                break;
            }
            out.write(buffer, 0, read);
            countCopied += read;
        }
        out.flush(); // required for output streams that support buffering
        return countCopied;
    }
}
