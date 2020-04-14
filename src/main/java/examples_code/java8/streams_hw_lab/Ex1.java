package examples_code.java8.streams_hw_lab;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Task_1: a list of names is given. Return a string with the names which are on the odd indexes in form:
 * "1. Ivan, 3. Olga..."
 * Created by Bilous M. 14.04.2020
 */
public class Ex1 {
    public static String DOT = ".";

    public static void main(String[] args) {

        List<String> names =  Arrays.asList(
                "Ivan",
                "Mari",
                "Olga",
                "Mike",
                "Inga",
                "Maison",
                "Oprah");

        AtomicInteger a = new AtomicInteger();

        List<String> oddIndexNames = names
                .stream()
                .collect(Collectors.toMap(n -> String.valueOf(a.incrementAndGet()), m -> m))
                .entrySet()
                .stream()
                .filter(entry -> Integer.parseInt(entry.getKey()) % 2 != 0)
                .map(stringStringEntry -> stringStringEntry.getKey()
                        + DOT
                        + stringStringEntry.getValue())
                .collect(Collectors.toList());

        String oddSndexNamesJoined = oddIndexNames
                .stream()
                .collect(Collectors.joining(", "));

        System.out.println(oddSndexNamesJoined);
    }
}
