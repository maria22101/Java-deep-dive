package task_1.Model.Entity;

import task_1.Model.Bank;

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
        int progressPeriods = (int) (getPeriodInDays() % 30);

        for (int i = 1; i < progressPeriods; i++) {
            progressRateIncome += getSum() * progressRate / 365 * (getPeriodInDays() - progressPeriods * i);
        }

        return initialRateIncome + progressRateIncome;
    }

    public double getProgressRate() {
        return progressRate;
    }

    public void setProgressRate(double progressRate) {
        this.progressRate = progressRate;
    }
}
