package examples_code.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringWithHashTag {

    public static void main(String[] args) {
        // List of sentences with words with hashtags
        // Return List of words with hashtags sorted by their occurrences

        String s1 = "Beautiful #word #my #beauty #beautyful, #beautiful";
        String s2 = "#word";
        String s3 = "#word #my";
        List<String> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        List<String> hashTagsSorted = list.stream()
                .map(tweet -> tweet.split(" "))
                .flatMap(arrayOfString -> Stream.of(arrayOfString))
                .filter(str -> str.startsWith("#"))
                .collect(Collectors.groupingBy(str -> str, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(hashTagsSorted);
    }
}
