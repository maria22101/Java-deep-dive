package examples_code.java8.streams_hw_lab;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Task_2: transform a list of Strings into uppercase and then descending.
 * Created by Bilous M. 14.04.2020
 */
public class StringToUpperCaseDesc {
    public static List<String> getUpperCaseAndDescending(List<String> str) {
        return str.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("El");
        names.add("Inga");
        names.add("Maison");
        names.add("Marissa");

        System.out.println(StringToUpperCaseDesc.getUpperCaseAndDescending(names));
    }
}
