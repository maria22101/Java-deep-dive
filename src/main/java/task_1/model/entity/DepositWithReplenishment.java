package task_1.model.entity;

import task_1.model.Bank;

import java.util.Objects;

/**
 * @author Maria Bilous
 */
public class DepositWithReplenishment extends DepositNonTerminable{
    private int daysLeftTillEndOfPeriod;
    private double replenishmentSum;

    public DepositWithReplenishment(double sum, double interestRate, int periodInDays,
                                    Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public DepositWithReplenishment(double sum, double interestRate, int periodInDays,
                                    Bank bank, int daysLeftTillEndOfPeriod, double replenishmentSum) {
        super(sum, interestRate, periodInDays, bank);
        this.daysLeftTillEndOfPeriod = daysLeftTillEndOfPeriod;
        this.replenishmentSum = replenishmentSum;
    }

    /**
     *This method calculates income for this class instance as follows:
     * first - the related super class method applied;
     * second - additional income calculated from the replenishing sum
     * considering days left till the end of the deposit period.
     * @return double value - income for an instance of this class
     */
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
                ", daysLeftTillEndOfPeriod=" + daysLeftTillEndOfPeriod +
                ", replenishmentSum=" + replenishmentSum +
                '}';
    }
}
