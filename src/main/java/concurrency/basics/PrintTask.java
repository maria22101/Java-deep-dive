package concurrency.basics;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class PrintTask extends RecursiveTask {

    @Override
    protected Object compute() {
        System.out.println("Hello from ForkJoin");
        return null;
    }
}
