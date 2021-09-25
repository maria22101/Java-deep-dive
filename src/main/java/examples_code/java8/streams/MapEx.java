package examples_code.java8.streams;

import examples_code.java8.lambda.User;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapEx {
    public static void main(String[] args) {

        // new list with modified members
        List<Integer> numbers = Arrays.asList(2, 5, 10, 20);
        List<Integer> numbersDoubled = numbers
                .stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
        numbersDoubled.forEach(System.out::println);

        // list members capitalized
        List<String> names = Arrays.asList("eve", "ken", "arin");
        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Objects to String
        List<User> users = Arrays.asList(
                new User("Mari", 40),
                new User("Ann", 35),
                new User ("Dave", 24)
        );
        List<Integer> usersNames = users
                .stream().map(User::getAge)
                .collect(Collectors.toList());
        usersNames.forEach(System.out::println);

        // group elements depending on it is even (true) or odd (false)
        Map<Boolean, List<Integer>> partitionedMap = Stream.generate(() -> Math.random() * 50)
                .map(p -> p.intValue())
                .distinct()
                .limit(10)
                .collect(
                        Collectors.partitioningBy(
                                new Predicate<Integer>() {
                                    @Override
                                    public boolean test(Integer integer) {
                                        return integer % 2 == 0;
                                    }
                                }
                        )
                );
        System.out.println(partitionedMap);
    }
}
