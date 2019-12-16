package task_1_with_interface.model.entity;

import task_1_with_interface.model.Bank;

import java.math.BigDecimal;

public interface Deposit {
    BigDecimal sum();
    BigDecimal interestRate();
    int periodInDays();
    Bank bank();
    BigDecimal calculateIncome();
}
