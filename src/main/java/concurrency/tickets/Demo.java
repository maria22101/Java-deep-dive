package concurrency.tickets;

public class Demo {

    public static void main(String[] args) {
        Ticket[] tickets = {
                new Ticket(10),
                new Ticket(20),
                new Ticket(30),
                new Ticket(40)
        };

        Cashier cashier1 = new Cashier(1, tickets);
        Cashier cashier2 = new Cashier(2, tickets);
        Cashier cashier3 = new Cashier(3, tickets);

        cashier1.start();
        cashier2.start();
        cashier3.start();
    }
}
