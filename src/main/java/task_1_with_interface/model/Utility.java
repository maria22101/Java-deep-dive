package task_1_with_interface.model;

import task_1_with_interface.model.entity.Deposit;
import task_1_with_interface.model.entity.DepositTerminable;
import task_1_with_interface.model.entity.DepositWithReplenishment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .sorted(Comparator.comparing(Deposit::interestRate))
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsSortedByBanks(List<Deposit> inputList) {
        return inputList
                .stream()
                .sorted(Comparator.comparing(o -> o.bank().toString()))
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsTerminableOld(List<Deposit> inputList) {
        return inputList
                .stream()
                .filter((d) -> d instanceof DepositTerminable)
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsTerminable(List<Deposit> inputList) {
        return inputList
                .stream()
                .map(d -> (DepositTerminable) d)
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsWithReplenishmentOld(List<Deposit> inputList) {
        return inputList
                .stream()
                .filter((d) -> d instanceof DepositWithReplenishment)
                .collect(Collectors.toList());
    }

    public List<Deposit> depositsWithReplenishment(List<Deposit> inputList) {
        return inputList
                .stream()
                .map(d -> (DepositWithReplenishment) d)
                .collect(Collectors.toList());
    }

    /**
     * @return List of the Deposits with field sum less than the
     * parameter sum
     */
    public List<Deposit> depositsForTheGivenSum(double sum) {
        return deposits
                .stream()
                .filter((d) -> (d.sum()
                        .setScale(2, RoundingMode.HALF_UP))
                        .compareTo((new BigDecimal(sum)).setScale(2, RoundingMode.HALF_UP)) <= 0)
                .collect(Collectors.toList());
    }
}
