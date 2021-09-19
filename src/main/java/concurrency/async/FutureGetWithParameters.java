package concurrency.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureGetWithParameters {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Thread main started working");
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Callable<String> callable = () -> {
            System.out.printf("Thread %s started working\n", Thread.currentThread().getName());
            Thread.sleep(10_000); // time of this async task execution is 5 sec
            return Thread.currentThread().getName();
        };

        Future<String> future = executorService.submit(callable);

        System.out.println("Thread main keeps on working");
        TimeUnit.SECONDS.sleep(3);

        try {
            // using future.get() method with parameters: 5 - time of waiting - number of time units, second parameter - time units
            System.err.printf("Result from a Future instance: %s\n", future.get(5, TimeUnit.SECONDS));
        } catch (TimeoutException e) {
            System.out.println("Time has run out"); // this will be result of this program as the async task being performed 10 sec, but we allowed waiting 5 sec only
        }

        executorService.shutdown();
    }
}
