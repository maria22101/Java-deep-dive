package examples_code.java8.streams;

import java.util.Arrays;
import java.util.List;

public class MatchEx {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 5);

        boolean match1 = list
                .stream()
                .anyMatch(x -> x > 4);
        System.out.println(match1);

        boolean match2 = list
                .stream()
                .allMatch(x -> x % 2 != 0);
        System.out.println(match2);

        boolean match3 = list
                .stream()
                .noneMatch(x -> x % 2 == 0);
        System.out.println(match3);
    }
}
