package examples_code.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingEx {
    public static void main(String[] args) {

        // sorting the below list using different instruments
            List<User> users = Arrays.asList(
                    new User("Mari", 40),
                    new User("Ann", 35),
                    new User ("Dave", 24)
            );
        System.out.println("Before sort:");
        users.forEach(x -> System.out.println(x));

        Collections.sort(users, (x, y) -> x.getName().compareTo(y.getName()));
        System.out.println("After sort by name:");
        users.forEach(x -> System.out.println(x));

        users.sort((x, y) -> x.getAge() - y.getAge());
        System.out.println("After sort by age:");
        users.forEach(x -> System.out.println(x));

        Comparator<User> comp = (x, y) -> x.getName().compareTo(y.getName());
        users.sort(comp.reversed());
        System.out.println("After sort by age, reversed:");
        users.forEach(x -> System.out.println(x));
    }
}
