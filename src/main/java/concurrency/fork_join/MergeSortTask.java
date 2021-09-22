package concurrency.fork_join;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortTask extends RecursiveAction {
    private int[] arr;
    private int n;

    public MergeSortTask(int[] arr) {
        this.arr = arr;
        this.n = arr.length;
    }

    @Override
    protected void compute() {
        if (arr.length == 1) {
            return;
        }

        int[] leftArray = Arrays.copyOfRange(arr, 0, n / 2);
        int[] rightArray = Arrays.copyOfRange(arr, n / 2, n);

        MergeSortTask taskForLeft = new MergeSortTask(leftArray);
        MergeSortTask taskForRight = new MergeSortTask(rightArray);

        taskForLeft.fork();
        taskForRight.compute();
        taskForLeft.join(); // wait until computation from the left task

        merge(arr, leftArray, rightArray);
    }

    private void merge(int[] arr, int[] left, int[] right) {
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
}
