package examples_code.java8.streams;

import java.util.HashMap;
import java.util.Map;

public class MapNewMethods {
    private static Map<String,String> getMapOfCats() {
        Map<String, String> map = new HashMap<>();
        map.put("first", "Tigra");
        map.put("second", "Barsik");
        map.put("third", "Alice");
        System.out.println("Initial map " + map);
        return map;
    }

    public static void main(String[] args) {

        // adding an element if it is absent
        System.out.println("-------------------");
        var map = getMapOfCats();
        map.putIfAbsent("fourth", "Coracol"); // will be added
        map.putIfAbsent("first", "Meou"); // will not be added
        System.out.println("Map after putIfAbsent: " + map);
        // state of the map: {third=Alice, fourth=Coracol, first=Tigra, second=Barsik}

        // compute some action if an element is in the map;
        // biFunction to be supplied with entry arguments: current key and current value
        System.out.println("-------------------");
        map = getMapOfCats();
        map.computeIfPresent("second", (currentKey, currentValue) -> "Hey, " + currentKey + " " + currentValue + "!");
        System.out.println("Map after computeIfPresent: " + map);
//        Map after change: {third=Alice, first=Tigra, second=Hey, second Barsik!}

        // compute if element is absent in the map and pastes the element in the map
        // function to be supplied that use the key as entry parameter
        System.out.println("-------------------");
        map = getMapOfCats();
        map.computeIfAbsent("fifth", key -> "This is the " + key + " cat");
        System.out.println("Map after computeIfAbsent: " + map);
//        Map after change: {third=Alice, fifth=This is the fifth cat, first=Tigra, second=Barsik}

        // removing the stated element from the map
        System.out.println("-------------------");
        map = getMapOfCats();
        map.remove("third", "Alice"); // will be removed
        map.remove("meou", "Alice"); // wont change anything as such pair not present
        System.out.println("Map after remove: " + map);
        // Map after change: {first=Tigra, second=Barsik}

        // returning the value for the stated key.
        // if there is no such a key -> returning the stated (default) value
        System.out.println("-------------------");
        map = getMapOfCats();
        String str1 = map.getOrDefault("second", "I forgot your name");
        String str2 = map.getOrDefault("sixths", "Default cat's name");
        System.out.println("second after getOrDefault: " + str1); // Barsik
        System.out.println("sixths after getOrDefault: " + str2); // Default cat's name

        // create/update the map pair according to the given lambda expression
        // biFunction to be supplied, entry parameters: current value, adding value
        // if the pair with such key does not exist -> a new pair will be created with the stated key and the adding value
        System.out.println("-------------------");
        map = getMapOfCats();
        map.merge("first", " the Cat", (currentValue, addingValue) -> currentValue + addingValue); // existing pair
        map.merge("tenth", "The tenth cat", (currentValue, addingValue) -> currentValue + addingValue); // non existing pair
        System.out.println(map.get("first")); // Tigra the Cat
        System.out.println(map.get("tenth")); // The tenth cat
        System.out.println("Map after merge: " + map);
        // Map after change: {tenth=The tenth cat, third=Alice, first=Tigra the Cat, second=Barsik}
    }
}
