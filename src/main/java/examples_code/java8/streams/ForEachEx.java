package examples_code.java8.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachEx {

    public static void main(String[] args) {

        // forEach with condition
        List<Integer> numbers = Arrays.asList(2, 6, 5, 8, 10);
        numbers.forEach(num -> {
            if (num > 5) {
                System.out.println(num + " greater than 5");
            } else if (num < 5) {
                System.out.println(num + " less than 5");
            } else {
                System.out.println(num + " equal to 5");
            }
        });

        // forEach for map
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "first");
        map.put(2, "second");
        map.put(3, "third");
        map.forEach((k, v) -> System.out.println("Key: " + k + ", " + "Value: " + v));

    }
}
