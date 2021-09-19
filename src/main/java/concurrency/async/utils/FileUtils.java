package concurrency.async.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void getStatistic(String fromFilePath, String toFilePath) {
        String[] strings = readFromFile(fromFilePath);
        String report = createReport(strings);
        writeToFile(report, toFilePath);
    }

    private static String[] readFromFile(String fromFilePath) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] plainArray = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFilePath))){
            int value = bufferedReader.read();
            while (value != -1) {
                stringBuilder.append((char) value);
                value = bufferedReader.read();
            }
            String wordsWithoutEnter = stringBuilder.toString()
                    .replaceAll("\n", ",")
                    .replaceAll("\r", "");
            plainArray = wordsWithoutEnter.split(",");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plainArray;
    }

    private static String createReport(String[] array) {
        int supply = 0;
        int buy = 0;
        for (int i = 0; i < array.length; i = i + 2) {
            if(array[i].equals("supply")) {
                supply += Integer.parseInt(array[i + 1]);
            } else if (array[i].equals("buy")) {
                buy += Integer.parseInt(array[i + 1]);
            }
        }
        return  "supplied : " + supply + "\n" +
                "bought: " + buy + "\n" +
                "current stock: " + (supply - buy);
    }

    private static void writeToFile(String reportResult, String toFilePath) {
        File file = new File(toFilePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file");
        }

        try (final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(reportResult);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to a file");
        }
    }
}
