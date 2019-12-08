package task_1.model;

import task_1.model.entity.Deposit;
import task_1.model.entity.DepositTerminable;
import task_1.model.entity.DepositWithReplenishment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is for storage, sorting, filtering
 * and displaying Deposit class instances
 * @author Maria Bilous
 */
public class Utility {
    private List<Deposit> deposits;

    public Utility() {
        this.deposits = new ArrayList<Deposit>();
    }

    public void add(Deposit d) {
        if (!deposits.contains(d)) {
            deposits.add(d);
        }
    }

    public void remove (Deposit d) {
        if (deposits.contains(d)) {
            deposits.remove(d);
        }
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public List<Deposit> depositsSortedByRate(List<Deposit> inputList) {
        return inputList
                .stream()
                .sorted(Comparator.comparing(Deposit::getInterestRate))
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsSortedByBanks(List<Deposit> inputList) {
        return inputList
                .stream()
                .sorted(Comparator.comparing(o -> o.getBank().toString()))
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsTerminable(List<Deposit> inputList) {
        return inputList
                .stream()
                .filter((d) -> d instanceof DepositTerminable)
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsWithReplenishment(List<Deposit> inputList) {
        return inputList
                .stream()
                .filter((d) -> d instanceof DepositWithReplenishment)
                .collect(Collectors.toList());
    }

    /**
     * @return List of the Deposits with field sum less than the
     * parameter sum
     */
    public List<Deposit> depositsForTheGivenSum(double sum) {
        return deposits
                .stream()
                .filter((d) -> (d.getSum()
                        .setScale(2, RoundingMode.HALF_UP))
                        .compareTo((new BigDecimal(sum)).setScale(2, RoundingMode.HALF_UP)) <= 0)
                .collect(Collectors.toList());
    }
}
