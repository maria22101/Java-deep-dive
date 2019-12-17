package task_1_with_interface.model.entity;

import task_1_with_interface.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author Maria Bilous
 */
public class DepositTerminable extends DepositProduct {
    private int daysPassedBeforeTermination;
    private BigDecimal interestRateForTermination;

    public DepositTerminable(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank,
                             int daysPassedBeforeTermination, BigDecimal interestRateForTermination) {
        super(sum, interestRate, periodInDays, bank);
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
        this.interestRateForTermination = interestRateForTermination;
    }

    public BigDecimal calculateIncome() {
        return sum()
                .multiply(interestRateForTermination)
                .divide(BigDecimal.valueOf(365), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(daysPassedBeforeTermination))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public int getDaysPassedBeforeTermination() {
        return daysPassedBeforeTermination;
    }

    public BigDecimal getInterestRateForTermination() {
        return interestRateForTermination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositTerminable)) return false;
        DepositTerminable that = (DepositTerminable) o;
        return daysPassedBeforeTermination == that.daysPassedBeforeTermination &&
                interestRateForTermination.equals(that.interestRateForTermination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(daysPassedBeforeTermination, interestRateForTermination);
    }
}
