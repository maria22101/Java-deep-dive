package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositWithUnlimitedReplenishment extends DepositNonTerminable {

    public DepositWithUnlimitedReplenishment(int sum, double interestRate, int periodInDays, Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public void replenish(double replenishmentSum) {
        sum += replenishmentSum;
    }

    @Override
    public int calculateIncome() {
        return super.calculateIncome(); //to implement
    }
}
