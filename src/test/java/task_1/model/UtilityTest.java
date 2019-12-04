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
    private static List<Deposit> expectedList;
    private static List<Deposit> resultList;

    @Before
    public void runTest() {
        utility = new Utility();
        expectedList = new ArrayList<Deposit>();
        resultList = new ArrayList<Deposit>();
    }

    @Test
    public void testDepositsSortedByRate() {
        Deposit d1 = new DepositNonTerminable(1000, 0.15, 365, Bank.PRIVAT);
        Deposit d2 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
        Deposit d3 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
                60, 0.03);

        expectedList.add(d3);
        expectedList.add(d2);
        expectedList.add(d1);

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        resultList = utility.depositsSortedByRate();

        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void testDepositsSortedByBanks() {
        Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
        Deposit d2 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
                60, 0.03);
        Deposit d3 = new DepositWithReplenishment(1000, 0.12, 180, Bank.CREDI_AGRICOLE);

        expectedList.add(d1);
        expectedList.add(d3);
        expectedList.add(d2);

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        resultList = utility.depositsSortedByBanks();

        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void testDepositsTerminable() {
        Deposit d1 = new DepositTerminable(10000, 0.12, 365, Bank.EXIM,
                180, 0.04);
        Deposit d2 = new DepositWithReplenishment(1000, 0.13, 180, Bank.EXIM);
        Deposit d3 = new DepositTerminable(10000, 0.13, 365, Bank.OTP,
                60, 0.03);

        expectedList.add(d1);
        expectedList.add(d3);

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        resultList = utility.depositsTerminable();

        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void testDepositsWithReplenishment() {
        Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
        Deposit d2 = new DepositWithReplenishment(1000, 0.13, 180, Bank.EXIM);
        Deposit d3 = new DepositWithReplenishment(1000, 0.12, 180, Bank.CREDI_AGRICOLE);

        expectedList.add(d2);
        expectedList.add(d3);

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        resultList = utility.depositsWithReplenishment();

        Assert.assertEquals(expectedList, resultList);
    }

    @Test
    public void testDepositsForTheGivenSum() {
        Deposit d1 = new DepositNonTerminable(1000, 0.14, 365, Bank.CREDI_AGRICOLE);
        Deposit d2 = new DepositWithReplenishment(10000, 0.13, 180, Bank.EXIM);
        Deposit d3 = new DepositWithReplenishment(10000, 0.12, 180, Bank.CREDI_AGRICOLE);
        Deposit d4 = new DepositTerminable(50000, 0.14, 365, Bank.OTP,
                60, 0.03);

        expectedList.add(d1);
        expectedList.add(d2);
        expectedList.add(d3);

        utility.add(d1);
        utility.add(d2);
        utility.add(d3);
        utility.add(d4);
        resultList = utility.depositsForTheGivenSum(12000);

        Assert.assertEquals(expectedList, resultList);
    }
}