package task_1.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import task_1.model.entity.Deposit;
import task_1.model.entity.DepositNonTerminable;
import task_1.model.entity.DepositTerminable;
import task_1.model.entity.DepositWithReplenishment;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UtilityTest {
    private static Utility utility;

    @Before
    public void runTest() {
        utility = new Utility();
    }

    @Test
    public void testDepositsSortedByRate() {
        Deposit d1 = DepositProduct.DEPOSIT_REPLENISHED_CREDI.getDeposit(); // rate 0.12
        Deposit d2 = DepositProduct.DEPOSIT_NON_TERMINABLE_PRIVAT.getDeposit(); // rate 0.14
        Deposit d3 = DepositProduct.DEPOSIT_PROGRESSIVE_OTP.getDeposit(); // rate 0.11

        List<Deposit> inputlList = new ArrayList<Deposit>() {{
            add(d1);
            add(d2);
            add(d3);
        }};

        List<Deposit> expectedList = new ArrayList<Deposit>() {{
            add(d3);
            add(d1);
            add(d2);
        }};

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);

        Assert.assertEquals(expectedList, utility.depositsSortedByRate(inputlList));
    }

    @Test
    public void testDepositsSortedByBanks() {
        Deposit d1 = DepositProduct.DEPOSIT_NON_TERMINABLE_PRIVAT.getDeposit();
        Deposit d2 = DepositProduct.DEPOSIT_NON_TERMINABLE_OTP.getDeposit();
        Deposit d3 = DepositProduct.DEPOSIT_REPLENISHED_EXIM.getDeposit();

        List<Deposit> inputlList = new ArrayList<Deposit>() {{
            add(d1);
            add(d2);
            add(d3);
        }};

        List<Deposit> expectedList = new ArrayList<Deposit>() {{
            add(d3);
            add(d2);
            add(d1);
        }};

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);

        Assert.assertEquals(expectedList, utility.depositsSortedByBanks(inputlList));
    }

    @Test
    public void testDepositsTerminable() {
        Deposit d1 = DepositProduct.DEPOSIT_TERMINABLE_PRIVAT.getDeposit();
        Deposit d2 = DepositProduct.DEPOSIT_NON_TERMINABLE_OTP.getDeposit();
        Deposit d3 = DepositProduct.DEPOSIT_TERMINABLE_EXIM.getDeposit();

        List<Deposit> inputlList = new ArrayList<Deposit>() {{
            add(d1);
            add(d2);
            add(d3);
        }};

        List<Deposit> expectedList = new ArrayList<Deposit>() {{
            add(d1);
            add(d3);
        }};

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);

        Assert.assertEquals(expectedList, utility.depositsTerminable(inputlList));
    }

    @Test
    public void testDepositsWithReplenishment() {
        Deposit d1 = DepositProduct.DEPOSIT_REPLENISHED_EXIM.getDeposit();
        Deposit d2 = DepositProduct.DEPOSIT_NON_TERMINABLE_OTP.getDeposit();
        Deposit d3 = DepositProduct.DEPOSIT_REPLENISHED_CREDI.getDeposit();

        List<Deposit> inputlList = new ArrayList<Deposit>() {{
            add(d1);
            add(d2);
            add(d3);
        }};

        List<Deposit> expectedList = new ArrayList<Deposit>() {{
            add(d1);
            add(d3);
        }};

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);

        Assert.assertEquals(expectedList, utility.depositsWithReplenishment(inputlList));
    }

    @Test
    public void testDepositsForTheGivenSum() {
        Deposit d1 = DepositProduct.DEPOSIT_REPLENISHED_EXIM.getDeposit(); // for sum 10000
        Deposit d2 = DepositProduct.DEPOSIT_NON_TERMINABLE_OTP.getDeposit(); // for sum 10000
        Deposit d3 = DepositProduct.DEPOSIT_REPLENISHED_CREDI.getDeposit(); // for sum 20000
        Deposit d4 = DepositProduct.DEPOSIT_TERMINABLE_PRIVAT.getDeposit(); // for sum 5000
        Deposit d5 = DepositProduct.DEPOSIT_PROGRESSIVE_CREDI.getDeposit(); // for sum 20000
        double availableSum1 = 5000;
        double availableSum2 = 12000;
        double availableSum3 = 20000;

        List<Deposit> inputlList = new ArrayList<Deposit>() {{
            add(d1);
            add(d2);
            add(d3);
            add(d4);
            add(d5);
        }};

        List<Deposit> expectedList1 = new ArrayList<Deposit>() {{ // for availableSum1
            add(d4);
        }};
        List<Deposit> expectedList2 = new ArrayList<Deposit>() {{ // for availableSum2
            add(d1);
            add(d2);
            add(d4);
        }};
        List<Deposit> expectedList3 = new ArrayList<Deposit>() {{ // for availableSum3
            add(d1);
            add(d2);
            add(d3);
            add(d4);
            add(d5);
        }};

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        utility.add(d4);
        utility.add(d5);

        Assert.assertEquals(expectedList1, utility.depositsForTheGivenSum(availableSum1));
        Assert.assertEquals(expectedList2, utility.depositsForTheGivenSum(availableSum2));
        Assert.assertEquals(expectedList3, utility.depositsForTheGivenSum(availableSum3));
    }
}