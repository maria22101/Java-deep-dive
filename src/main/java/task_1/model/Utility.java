package task_1.model;

import task_1.model.entity.Deposit;

import java.util.ArrayList;
import java.util.List;

public class Utility {
    private List<Deposit> deposits = new ArrayList<Deposit>();

    public void add(Deposit d) {
        if (!deposits.contains(d)) {
            deposits.add(d);
        }
    }

    public List<Deposit> depositsSortedByRate() {
        return new ArrayList<Deposit>(); // to implement after test
    }

    public List<Deposit> depositsSortedByBanks() {
        return new ArrayList<Deposit>(); // to implement after test
    }

    public List<Deposit> depositsTerminable() {
        return new ArrayList<Deposit>(); // to implement after test
    }

    public List<Deposit> depositsWithReplenishment() {
        return new ArrayList<Deposit>(); // to implement after test
    }

    public List<Deposit> depositsForTheGivenSum(double sum) {
        return new ArrayList<Deposit>(); // to implement after test
    }

    public void remove (Deposit d) {
        if (deposits.contains(d)) {
            deposits.remove(d);
        }
    }

}
