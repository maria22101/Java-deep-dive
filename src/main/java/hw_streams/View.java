package hw_streams;

import java.util.Arrays;

/**
 * Created by Bilous M. 18.12.2019
 */
public class View {
    public void printMessage(String str) {
        System.out.println(str);
    }

    public String concatenatedString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String s : message) {
            concatString.append(s);
        }
        return new String(concatString);
    }

    public String arrayInString(int[] arr) {
        return Arrays.toString(arr);
    }
}
