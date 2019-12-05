package task_1.model.entity;

import task_1.model.Bank;

/**
 * @author Maria Bilous
 */
public class DepositNonTerminable extends Deposit {
    public DepositNonTerminable(double sum, double interestRate, int periodInDays, Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public double calculateIncome() {
        return getSum() * getInterestRate() / 365 * getPeriodInDays();
    }
}
