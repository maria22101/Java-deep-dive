package concurrency.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * Class describes how to find max value in an array utilizing ForkJoin framework
 * Extending RecursiveTask<Integer> means an integer will be returned
 */
public class MaxFindingForkJoinTask extends RecursiveTask<Integer> {

    private int[] numbers;
    private int lowIndex;
    private int highIndex;

    public MaxFindingForkJoinTask(int[] numbers, int lowIndex, int highIndex) {
        this.numbers = numbers;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if (highIndex - lowIndex < ForkJoinDemo1.THRESHOLD) {// some threshold
            return findMaxNumber();
        } else {
            int middleIndex = (lowIndex + highIndex) / 2;

            MaxFindingForkJoinTask task1 = new MaxFindingForkJoinTask(numbers, lowIndex, middleIndex); // for recursive call
            MaxFindingForkJoinTask task2 = new MaxFindingForkJoinTask(numbers, middleIndex + 1, highIndex); // for recursive call

            invokeAll(task1, task2); // launching both tasks

            return Math.max(task1.join(), task2.join()); // join() returns result of computation when it is done
        }
    }

    private int findMaxNumber() {
        int max = numbers[lowIndex];
        for (int i = lowIndex; i < highIndex ; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

}
