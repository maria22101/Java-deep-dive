package task_1.Model.Entity;

import task_1.Model.Bank;

public abstract class Deposit {
    public double sum;
    public double interestRate;
    public int periodInDays;
    public Bank bank;

    public Deposit(double sum, double interestRate, int periodInDays, Bank bank) {
        this.sum = sum;
        this.interestRate = interestRate;
        this.periodInDays = periodInDays;
        this.bank = bank;
    }

    public abstract int calculateIncome();
}
