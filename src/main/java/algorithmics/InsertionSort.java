package algorithmics;

import java.util.Arrays;

/**
 * Insertion Sort implementation. Effective for sorted/partially sorted arrays
 */
public class InsertionSort {

    static void sort(int[] arr) {
        int length = arr.length;
        for (int i = 1; i < length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >=0 && current < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 6, 14, 88, 3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
