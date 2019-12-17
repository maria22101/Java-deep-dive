package examples_code.java8.streams;

import com.sun.xml.internal.ws.util.StringUtils;
import examples_code.java8.lambda.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
                .map(StringUtils::capitalize)
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
    }
}
