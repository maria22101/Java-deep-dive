package task_1.Model.Entity;

import task_1.Model.Bank;

public abstract class DepositNonTerminableReplenished extends Deposit{
    public int daysPassedBeforeReplenishment;

    public DepositNonTerminableReplenished(double sum, double interestRate, int periodInDays,
                                           Bank bank, int daysPassedBeforeReplenishment) {
        super(sum, interestRate, periodInDays, bank);
        this.daysPassedBeforeReplenishment = daysPassedBeforeReplenishment;
    }

    public abstract void replenish(double replenishmentSum);
}
