package concurrency.cafe;

public class CafeVisitors implements Runnable{

    // System.err aims at red color on the console
    @Override
    public void run() {
        try {
            System.err.printf("Thread %s guests entered cafe and looking for a table\n", Thread.currentThread().getName());
            CafeMain.tables.acquire(); // semaphor's counter gets decremented by 1 meaning one table is busy

            System.out.printf("Thread %s guests set at the table and called the waiter\n", Thread.currentThread().getName());
            CafeMain.waiter.acquire(); // waiter is busy

            System.out.printf("Thread %s guests are greeted by the waiter\n", Thread.currentThread().getName());
            Thread.sleep(2000);
            System.out.printf("Thread %s guests' orders were taken by the waiter\n", Thread.currentThread().getName());
            Thread.sleep(4000);
            CafeMain.waiter.release(); // waiter is free

            Thread.sleep(4000);
            CafeMain.waiter.acquire(); // waiter is busy

            System.out.printf("Thread %s guests orders were served by the waiter\n", Thread.currentThread().getName());
            CafeMain.waiter.release(); // waiter is free

            Thread.sleep(4000);
            System.err.printf("Thread %s guests finished eating and left the cafe\n", Thread.currentThread().getName());
            CafeMain.tables.release(); // waiter is free

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
