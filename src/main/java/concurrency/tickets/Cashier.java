package concurrency.tickets;

public class Cashier extends Thread{
    int id;
    Ticket[] tickets;

    public Cashier(int id, Ticket[] tickets) {
        this.id = id;
        this.tickets = tickets;
    }

    @Override
    public void run() {
        for (int i = 0; i < tickets.length; i++) {
            tickets[i].book(this);
        }
    }
}
