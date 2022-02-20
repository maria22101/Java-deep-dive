package algorithmics;

import java.util.Arrays;

import concurrency.thread_pool_custom.ThreadPool;

public class MergeSort2 {

    private static void mergeSort(int[] arr) {
        if (arr.length == 1) {
            return;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);

        mergeSort(left);
        mergeSort(right);

        sort(arr, left, right);
    }

    private static void sort(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                arr[i + j] = left[i++];
            } else {
                arr[i + j] = right[j++];
            }
        }
        System.arraycopy(left, i, arr, i + j, left.length - i);
        System.arraycopy(right, j, arr, i + j, right.length - j);
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 34, 67, 21, 4, 8, 1};
        System.out.println(Arrays.toString(arr));

        mergeSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
