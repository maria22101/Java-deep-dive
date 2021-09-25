package concurrency.notifier;

public class NotifierDemo {

    public static void main(String[] args) {
        Message message = new Message("Important message");

        Waiter waiter = new Waiter(message);
        new Thread(waiter, "waiter").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "notifier").start(); // its "notify" method will wake up the waiter thread

        System.out.println("All threads get started");
    }
}
