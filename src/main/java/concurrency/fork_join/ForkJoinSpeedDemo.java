package concurrency.fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;

public class ForkJoinSpeedDemo {
    
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

        private static int[] getArray() {
            int[] arr = new int[20_000_000];
            for (int i = 0; i < 20_000_000; i++) {
                arr[i] = ThreadLocalRandom.current().nextInt();
            }
            return arr;
        }
        
        public static void main(String[] args) {
            int[] arr1 = getArray();
            System.out.println("Regular Merge sort, 20_000_000 random integers: ");
            for (int i = 0; i < 10; i++) {
                long start = System.currentTimeMillis();
                mergeSort(arr1);
                System.out.println((System.currentTimeMillis() - start) + " ms");
            }

            int[] arr2 = getArray();
            System.out.println("ForkJoin Merge sort, 20_000_000 random integers: ");
            for (int i = 0; i < 10; i++) {
                long start = System.currentTimeMillis();
                ForkJoinPool.commonPool().invoke(new MergeSortTask(arr2));
                System.out.println((System.currentTimeMillis() - start) + " ms");
            }
        }
    

}
