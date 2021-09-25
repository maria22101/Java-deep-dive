package concurrency.basics;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ThreadOutputs {

    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("Hello from Runnable");
        new Thread(runnable).start();

        Executors.newFixedThreadPool(1).submit(() -> System.out.println("Hello from Executor"));

        ForkJoinPool.commonPool().invoke(new PrintTask());
    }
}
