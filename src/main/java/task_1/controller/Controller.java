package task_1.controller;

import task_1.model.Utility;
import task_1.model.entity.Deposit;
import task_1.view.View;

import static task_1.view.TextConstants.*;

/**
 * This class is for adding, removing, sorting, filtering
 * and displaying Deposit class instances using
 * functionality implemented in Utility class
 * @author Maria Bilous
 * @see task_1.model.Utility
 */
public class Controller {
    private Utility utility;
    private View view;

    public Controller(Utility utility, View view) {
        this.utility = utility;
        this.view = view;
    }

    public void add(Deposit d) {
        utility.add(d);
    }

    public void remove(Deposit d) {
        utility.remove(d);
    }

    public void displayDepositsSortedByRate() {
        view.printSign(REQUEST_SIGN);
        view.printRequest(DEPOSITS_SORTED_BY_RATE);
        view.displayBasicDepositFields(utility.depositsSortedByRate(utility.getDeposits()));
        view.printSign(NEW_LINE_SIGN);
    }

    public void displayDepositsSortedByBanks() {
        view.printSign(REQUEST_SIGN);
        view.printRequest(DEPOSITS_SORTED_BY_BANK);
        view.displayBasicDepositFields(utility.depositsSortedByBanks(utility.getDeposits()));
        view.printSign(NEW_LINE_SIGN);
    }

    public void displayDepositsTerminable() {
        view.printSign(REQUEST_SIGN);
        view.printRequest(DEPOSITS_TERMINABLE);
        view.displayTerminableDeposits(utility.depositsTerminable(utility.getDeposits()));
        view.printSign(NEW_LINE_SIGN);
    }

    public void displayDepositsWithReplenishment() {
        view.printSign(REQUEST_SIGN);
        view.printRequest(DEPOSITS_WITH_REPLENISHMENT);
        view.displayReplenishedDeposits(utility.depositsWithReplenishment(utility.getDeposits()));
        view.printSign(NEW_LINE_SIGN);
    }

    public void displayDepositsForTheGivenSum(double sum) {
        view.printSign(REQUEST_SIGN);
        view.printRequest(DEPOSITS_FOR_SUM);
        view.displayBasicDepositFields(utility.depositsForTheGivenSum(sum));
        view.printSign(NEW_LINE_SIGN);
    }
}
