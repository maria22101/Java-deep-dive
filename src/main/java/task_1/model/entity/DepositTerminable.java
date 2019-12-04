package task_1.model.entity;

import task_1.model.Bank;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositTerminable)) return false;
        if (!super.equals(o)) return false;
        DepositTerminable that = (DepositTerminable) o;
        return daysPassedBeforeTermination == that.daysPassedBeforeTermination &&
                Double.compare(that.interestRateForTermination, interestRateForTermination) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), daysPassedBeforeTermination, interestRateForTermination);
    }

    @Override
    public String toString() {
        return "DepositTerminable{" +
                "sum=" + getSum() +
                ", interestRate=" + getInterestRate() +
                ", periodInDays=" + getPeriodInDays() +
                ", bank=" + getBank() +
                "daysPassedBeforeTermination=" + daysPassedBeforeTermination +
                ", interestRateForTermination=" + interestRateForTermination +
                '}';
    }
}
