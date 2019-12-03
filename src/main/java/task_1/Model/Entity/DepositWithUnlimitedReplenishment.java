package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositWithUnlimitedReplenishment extends DepositNonTerminableReplenished {

    public DepositWithUnlimitedReplenishment(double sum, double interestRate, int periodInDays,
                                             Bank bank, int daysPassedBeforeReplenishment) {
        super(sum, interestRate, periodInDays, bank, daysPassedBeforeReplenishment);
    }

    public void replenish(double replenishmentSum) {

    }

    public int calculateIncome() {
        return 0;
    }
}
