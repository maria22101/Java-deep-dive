package concurrency.basics;

public class Stats {
    volatile int counter;

    synchronized void incrementCounter() {
        counter++;
    }
}
