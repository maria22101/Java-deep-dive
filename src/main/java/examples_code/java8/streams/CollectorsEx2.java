package examples_code.java8.streams;

import examples_code.java8.lambda.Human;
import examples_code.java8.lambda.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsEx2 {
    public static void main(String[] args) {
        List<User> usersList = Arrays.asList(
                new User("Mia", "Maxwell", 42, 3),
                new User("Nick", "Nelson", 36, 2),
                new User("Monika", "Maxwell", 22, 4),
                new User("Noel", "Nelson",36, 5),
                new User("Nicole", "Nelson", 32, 1));

        // group Users by surname and display Users
        Map<String, List<User>> surnames = usersList
                .stream()
                .collect(Collectors.groupingBy(User::getSurname));
        System.out.println(surnames);

        // group Users by surname and count users of the same surname
        Map<String, Long> surmaneCount = usersList
                .stream()
                .collect(Collectors.groupingBy(User::getSurname, Collectors.counting()));
        System.out.println(surmaneCount);

        // count friends by surname
        Map<String, Integer> friendsCount = usersList
                .stream()
                .collect(Collectors.groupingBy(User::getSurname,
                                                Collectors.summingInt(User::getFriendsNum)));
        System.out.println(friendsCount);

        // grouping & mapping: ages of the families
        Map<String, List<Integer>> agesOfFamilies = usersList
                .stream()
                .collect(Collectors.groupingBy(User::getSurname,
                                                Collectors.mapping(User::getAge, Collectors.toList())));
        System.out.println(agesOfFamilies);

        // grouping & mapping: names of the families
        Map<String, List<String>> namesOfFamilies = usersList
                .stream()
                .collect(Collectors.groupingBy(User::getSurname,
                        Collectors.mapping(User::getName, Collectors.toList())));
        System.out.println(namesOfFamilies);
    }
}
