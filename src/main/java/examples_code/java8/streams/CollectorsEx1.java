package examples_code.java8.streams;

import examples_code.java8.lambda.User;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CollectorsEx1 {

    public static void main(String[] args) {

        // transformate ArrayList and collect to other Collection
        List<String> list = Arrays.asList("michael", "mari", "monique", "marion");
        Queue<String> queue = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(queue);

        // group users by age
        List<User> usersList = Arrays.asList(
                new User("Mia", 42),
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

        // entring a map: find min age and its index in an array of ages
        AtomicInteger a = new AtomicInteger();
        Map.Entry<Integer, Integer> minAge = usersList.stream()
                .map(user -> user.getAge())
                .collect(Collectors.toMap(n -> a.getAndIncrement(), m -> m))
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue))
                .get();
        System.out.println(minAge);
    }
}
