package task_1_with_interface.model.entity;

import task_1_with_interface.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Maria Bilous
 */
public class DepositNonTerminable extends DepositProduct {
    public DepositNonTerminable(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank) {
        super(sum, interestRate, periodInDays, bank);
    }

    public BigDecimal calculateIncome() {
        return sum()
                .multiply(interestRate())
                .divide(BigDecimal.valueOf(365), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(periodInDays()))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
