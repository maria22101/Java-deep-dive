package task_1_with_interface.model.entity;

import task_1_with_interface.model.Bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * @author Maria Bilous
 */
public class DepositWithProgressiveRate extends DepositNonTerminable {
    private BigDecimal progressRate;

    public DepositWithProgressiveRate(BigDecimal sum, BigDecimal interestRate, int periodInDays,
                                      Bank bank, BigDecimal progressRate) {
        super(sum, interestRate, periodInDays, bank);
        this.progressRate = progressRate;
    }

    /**
     *This method calculates income for this class instance as follows:
     * first - the related super class method applied;
     * second - additional income calculated assuming progressRate
     * cumulative increase every 30 days.
     * @return double value - income for an instance of this class
     */
    @Override
    public BigDecimal calculateIncome() {
        double progressRateIncome = 0;
        double progressRateMonthly = 0;
        int progressPeriods = periodInDays() / 30;
        for (int i = 1; i <= progressPeriods; i++) {
            progressRateMonthly += progressRate.doubleValue();
            progressRateIncome += sum().doubleValue() * progressRateMonthly / 365 * 30;
        }

        BigDecimal initialRateIncome = super.calculateIncome();
        BigDecimal progressRateIncomeBigDcml = new BigDecimal(progressRateIncome);

        return initialRateIncome
                .add(progressRateIncomeBigDcml)
                .setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositWithProgressiveRate)) return false;
        if (!super.equals(o)) return false;
        DepositWithProgressiveRate that = (DepositWithProgressiveRate) o;
        return progressRate.equals(that.progressRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), progressRate);
    }
}
