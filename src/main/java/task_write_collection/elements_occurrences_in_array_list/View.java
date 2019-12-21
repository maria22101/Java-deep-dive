package task_write_collection.elements_occurrences_in_array_list;

import java.util.Map;
import java.util.stream.Collectors;

import static task_write_collection.elements_occurrences_in_array_list.TextConstants.HYPHEN_SIGN;

/**
 * Created by Bilous M. 20.12.2019
 */
public class View {
    public void printMessage(String str) {
        System.out.println(str);
    }

    public String concatenatedString(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String s : message) {
            concatString.append(s);
        }
        return new String(concatString);
    }

    public void displayMap(Map<Integer, Long> inputMap) {
        inputMap.entrySet()
                .stream()
                .map(mapPair -> concatenatedString(
                        mapPair.getKey().toString(),
                        HYPHEN_SIGN,
                        mapPair.getValue().toString()))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
