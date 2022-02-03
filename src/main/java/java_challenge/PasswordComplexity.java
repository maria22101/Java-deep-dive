package java_challenge;

import java.util.function.IntPredicate;

/**
 * Class checks password complexity verifying a password complexity:
 * a complex password must have at least:
 * - six characters
 * - one uppercase letter
 * - one lowercase letter
 * - one number
 * The class introduces three ways to do this verification
 */
public class PasswordComplexity {

    private static final int MIN_PASSWORD_LENGTH = 6;

    private static final int UPPERCASE_CHAR_LOWER_BOUND = 65;
    private static final int UPPERCASE_CHAR_UPPER_BOUND = 90;

    private static final int LOWERCASE_CHAR_LOWER_BOUND = 97;
    private static final int LOWERCASE_CHAR_UPPER_BOUND = 122;

    private static final int NUMERIC_CHAR_LOWER_BOUND = 48;
    private static final int NUMERIC_CHAR_UPPER_BOUND = 57;

    public static final String AT_LEAST_ONE_UPPERCASE_LETTER_REGEXP = ".*[A-Z].*";
    public static final String AT_LEAST_ONE_LOWERCASE_LETTER_REGEXP = ".*[a-z].*";
    public static final String AT_LEAST_ONE_NUMERIC_SIGN_REGEXP = ".*\\d.*";

    public static boolean isPasswordComplexUsingInts(String password) {
        return isComposedOfAtLeastSixCharacters(password) &&
                isHavingAtLeastOneUppercaseLetter(password) &&
                isHavingAtLeastOneLowercaseLetter(password) &&
                isHavingAtLeastOneNumber(password);
    }

    public static boolean isPasswordComplexUsingCharacterBuiltInMethods(String password) {
        return isComposedOfAtLeastSixCharacters(password) &&
                password.chars().mapToObj(ch -> (char) ch).anyMatch(Character::isUpperCase) &&
                password.chars().mapToObj(ch -> (char) ch).anyMatch(Character::isLowerCase) &&
                password.chars().mapToObj(ch -> (char) ch).anyMatch(Character::isDigit);
    }

    public static boolean isPasswordComplexUsingRegexp(String password) {
        return isComposedOfAtLeastSixCharacters(password) &&
                password.matches(AT_LEAST_ONE_UPPERCASE_LETTER_REGEXP) &&
                password.matches(AT_LEAST_ONE_LOWERCASE_LETTER_REGEXP) &&
                password.matches(AT_LEAST_ONE_NUMERIC_SIGN_REGEXP);
    }

    private static boolean isComposedOfAtLeastSixCharacters(String password) {
        return password.length() >= MIN_PASSWORD_LENGTH;
    }

    private static boolean isHavingAtLeastOneUppercaseLetter(String password) {
        return password.chars()
                .anyMatch(isCharWithin(UPPERCASE_CHAR_LOWER_BOUND, UPPERCASE_CHAR_UPPER_BOUND));
    }

    private static boolean isHavingAtLeastOneLowercaseLetter(String password) {
        return password.chars()
                .anyMatch(isCharWithin(LOWERCASE_CHAR_LOWER_BOUND, LOWERCASE_CHAR_UPPER_BOUND));
    }

    private static boolean isHavingAtLeastOneNumber(String password) {
        return password.chars()
                .anyMatch(isCharWithin(NUMERIC_CHAR_LOWER_BOUND, NUMERIC_CHAR_UPPER_BOUND));
    }

    private static IntPredicate isCharWithin(int lowerBound, int upperBound) {
        return character -> character >= lowerBound && character <= upperBound;
    }
}
