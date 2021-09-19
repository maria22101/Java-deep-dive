package concurrency.notifier;

/**
 * Waits for other Threads completion
 * Contains monitor on Message instance using synchronized block
 */
public class Waiter implements Runnable{
    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        synchronized (message) {
            try {
                System.out.println(name + " thread is waiting for notify: " + System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " thread " + "received notify: " + System.currentTimeMillis());
            System.out.println(name + " processed the " + message.getMessage());
        }
    }
}
