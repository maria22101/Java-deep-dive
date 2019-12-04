package task_1.model;

import task_1.model.entity.Deposit;
import task_1.model.entity.DepositTerminable;
import task_1.model.entity.DepositWithReplenishment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {
    private List<Deposit> deposits = new ArrayList<Deposit>();

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

    public void displayDepositsSortedByRate() {
        depositsSortedByRate().forEach(deposit -> {
            deposit.toString();
            System.out.println();
        });
    }

    public void displayDepositsSortedByBanks() {
        depositsSortedByBanks().forEach(deposit -> {
            deposit.toString();
            System.out.println();
        });
    }

    public void displayDepositsTerminable() {
        depositsTerminable().forEach(deposit -> {
            deposit.toString();
            System.out.println();
        });
    }

    public void displayDepositsWithReplenishment() {
        depositsWithReplenishment().forEach(deposit -> {
            deposit.toString();
            System.out.println();
        });
    }

    public void displayDepositsForTheGivenSum(double sum) {
        depositsForTheGivenSum(sum).forEach(deposit -> {
            deposit.toString();
            System.out.println();
        });
    }

    private List<Deposit> depositsSortedByRate() {
        return deposits
                .stream()
                .sorted(new Comparator<Deposit>() {
                    @Override
                    public int compare(Deposit o1, Deposit o2) {
                        if (o1.getInterestRate() < o2.getInterestRate()) {
                            return -1;
                        }else {
                            return 1;
                        }
                    }})
                .collect(Collectors.toList());
    }

    private List<Deposit> depositsSortedByBanks() {
        return deposits
                .stream()
                .sorted(new Comparator<Deposit>() {
                    @Override
                    public int compare(Deposit o1, Deposit o2) {
                       return o1.getBank().toString().compareTo(o2.getBank().toString());
                    }})
                .collect(Collectors.toList());
    }

    private List<Deposit> depositsTerminable() {
        return deposits
                .stream()
                .filter((d) -> d instanceof DepositTerminable)
                .collect(Collectors.toList());
    }

    private List<Deposit> depositsWithReplenishment() {
        return deposits
                .stream()
                .filter((d) -> d instanceof DepositWithReplenishment)
                .collect(Collectors.toList());
    }

    private List<Deposit> depositsForTheGivenSum(double sum) {
        return deposits
                .stream()
                .filter((d) -> d.getSum() < sum)
                .collect(Collectors.toList());
    }
}
