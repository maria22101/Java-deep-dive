package examples_code.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindEx {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Mia is smart", "Luke is handsome", "Java is effective", "Gretta is pretty");

        Optional<String> str1 = list
                .stream()
                .filter(s -> s.contains("pretty"))
                .findAny();
        System.out.println(str1);

        Optional<String> str2 = list
                .stream()
                .findFirst();
        System.out.println(str2);

        // for parallel streams: using findFirst() returns exactly first value with the requested occurrence
        Optional<String> str3 = list
                .stream()
                .filter(s -> s.contains("is"))
                .findFirst();
        System.out.println(str3);

    }
}
