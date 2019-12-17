package task_1_with_interface.model;

import task_1_with_interface.model.entity.*;

import java.math.BigDecimal;

/**
 * This enum is to store the Deposit class instances.
 * Its private constructor to be used for generating a new constant.
 *
 * @author Maria Bilous
 */
public enum DepositProducts {
    DEPOSIT_TERMINABLE_PRIVAT(new DepositTerminable(new BigDecimal(5000), new BigDecimal(0.12),
            180, Bank.PRIVAT, 30, new BigDecimal(0.02))),

    DEPOSIT_NON_TERMINABLE_PRIVAT(new DepositNonTerminable(new BigDecimal(50000), new BigDecimal(0.14),
            180, Bank.PRIVAT)),

    DEPOSIT_REPLENISHED_CREDI(new DepositWithReplenishment(new BigDecimal(20000), new BigDecimal(0.12),
                              365, Bank.CREDI_AGRICOLE,180,
                                new BigDecimal(10000))),

    DEPOSIT_PROGRESSIVE_CREDI(new DepositWithProgressiveRate(new BigDecimal(20000), new BigDecimal(0.10),
                              365, Bank.CREDI_AGRICOLE, new BigDecimal(0.2))),

    DEPOSIT_TERMINABLE_EXIM(new DepositTerminable(new BigDecimal(10000), new BigDecimal(0.13),
            180, Bank.EXIM,90, new BigDecimal(0.01))),

    DEPOSIT_REPLENISHED_EXIM(new DepositWithReplenishment(new BigDecimal(10000), new BigDecimal(0.14), 180,
            Bank.EXIM,60, new BigDecimal(10000))),

    DEPOSIT_TERMINABLE_OTP(new DepositTerminable(new BigDecimal(10000), new BigDecimal(0.12),
                           365, Bank.OTP,60, new BigDecimal(0.03))),

    DEPOSIT_NON_TERMINABLE_OTP(new DepositNonTerminable(new BigDecimal(10000), new BigDecimal(0.15),
            365, Bank.OTP)),

    DEPOSIT_REPLENISHED_OTP(new DepositWithReplenishment(new BigDecimal(10000), new BigDecimal(0.14),
            180, Bank.OTP, 180, new BigDecimal(5000))),

    DEPOSIT_PROGRESSIVE_OTP(new DepositWithProgressiveRate(new BigDecimal(10000), new BigDecimal(0.11),
            365, Bank.OTP, new BigDecimal(0.2)));

    private Deposit deposit;

    private DepositProducts(Deposit deposit) {
        this.deposit = deposit;
    }

    public Deposit getDeposit() {
        return deposit;
    }
}
