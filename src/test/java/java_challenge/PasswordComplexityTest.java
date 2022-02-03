package java_challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PasswordComplexityTest {

    @ParameterizedTest
    @CsvSource({
            "123, false",
            "123999B0, false",
            "AA123999B0, false",
            "AA123999B0p, true",
            "ArA123999B0ms, true",
            "ArAdjfEBms, false",
            "45dfdf123, false"
    })
    void isPasswordComplexUsingInts(String password, boolean expectedResult) {
        boolean actualResult = PasswordComplexity.isPasswordComplexUsingInts(password);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "123, false",
            "123999B0, false",
            "AA123999B0, false",
            "AA123999B0p, true",
            "ArA123999B0ms, true",
            "ArAdjfEBms, false",
            "45dfdf123, false"
    })
    void isPasswordComplexUsingCharacterBuiltInMethods(String password, boolean expectedResult) {
        boolean actualResult = PasswordComplexity.isPasswordComplexUsingCharacterBuiltInMethods(password);

        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "123, false",
            "123999B0, false",
            "AA123999B0, false",
            "AA123999B0p, true",
            "ArA123999B0ms, true",
            "ArAdjfEBms, false",
            "45dfdf123, false"
    })
    void isPasswordComplexUsingRegexp(String password, boolean expectedResult) {
        boolean actualResult = PasswordComplexity.isPasswordComplexUsingRegexp(password);

        assertEquals(expectedResult, actualResult);
    }
}