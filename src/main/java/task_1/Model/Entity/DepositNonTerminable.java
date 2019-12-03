package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositNonTerminable extends Deposit {
    public DepositNonTerminable(double sum, double interestRate, int periodInDays, Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public int calculateIncome() {
        return 0; // to implement
    }
}
