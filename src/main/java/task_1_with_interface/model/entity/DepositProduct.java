package task_1_with_interface.model.entity;

import task_1_with_interface.model.Bank;

import java.math.BigDecimal;

public abstract class DepositProduct implements Deposit {
    private BigDecimal sum;
    private BigDecimal interestRate;
    private int periodInDays;
    private Bank bank;

    public DepositProduct(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank) {
        this.sum = sum;
        this.interestRate = interestRate;
        this.periodInDays = periodInDays;
        this.bank = bank;
    }

    @Override
    public BigDecimal sum() {
        return sum;
    }

    @Override
    public BigDecimal interestRate() {
        return interestRate;
    }

    @Override
    public int periodInDays() {
        return periodInDays;
    }

    @Override
    public Bank bank() {
        return bank;
    }
}
