package concurrency.producer_consumer;

/**
 * Consumer class represents consuming fixed size of items from the store
 */
public class Consumer implements Runnable {

    private static final int ORDER_SIZE = 5;

    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < ORDER_SIZE; i++) {
            store.get();
        }
    }
}
