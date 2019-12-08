package task_1.model.entity;

import task_1.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Maria Bilous
 */
public class DepositNonTerminable extends Deposit {
    public DepositNonTerminable(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public BigDecimal calculateIncome() {
        return getSum()
                .multiply(getInterestRate())
                .divide(BigDecimal.valueOf(365), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(getPeriodInDays()))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
