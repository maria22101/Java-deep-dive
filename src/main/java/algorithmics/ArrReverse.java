package algorithmics;

import java.util.Arrays;

/**
 * This class provides two methods for an array reversing
 */
public class ArrReverse {
    static int[] reverseArrayUsingTwoArrays(int[] arr) {
        int[] reversedArr = new int[arr.length];
        int reversedArrAddingIndex = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            reversedArr[reversedArrAddingIndex - i] = arr[i];
        }

        return reversedArr;
    }

    static int[] reverseArrayUsingOneArrays(int[] arr) {
        int movingInd = arr.length - 1;

        for (int i = 0; i < arr.length / 2; i++) {
            int elem = arr[i];
            arr[i] = arr[movingInd - i];
            arr[movingInd - i] = elem;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = {12, 3, 51, 60, 5};
        int[] arr2 = {12, 3, 51, 60, 5, 987};
        System.out.println(Arrays.toString(reverseArrayUsingTwoArrays(arr1)));
        System.out.println(Arrays.toString(reverseArrayUsingOneArrays(arr2)));
    }
}
