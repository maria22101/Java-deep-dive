package concurrency.producer_consumer;

/**
 * Store class represents a warehouse with a fixed number of storage capacity (max number of products being stored)
 */
public class Store {

    private static final int STORAGE_CAPACITY = 3;

    private int counter = 0;

    public synchronized void get() {
        while (counter < 1) {
            try {
                wait(); // products not available; monitor released -> method put can be performed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter--;
        System.out.println("-1 product consumed");
        System.out.println(String.format("\t stock: %d products", counter));
        notify();
    }

    public synchronized void put() {
        while (counter >= STORAGE_CAPACITY) {
            try {
                wait(); // maximum storage capacity reached; monitor released -> method get() can be performed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        counter++;
        System.out.println("+1 product added");
        System.out.println(String.format("\t stock: %d products", counter));
        notify();
    }
}
