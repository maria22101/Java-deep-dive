package algorithmics;

import java.util.Arrays;

/**
 * Merge sort implementation.
 * In comparison with Insertion sort:
 *      time complexity - log(n) - less time required (compared to n x n);
 *      space complexity - more memory required as additional arrays get created;
 *      partially sorted arrays - Insertion sort may be quicker and be close to n while Merge sort has log(n) in any case.
 */
public class MergeSort {

    static void mergeSort(int[] arr) {
        if(arr.length == 1) {
            return;
        }
        int leftSize = arr.length / 2;
        int rightSize = arr.length - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        System.arraycopy(arr, 0, left, 0, leftSize);
        System.arraycopy(arr, leftSize, right, 0, rightSize);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    private static void merge(int[] main, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        int targetIndex = 0;
        int remaining = left.length + right.length;

        while (remaining > 0) {
            if (leftIndex >= left.length) {
                main[targetIndex] = right[rightIndex++];
            } else if (rightIndex >= right.length) {
                main[targetIndex] = left[leftIndex++];
            } else if (right[rightIndex] < left[leftIndex]) {
                main[targetIndex] = right[rightIndex++];
            } else {
                main[targetIndex] = left[leftIndex++];
            }
            targetIndex++;
            remaining--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 6, 14, 88, 3, 36};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
