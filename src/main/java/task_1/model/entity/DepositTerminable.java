package task_1.model.entity;

import task_1.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author Maria Bilous
 */
public class DepositTerminable extends Deposit {
    private int daysPassedBeforeTermination;
    private BigDecimal interestRateForTermination;

    public DepositTerminable(BigDecimal sum, BigDecimal interestRate, int periodInDays, Bank bank,
                             int daysPassedBeforeTermination, BigDecimal interestRateForTermination) {
        super(sum, interestRate, periodInDays, bank);
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
        this.interestRateForTermination = interestRateForTermination;
    }

    public BigDecimal calculateIncome() {
        return getSum()
                .multiply(interestRateForTermination)
                .divide(BigDecimal.valueOf(365), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(daysPassedBeforeTermination))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public int getDaysPassedBeforeTermination() {
        return daysPassedBeforeTermination;
    }

    public void setDaysPassedBeforeTermination(int daysPassedBeforeTermination) {
        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
    }

    public BigDecimal getInterestRateForTermination() {
        return interestRateForTermination;
    }

    public void setInterestRateForTermination(BigDecimal interestRateForTermination) {
        this.interestRateForTermination = interestRateForTermination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositTerminable)) return false;
        if (!super.equals(o)) return false;
        DepositTerminable that = (DepositTerminable) o;
        return daysPassedBeforeTermination == that.daysPassedBeforeTermination &&
                interestRateForTermination.equals(that.interestRateForTermination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), daysPassedBeforeTermination, interestRateForTermination);
    }
}
