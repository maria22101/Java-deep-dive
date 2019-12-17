package examples_code.java8.streams;

import examples_code.java8.lambda.User;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsEx {

    public static void main(String[] args) {

        // transformate ArrayList and collect to other Collection
        List<String> list = Arrays.asList("michael", "mari", "monique", "marion");
        Queue<String> queue = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue);

        // group users by age
        List<User> usersList = Arrays.asList(
                new User("Mia", 22),
                new User("Nick", 36),
                new User("Monika", 22),
                new User("Noel", 36),
                new User("Nicole", 32));
        Map<Integer, List<User>> usersGroupedByAge = usersList.stream()
                .collect(Collectors.groupingBy(User::getAge));
        System.out.println(usersGroupedByAge);

        // users' ages and these ages times of occurrence
        Map<Integer, Long> numOfUsersAges = usersList.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
        System.out.println(numOfUsersAges);
    }
}
