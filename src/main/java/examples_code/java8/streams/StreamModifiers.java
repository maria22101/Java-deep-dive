package examples_code.java8.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamModifiers {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Ann", "Alen", "Becca", "Alen", "Ann");

        // get unique elements of the list
        List<String> newList1 = list
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(newList1);

        // get sorted stream
        List<String> newList2 = list
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(newList2);

        // get sorted stream in reverse order
        List<String> newList3 = list
                .stream()
                .sorted(Comparator.comparing(String::valueOf).reversed())
                .collect(Collectors.toList());
        System.out.println(newList3);
    }
}
