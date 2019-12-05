package task_1;

import task_1.controller.Controller;
import task_1.model.DepositProduct;
import task_1.model.Utility;
import task_1.view.View;

public class Main {
    public static void main(String[] args) {
        Utility utility = new Utility();
        View view = new View();

        Controller controller = new Controller(utility, view);

        controller.add(DepositProduct.DEPOSIT_TERMINABLE_EXIM.getDeposit());
        controller.add(DepositProduct.DEPOSIT_TERMINABLE_PRIVAT.getDeposit());
        controller.add(DepositProduct.DEPOSIT_NON_TERMINABLE_OTP.getDeposit());
        controller.add(DepositProduct.DEPOSIT_PROGRESSIVE_CREDI.getDeposit());
        controller.add(DepositProduct.DEPOSIT_PROGRESSIVE_OTP.getDeposit());
        controller.add(DepositProduct.DEPOSIT_REPLENISHED_CREDI.getDeposit());

        controller.displayDepositsSortedByRate();
        controller.displayDepositsSortedByBanks();
        controller.displayDepositsTerminable();
        controller.displayDepositsWithReplenishment();
        controller.displayDepositsForTheGivenSum(10000);

        controller.remove(DepositProduct.DEPOSIT_TERMINABLE_EXIM.getDeposit());
        controller.displayDepositsSortedByBanks();
    }
}
