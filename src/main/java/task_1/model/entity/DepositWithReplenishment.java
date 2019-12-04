package task_1.model.entity;

import task_1.model.Bank;

public class DepositWithReplenishment extends DepositNonTerminable{
    private int daysLeftTillEndOfPeriod;
    private double replenishmentSum;

    public DepositWithReplenishment(double sum, double interestRate, int periodInDays,
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
