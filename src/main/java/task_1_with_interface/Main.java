package task_1_with_interface;

import task_1_with_interface.controller.Controller;
import task_1_with_interface.model.DepositProducts;
import task_1_with_interface.model.Utility;
import task_1_with_interface.view.View;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        View view = new View();

        Controller controller = new Controller(utility, view);

        controller.add(DepositProducts.DEPOSIT_NON_TERMINABLE_OTP.getDeposit());
        controller.add(DepositProducts.DEPOSIT_TERMINABLE_EXIM.getDeposit());
        controller.add(DepositProducts.DEPOSIT_REPLENISHED_CREDI.getDeposit());

        controller.displayDepositsSortedByBanks();
        controller.displayDepositsSortedByRate();
        controller.displayDepositsWithReplenishment();
    }
}
