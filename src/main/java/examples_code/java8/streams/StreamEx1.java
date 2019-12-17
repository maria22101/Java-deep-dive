package examples_code.java8.streams;

import java.util.Arrays;
import java.util.List;

public class StreamEx1 {
    public static void main(String[] args) {

        // map
        List<Integer> arr = Arrays.asList(1, 3, 5, 7, 12, 4);
        arr.stream()
                .map(a -> a * a)
                .forEach(System.out::println);

        // map, reduce
        int sumOfElementsSquared = arr
                .stream()
                .map(a -> a * a)
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sumOfElementsSquared);
        int sumOfElements = arr
                .stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sumOfElements);

        //count
        long count = arr.stream()
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(count);


    }
}
