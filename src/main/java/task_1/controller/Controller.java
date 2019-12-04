package task_1.controller;

import task_1.model.Utility;
import task_1.model.entity.Deposit;
import task_1.view.View;

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
        view.printMessage(view.DEPOSITS_SORTED_BY_RATE);
        utility.displayDepositsSortedByRate();
    }

    public void displayDepositsSortedByBanks() {
        view.printMessage(view.DEPOSITS_SORTED_BY_BANK);
        utility.displayDepositsSortedByBanks();
    }

    public void displayDepositsTerminable() {
        view.printMessage(view.DEPOSITS_TERMINABLE);
        utility.displayDepositsTerminable();
    }

    public void displayDepositsWithReplenishment() {
        view.printMessage(view.DEPOSITS_WITH_REPLENISHMENT);
        utility.displayDepositsWithReplenishment();
    }

    public void displayDepositsForTheGivenSum(double sum) {
        view.printMessage(view.DEPOSITS_FOR_SUM);
        utility.displayDepositsForTheGivenSum(sum);
    }
}
