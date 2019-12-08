package task_1.model.entity;

import task_1.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author Maria Bilous
 */
public class DepositWithReplenishment extends DepositNonTerminable{
    private int daysLeftTillEndOfPeriod;
    private BigDecimal replenishmentSum;

    public DepositWithReplenishment(BigDecimal sum, BigDecimal interestRate, int periodInDays,
                                    Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public DepositWithReplenishment(BigDecimal sum, BigDecimal interestRate, int periodInDays,
                                    Bank bank, int daysLeftTillEndOfPeriod, BigDecimal replenishmentSum) {
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
    public BigDecimal calculateIncome() {
        BigDecimal initialSumIncome = super.calculateIncome();
        BigDecimal replenishmentIncome = replenishmentSum
                .multiply(getInterestRate())
                .divide(BigDecimal.valueOf(365), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(daysLeftTillEndOfPeriod))
                .setScale(2, RoundingMode.HALF_UP);
        return initialSumIncome.add(replenishmentIncome);
    }

    public int getDaysLeftTillEndOfPeriod() {
        return daysLeftTillEndOfPeriod;
    }

    public void setDaysLeftTillEndOfPeriod(int daysLeftTillEndOfPeriod) {
        this.daysLeftTillEndOfPeriod = daysLeftTillEndOfPeriod;
    }

    public BigDecimal getReplenishmentSum() {
        return replenishmentSum;
    }

    public void setReplenishmentSum(BigDecimal replenishmentSum) {
        this.replenishmentSum = replenishmentSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositWithReplenishment)) return false;
        if (!super.equals(o)) return false;
        DepositWithReplenishment that = (DepositWithReplenishment) o;
        return daysLeftTillEndOfPeriod == that.daysLeftTillEndOfPeriod &&
                replenishmentSum.equals(that.replenishmentSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), daysLeftTillEndOfPeriod, replenishmentSum);
    }
}
