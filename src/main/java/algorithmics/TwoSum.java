package algorithmics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers return indices of the two numbers so that their sum is a stated number(parameter)
 * example: array = [2, 7, 11, 15], target = 9
 * solution: [0, 1] because array[0] + array[1] = 9
 */
public class TwoSum {
    static int[] findTwo(int[] array, int target) {
        int[] resultArray = new int[2];

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length ; j++) {
                if (array[i] + array[j] == target) {
                    resultArray[0] = i;
                    resultArray[1] = j;
                }
            }
        }
        return resultArray;
    }

    static int[] findTwoUsingMap(int[] array, int target) {
        int[] resultArray = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(i, array[i]);
        }
        for (Map.Entry<Integer, Integer> elem : map.entrySet()) {
            int firstElem = elem.getValue();
            int secondElem = target - firstElem;
            if (map.containsValue(secondElem)) {
                int secondElementKey = map.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(secondElem))
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .get();
                if(secondElementKey != elem.getKey()) {
                    resultArray[0] = elem.getKey();
                    resultArray[1] = secondElementKey;
                    break;
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4};
        System.out.println(Arrays.toString(findTwo(arr, 6)));
        System.out.println(Arrays.toString(findTwoUsingMap(arr, 6)));
    }
}
