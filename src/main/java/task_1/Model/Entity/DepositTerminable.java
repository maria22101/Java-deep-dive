package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositTerminable extends Deposit {
    private int daysPassedBeforeTermination;
    private double interestRateForTermination;

    public DepositTerminable(double sum, double interestRate, int periodInDays, Bank bank,
                             int daysPassedBeforeTermination, double interestRateForTermination) {
        super(sum, interestRate, periodInDays, bank);
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
        this.interestRateForTermination = interestRateForTermination;
    }

    public int calculateIncome() {
        return 0; // to implement
    }
}
