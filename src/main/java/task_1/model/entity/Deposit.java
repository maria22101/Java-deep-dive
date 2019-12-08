package task_1.model.entity;

import task_1.model.Bank;

import java.math.BigDecimal;

/**
 * @author Maria Bilous
 */
public abstract class Deposit {
    private BigDecimal sum;
    private BigDecimal interestRate;
    private int periodInDays;
    private Bank bank;

    public Deposit(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank) {
        this.sum = sum;
        this.interestRate = interestRate;
        this.periodInDays = periodInDays;
        this.bank = bank;
    }

    public abstract BigDecimal calculateIncome();

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
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
}
