package task_1.model;

import task_1.model.entity.*;

public enum DepositProduct {
    DEPOSIT_TERMINABLE_PRIVAT(new DepositTerminable(5000, 0.12, 180, Bank.PRIVAT,
            30, 0.02)),

    DEPOSIT_NON_TERMINABLE_PRIVAT(new DepositNonTerminable(5000, 0.14, 180, Bank.PRIVAT)),

    DEPOSIT_REPLENISHED_CREDI(new DepositWithReplenishment(20000, 0.12, 365,
            Bank.CREDI_AGRICOLE,180, 10000)),

    DEPOSIT_PROGRESSIVE_CREDI(new DepositWithProgressiveRate(20000, 0.10, 365,
            Bank.CREDI_AGRICOLE, 0.2)),

    DEPOSIT_TERMINABLE_EXIM(new DepositTerminable(10000, 0.13, 180, Bank.EXIM,
            90, 0.01)),

    DEPOSIT_REPLENISHED_EXIM(new DepositWithReplenishment(10000, 0.14, 180,
            Bank.EXIM,60, 10000)),

    DEPOSIT_TERMINABLE_OTP(new DepositTerminable(10000, 0.12, 365, Bank.OTP,
            60, 0.03)),

    DEPOSIT_NON_TERMINABLE_OTP(new DepositNonTerminable(10000, 0.15, 365, Bank.OTP)),

    DEPOSIT_REPLENISHED_OTP(new DepositWithReplenishment(10000, 0.14, 180, Bank.OTP,
            180, 5000)),

    DEPOSIT_PROGRESSIVE_OTP(new DepositWithProgressiveRate(10000, 0.11, 365,
            Bank.OTP, 0.2));

    private Deposit deposit;

    private DepositProduct(Deposit deposit) {
        this.deposit = deposit;
    }

    public Deposit getDeposit() {
        return deposit;
    }
}
