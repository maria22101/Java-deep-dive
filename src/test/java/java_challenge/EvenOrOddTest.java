package java_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EvenOrOddTest {
    @ParameterizedTest
    @CsvSource({
            "22, true",
            "11, false",
            "-1, false",
            "-14, true",
            "-55, false",
            "108, true"
    })
    void evenOrOddChecker(int number, boolean expectedResult) {
        boolean actual = EvenOrOdd.isEven(number);

        assertEquals(actual, expectedResult);
    }
}