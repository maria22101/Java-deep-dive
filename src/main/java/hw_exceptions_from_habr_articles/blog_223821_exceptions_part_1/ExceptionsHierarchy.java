package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class ExceptionsHierarchy {

    static void parentException1() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1);
        } catch (Exception e) { // all exceptions derived from Exception will be caught
            System.err.print(2);
        }
        System.err.print(3);
    }

    static void parentException2() {
        try {
            if (true) {
                throw new RuntimeException();
            }
        } catch (Exception e) { // all exceptions derived from Exception will be caught
            if (e instanceof RuntimeException) {
                RuntimeException re = (RuntimeException) e;
                System.err.print("This is a RunTimeException");
            } else {
                System.err.print("Will not be shown");
            }
        }
    }

    static void oneLevelException() {
        try {
            System.err.print(0);
            if (true) {
                throw new Error();
            }
            System.err.print(1);
        } catch (Exception e) { // the Error exception will not be caught
            // as Error and Exception is not in child-parent relations
            System.err.print(2);
        }
        System.err.print(3);
    }

    static void exceptionInCatch1() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1);
        } catch (RuntimeException e) {
            System.err.print(2);
            if (true) {
                throw new Error();
            }
        }
        System.err.print(3); // will be missing as the Error was generated
    }

    static void exceptionInCatch2() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1);
        } catch (RuntimeException e) {
            System.err.print(2);
            if (true) {
                throw e;
            }
        }
        System.err.print(3); // will be missing as the RuntimeException was re-thrown
    }

    static void exceptionInCatch3() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1);
        } catch (RuntimeException e) {
            System.err.print(2);
            if (true) {
                throw new Error();
            }
        } catch (Error e) {
            System.err.print(3); // will be missing as the Error was generated
        }
        System.err.print(4); // will be missing as the Error was generated
    }

    static void exceptionInCatch4() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1); // we will not enter here
        } catch (RuntimeException e) {
            System.err.print(2);
            try {
                System.err.print(3);
                if (true) {
                    throw new Error();
                }
                System.err.print(4); // we will not enter here
            } catch (Throwable t) {
                System.err.print(5);
            }
        } catch (Error e) { // we will not enter here, as the Error has already been caught
            System.err.print(6);
        }
        System.err.print(7); // we will get this point, it will be executed
    }


    public static void main(String[] args) {
//        parentException1(); // 023
//        parentException2(); // This is a RunTimeException
//        oneLevelException(); // 0Exception in thread "main" java.lang.Error
//        exceptionInCatch1(); // 02Exception in thread "main" java.lang.Error
//        exceptionInCatch2(); // 02Exception in thread "main" java.lang.RuntimeException
//        exceptionInCatch3(); // 02Exception in thread "main" java.lang.Error
        exceptionInCatch4(); // 02357
    }
}
