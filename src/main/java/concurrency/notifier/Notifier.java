package concurrency.notifier;

public class Notifier implements Runnable{
    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            synchronized (message) {
                message.setMessage("Important message from the notifier");
                message.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
