package algorithmics;

import java.util.Arrays;

public class BubbleSort {

    static void bubbleSort(int[] arr) {
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 8, 12, 5, 3};
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
