package task_1.Model.Entity;

import task_1.Model.Bank;

public class DepositReplenished extends DepositNonTerminable{
    private int daysLeftTillEndOfPeriod;
    private double replenishmentSum;

    public DepositReplenished(double sum, double interestRate, int periodInDays,
                              Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    @Override
    public double calculateIncome() {
        double initialSumIncome = super.calculateIncome();
        double replenishmentIncome = replenishmentSum * getInterestRate() / 365
                * getDaysLeftTillEndOfPeriod();
        return initialSumIncome + replenishmentIncome;
    }

    public int getDaysLeftTillEndOfPeriod() {
        return daysLeftTillEndOfPeriod;
    }

    public void setDaysLeftTillEndOfPeriod(int daysLeftTillEndOfPeriod) {
        this.daysLeftTillEndOfPeriod = daysLeftTillEndOfPeriod;
    }

    public double getReplenishmentSum() {
        return replenishmentSum;
    }

    public void setReplenishmentSum(double replenishmentSum) {
        this.replenishmentSum = replenishmentSum;
    }
}
