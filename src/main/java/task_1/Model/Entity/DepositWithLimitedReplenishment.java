package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositWithLimitedReplenishment extends DepositNonTerminableReplenished {
    private double maxReplenishmentSum;

    public DepositWithLimitedReplenishment(double sum, double interestRate, int periodInDays, Bank bank,
                                           int daysPassedBeforeReplenishment, int maxReplenishmentSum) {
        super(sum, interestRate, periodInDays, bank, daysPassedBeforeReplenishment);
        this.maxReplenishmentSum = maxReplenishmentSum;
    }

    public void replenish(double replenishmentSum) {

    }

    public int calculateIncome() {
        return 0;
    }
}
