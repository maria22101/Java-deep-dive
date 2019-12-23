package examples_code.java8.streams;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethods {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("first", "Tigra");
        map.put("second", "Barsik");
        map.put("third", "Alice");
        System.out.println(map);

        // adding an element if it is absent
        map.putIfAbsent("fourth", "Coracol"); // will be added
        System.out.println(map);
        map.putIfAbsent("first", "Meou"); // will not be added
        System.out.println(map);

        // compute some action if an element is in the map
        map.computeIfPresent("second", (key, value) -> "My dear " + value + "!");
        System.out.println(map);

        // compute if alement is absent in the map
        map.computeIfAbsent("fifth", key -> "This is the " + key + " cat");
        System.out.println(map);

        // removing the stated element from the map
        map.remove("third", "Alice");
        System.out.println(map);

        // returning the value for the stated key.
        // if there is no such a key -> returning the stated (default) value
        String str1 = map.getOrDefault("second", "I forgot your name");
        String str2 = map.getOrDefault("sixths", "I forgot your name");
        System.out.println(str1);
        System.out.println(str2);

        // create/update the map pair according to the given lambda expression
        map.merge("first", " the Cat", (oldValue, addingValue) -> oldValue + addingValue);
        System.out.println(map.get("first"));
    }
}
