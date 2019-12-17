package examples_code.java8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class MethodReference {

    static Integer parseIntAndSquared(String x) {
        return Integer.parseInt(x) * Integer.parseInt(x);
    }

    public static void main(String[] args) {

        Function<String, Integer> function1 = (x) -> Integer.parseInt(x);
        Integer integer1 = function1.apply("3");

        Function<String, Integer> function2 = Integer::parseInt;
        Integer integer2 = function2.apply("4");

        Function<String, Integer> function3 = MethodReference::parseIntAndSquared;
        Integer integer3 = function3.apply("2");
        System.out.println(integer3);

        Function<String, String> stringFunction = String::trim;
        String str = stringFunction
                .andThen(String::toUpperCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(" abc ");
        System.out.println(str);

        List<User> users = Arrays.asList(
                new User("Mari", 40),
                new User("Ann", 35),
                new User ("Dave", 24)
        );
        users.sort(Comparator.comparing(User::getName));
        users.forEach(System.out::println);

    }
}
