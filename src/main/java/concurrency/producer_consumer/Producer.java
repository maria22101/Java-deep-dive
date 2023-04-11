package concurrency.producer_consumer;

/**
 * Producer class represents producing fixed size of items and putting them on the store
 */
public class Producer implements Runnable {

    private static final int ORDER_SIZE = 5;

    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < ORDER_SIZE; i++) {
            store.put();
        }
    }
}
