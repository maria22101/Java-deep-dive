package task_1.model.entity;

import task_1.model.Bank;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositWithReplenishment)) return false;
        if (!super.equals(o)) return false;
        DepositWithReplenishment that = (DepositWithReplenishment) o;
        return daysLeftTillEndOfPeriod == that.daysLeftTillEndOfPeriod &&
                Double.compare(that.replenishmentSum, replenishmentSum) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), daysLeftTillEndOfPeriod, replenishmentSum);
    }

    @Override
    public String toString() {
        return "DepositWithReplenishment{" +
                "sum=" + getSum() +
                ", interestRate=" + getInterestRate() +
                ", periodInDays=" + getPeriodInDays() +
                ", bank=" + getBank() +
                "daysLeftTillEndOfPeriod=" + daysLeftTillEndOfPeriod +
                ", replenishmentSum=" + replenishmentSum +
                '}';
    }
}
