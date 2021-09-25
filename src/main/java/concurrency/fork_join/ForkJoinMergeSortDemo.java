package concurrency.fork_join;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinMergeSortDemo {

    public static void main(String[] args) {
        int[] arr = {3, 5, 34, 67, 21, 4 ,8, 1};
        System.out.println(Arrays.toString(arr));

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        forkJoinPool.invoke(new MergeSortTask(arr));

        System.out.println(Arrays.toString(arr));
    }

}
