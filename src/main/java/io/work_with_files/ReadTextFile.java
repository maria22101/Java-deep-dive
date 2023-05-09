package io.work_with_files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;

/**
 * {@link ReadTextFile} class has utility methods of reading a file
 */
public class ReadTextFile {
    private static final String FILE_PATH = "src/main/java/io/basics/text-file.txt";

    public static void main(String[] args) throws IOException {
        readLinesFromTextFile(FILE_PATH);
        readTextFromTextFile(FILE_PATH);
        readCharsFromTextFile(FILE_PATH);
    }

    public static void readLinesFromTextFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("can't read from file");
        }
    }

    public static void readTextFromTextFile(String filePath) {
        StringWriter stringWriter = new StringWriter();
        char[] buffer = new char[8192];
        try (Reader reader = new FileReader(filePath)) {
            while (true) {
                int readTexts = reader.read(buffer); // reading text from the file into the char array
                if (readTexts == -1) {
                    break;
                }
                stringWriter.write(buffer, 0, readTexts);
            }
        } catch (IOException e) {
            System.out.println("can't read from file");
        }
        System.out.println(stringWriter);
    }

    public static void readCharsFromTextFile(String filePath) {
        StringBuilder result = new StringBuilder();
        try (Reader reader = new FileReader(filePath)) {
            while (true) {
                int symbol = reader.read();
                if (symbol == -1) {
                    break;
                }
                result.append((char) symbol);
            }
        } catch (IOException e) {
            System.out.println("can't read from file");
        }
        System.out.println(result);
    }
}
