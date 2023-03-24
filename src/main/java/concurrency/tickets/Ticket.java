package concurrency.tickets;

import java.util.concurrent.TimeUnit;

/**
 *{@link Ticket} demonstrates usage of 'synchronized' an 'volatile' keywords for synchronizing access
 *
 */
public class Ticket {
    int place;
    volatile boolean isBoocked;

    public Ticket(int place) {
        this.place = place;
    }

    synchronized void book(Cashier cashier) {
        if(!isBoocked) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            isBoocked = true;
            System.out.println("Cashier-" + cashier.id + " booked ticket with place# " + place);
        }
    }
}
