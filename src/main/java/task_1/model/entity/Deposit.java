package task_1.model.entity;

import task_1.model.Bank;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deposit)) return false;
        Deposit deposit = (Deposit) o;
        return periodInDays == deposit.periodInDays &&
                sum.equals(deposit.sum) &&
                interestRate.equals(deposit.interestRate) &&
                bank == deposit.bank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum, interestRate, periodInDays, bank);
    }
}
