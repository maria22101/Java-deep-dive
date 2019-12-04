package task_1.model.entity;

import task_1.model.Bank;

import java.util.Objects;

public class DepositWithProgressiveRate extends DepositNonTerminable {
    private double progressRate;

    public DepositWithProgressiveRate(double sum, double interestRate, int periodInDays,
                                      Bank bank, double progressRate) {
        super(sum, interestRate, periodInDays, bank);
        this.progressRate = progressRate;
    }

    @Override
    public double calculateIncome() {
        double initialRateIncome = super.calculateIncome();
        double progressRateIncome = 0;
        double progressRateMonthly = 0;
        int progressPeriods = (int) (getPeriodInDays() % 30);

        for (int i = 1; i <= progressPeriods; i++) {
            progressRateMonthly += progressRate;
            progressRateIncome += getSum() * progressRateMonthly / 365 * i;
        }

        return initialRateIncome + progressRateIncome;
    }

    public double getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(double progressRate) {
        this.progressRate = progressRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DepositWithProgressiveRate)) return false;
        if (!super.equals(o)) return false;
        DepositWithProgressiveRate that = (DepositWithProgressiveRate) o;
        return Double.compare(that.progressRate, progressRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), progressRate);
    }

    @Override
    public String toString() {
        return "DepositWithProgressiveRate{" +
                "sum=" + getSum() +
                ", interestRate=" + getInterestRate() +
                ", periodInDays=" + getPeriodInDays() +
                ", bank=" + getBank() +
                "progressRate=" + progressRate +
                '}';
    }
}
