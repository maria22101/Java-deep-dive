package concurrency.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 1000; i++) {
            int taskNumber = i;
            executorService.submit(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + ": Task " + taskNumber);
                } catch (InterruptedException e) {
                    System.out.println("Task is interrupted");
                }
            });
        }

        System.out.println(executorService.shutdownNow().size()); // 985 tasks were not completed
    }
}
