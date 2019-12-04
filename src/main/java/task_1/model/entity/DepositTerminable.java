package task_1.model.entity;

import task_1.model.Bank;

public class DepositTerminable extends Deposit {
    private int daysPassedBeforeTermination;
    private double interestRateForTermination;

    public DepositTerminable(double sum, double interestRate, int periodInDays, Bank bank,
                             int daysPassedBeforeTermination, double interestRateForTermination) {
        super(sum, interestRate, periodInDays, bank);
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
        this.interestRateForTermination = interestRateForTermination;
    }

    public double calculateIncome() {
        return getSum() * interestRateForTermination / 365 * daysPassedBeforeTermination;
    }

    public int getDaysPassedBeforeTermination() {
        return daysPassedBeforeTermination;
    }

    public void setDaysPassedBeforeTermination(int daysPassedBeforeTermination) {
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
    }

    public double getInterestRateForTermination() {
        return interestRateForTermination;
    }

    public void setInterestRateForTermination(double interestRateForTermination) {
        this.interestRateForTermination = interestRateForTermination;
    }
}
