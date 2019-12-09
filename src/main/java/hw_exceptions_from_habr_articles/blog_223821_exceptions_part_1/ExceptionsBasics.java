package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class ExceptionsBasics {

    static void throwEx() { // new and throw - two independent operations
        Error ref = new Error();
        throw ref;
    }

    static void stackOverflowEx(NullPointerException e) { // method causes StackOverflowError
        try {
            throw e;
        } catch (NullPointerException npe) {
            stackOverflowEx(npe);
        }
    }

    static double throwAllowsNoReturt(double d) {
        throw new RuntimeException(); // throwing an error allows not having return in a method
    }

    static double area(double width, double height) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("Arguments can not be negative");
        }
        return width * height;
    }

    public static void main(String[] args) {
//        throwEx();
//        stackOverflowEx(new NullPointerException());
        area(-1, 3);
    }
}
