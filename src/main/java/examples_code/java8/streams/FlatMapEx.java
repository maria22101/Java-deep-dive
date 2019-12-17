package examples_code.java8.streams;

import examples_code.java8.lambda.Human;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class FlatMapEx {

    public static void main(String[] args) {

        // flatMap example - extract Strings from a collection containing Lists
        List<Human> humanList = asList(
                new Human("Lee", asList("Tommy", "Trevor")),
                new Human("Luke", asList("Maggy", "Marcy")),
                new Human("Linette", asList("Kleeve")));

        // flatMap example - extract Strings from a collection containing Lists: syntax option_1
        List<String> petNames = humanList.stream()
                .map(Human::getPets) // stream of Humans transformed into stream of List<pet>
                .flatMap(pet -> pet.stream()) // stream of List<pet> transformed into stream of String
                .collect(Collectors.toList());
        System.out.println(petNames);

        // flatMap example - extract Strings from a collection containing Lists: syntax option_2
        List<String> petNames2 = humanList.stream()
                .flatMap(human -> human.getPets().stream())
                .collect(Collectors.toList());
        System.out.println(petNames2);

        // flatMap example - deploy multi-dimensional array components
        int[][] arr = {{0, 5}, {10, 15}, {20, 25}};
        int[] resultArr = Arrays.stream(arr)
                .flatMapToInt(ints -> Arrays.stream(ints)) // can by written as Arrays::stream
                .toArray();
        System.out.println(Arrays.toString(resultArr));
    }
}
