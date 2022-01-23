package unit_testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * This test class is an example of using JUnit5 functionality for parameterized testing
 */
public class AddingUtilTest_JUnit5 {

    private AddingUtil addingUtil;

    @BeforeEach
    void init() {
        addingUtil = new AddingUtil();
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "11, 12, 23",
            "0, -12, -12",
            "-35, -6, -41"
    })
    void addIntegersChecker(int firstNumber, int secondNumber, int expectedSumOfNumbers) {
        int actual = addingUtil.addIntegers(firstNumber, secondNumber);

        assertEquals(expectedSumOfNumbers, actual);
    }
}
