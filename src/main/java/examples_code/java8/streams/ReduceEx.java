package examples_code.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // sum of the list elements without stating an initial value
        Optional<Integer> sum = list
                .stream()
                .reduce((left, right) -> left + right); // can be written as Integer::sum
        sum.ifPresent(System.out::println);

        // sum of the list elements with stating an initial value (identity)
        Integer sumInt = list
                .stream()
                .reduce(11, (left, right) -> left + right);
        System.out.println(sumInt);

        // sum of the list elements multiplied by the identity
        Integer sumMult = list
                .stream()
                .reduce(10, (identity, val) -> identity * val, (left, right) -> left + right);
        System.out.println(sumMult);

        // find the list elements min value
        Integer min = list
                .stream()
                .reduce(Integer.MAX_VALUE, (left, right) -> left < right ? left : right);
        System.out.println(min);

        // find the longest string
        List<String> listString = Arrays.asList("Mia", "Maya", "Marvel");
        String longestStr = listString
                .stream()
                .reduce("", (left, right) -> left.length() > right.length() ? left : right);
        System.out.println(longestStr);
    }
}
