package unit_testing;

public class AddingUtil {

    public int addIntegers(int a, int b) {
        long result = ((long) a) + b;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) result;
    }
}
