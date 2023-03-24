package unit_testing;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * This test class is an example of using JUnit4 functionality for parameterized testing
 */
@RunWith(Parameterized.class)
public class AddingUtilTest {
    private int firstNumber;
    private int secondNumber;
    private int sumOfNumbers;

    private AddingUtil addingUtil;

    public AddingUtilTest(int firstNumber, int secondNumber, int sumOfNumbers) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sumOfNumbers = sumOfNumbers;
    }

    @Before
    public void init() {
        addingUtil = new AddingUtil();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> integersAdded() {
        return Arrays.asList(new Object[][] {
                {1, 2, 3},
                {11, 12, 23},
                {0, -12, -12},
                {-35, -6, -41}
        });
    }

    @Test
    public void addIntegersChecker() {
        System.out.println("Testing dataset: " + firstNumber + " plus " + secondNumber);
        assertEquals(sumOfNumbers, addingUtil.addIntegers(firstNumber, secondNumber));
    }
}