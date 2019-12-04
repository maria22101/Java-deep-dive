package task_1.model;

import task_1.model.entity.Deposit;
import task_1.model.entity.DepositTerminable;

public enum DepositProduct {
    DEPOSIT_TERMINABLE(new DepositTerminable(10000, 0.12, 365, Bank.OTP,
            60, 0.03));



//    task_1.model.entity.Deposit d1 = new DepositNonTerminable(1000, 0.15, 365, Bank.PRIVAT);
//    task_1.model.entity.Deposit d2 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d3 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
//            60, 0.03);
//    task_1.model.entity.Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d2 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
//            60, 0.03);
//    task_1.model.entity.Deposit d3 = new DepositWithReplenishment(1000, 0.12, 180, Bank.CREDI_AGRICOLE);
//task_1.model.entity.Deposit d1 = new DepositTerminable(10000, 0.12, 365, Bank.EXIM,
//        180, 0.04);
//    task_1.model.entity.Deposit d2 = new DepositWithReplenishment(1000, 0.13, 180, Bank.EXIM);
//    task_1.model.entity.Deposit d3 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
//            60, 0.03);
//    task_1.model.entity.Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d2 = new DepositWithReplenishment(1000, 0.13, 180, Bank.EXIM);
//    task_1.model.entity.Deposit d3 = new DepositWithReplenishment(1000, 0.12, 180, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d2 = new DepositWithReplenishment(10000, 0.13, 180, Bank.EXIM);
//    task_1.model.entity.Deposit d3 = new DepositWithReplenishment(10000, 0.12, 180, Bank.CREDI_AGRICOLE);
//    task_1.model.entity.Deposit d4 = new DepositTerminable(50000, 0.14, 365, Bank.OTP,
//            60, 0.03);

    private DepositProduct(Deposit deposit) {
    }

//    private double sum;
//    private double interestRate;
//    private int periodInDays;
//    private Bank bank;
//
//    private int daysPassedBeforeTermination;
//    private double interestRateForTermination;
//
////    private int daysLeftTillEndOfPeriod;
////    private double replenishmentSum;
//
//    private double progressRate;
//
//
//
//    private Deposit(double sum, double interestRate, int periodInDays, Bank bank,
//                    int daysPassedBeforeTermination, double interestRateForTermination) {
//        this(sum, interestRate, periodInDays, bank);
//        this.daysPassedBeforeTermination = daysPassedBeforeTermination;
//        this.interestRateForTermination = interestRateForTermination;
//    }
//
//    private Deposit(double sum, double interestRate, int periodInDays,
//                    Bank bank, double progressRate) {
//        this(sum, interestRate, periodInDays, bank);
//        this.progressRate = progressRate;
//    }
}
