package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositWithLimitedReplenishment extends DepositNonTerminable {
    private double maxReplenishmentSum;

    public DepositWithLimitedReplenishment(int sum, double interestRate, int periodInDays,
                                           Bank bank) {
        super(sum, interestRate, periodInDays, bank);
        maxReplenishmentSum = sum * 0.5;
    }

    public void replenish(double replenishmentSum) {
        if (replenishmentSum <= maxReplenishmentSum) {
            sum += replenishmentSum;
        } else {
            sum += maxReplenishmentSum;
        }
    }

    @Override
    public int calculateIncome() {
        return super.calculateIncome(); //to implement
    }
}
