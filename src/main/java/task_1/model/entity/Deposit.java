package task_1.model.entity;

import task_1.model.Bank;

import java.util.Objects;

public abstract class Deposit {
    private double sum;
    private double interestRate;
    private int periodInDays;
    private Bank bank;

    public Deposit(double sum, double interestRate, int periodInDays, Bank bank) {
        this.sum = sum;
        this.interestRate = interestRate;
        this.periodInDays = periodInDays;
        this.bank = bank;
    }

    public abstract double calculateIncome();

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getPeriodInDays() {
        return periodInDays;
    }

    public void setPeriodInDays(int periodInDays) {
        this.periodInDays = periodInDays;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return Double.compare(deposit.sum, sum) == 0 &&
                Double.compare(deposit.interestRate, interestRate) == 0 &&
                periodInDays == deposit.periodInDays &&
                bank == deposit.bank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, interestRate, periodInDays, bank);
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "sum=" + sum +
                ", interestRate=" + interestRate +
                ", periodInDays=" + periodInDays +
                ", bank=" + bank +
                '}';
    }
}
