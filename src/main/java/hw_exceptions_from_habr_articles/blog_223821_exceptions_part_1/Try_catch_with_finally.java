package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class Try_catch_with_finally {

    static void tryCatchWithFinally1() {
        try {
            System.err.print(1);
        } catch (Error e) {
            System.err.print(2);
        } finally {
            System.err.print(3);
        }
        System.err.print(4);
    }

    static void tryCatchWithFinally2() {
        try {
            System.err.print(0);
            if (true) {
                throw new Error();
            }
            System.err.print(1);
        } catch (Error e) {
            System.err.print(2);
        } finally {
            System.err.print(3);
        }
        System.err.print(4);
    }

    static void tryCatchWithFinally3() {
        try {
            System.err.print(0);
            if (true) {
                throw new RuntimeException();
            }
            System.err.print(1);
        } catch (Error e) {
            System.err.print(2);
        } finally {
            System.err.print(3);
        }
        System.err.print(4);
    }

    static void tryCatchWithFinally4() {
        try {
            System.err.print(0);
            try {
                System.err.print(1);
                System.err.print(2);
            } catch (RuntimeException e) {
                System.err.print(3);
            } finally {
                System.err.print(4);
            }
            System.err.print(5);
        } catch (Exception e) {
            System.err.print(6);
        } finally {
            System.err.print(7);
        }
        System.err.print(8);
    }

    static void tryCatchWithFinally5() {
        try {
            System.err.print(0);
            try {
                System.err.print(1);
                if(true) {
                    throw new RuntimeException();
                }
                System.err.print(2);
            } catch (RuntimeException e) {
                System.err.print(3);
            } finally {
                System.err.print(4);
            }
            System.err.print(5);
        } catch (Exception e) {
            System.err.print(6);
        } finally {
            System.err.print(7);
        }
        System.err.print(8);
    }

    static void tryCatchWithFinally6() {
        try {
            System.err.print(0);
            try {
                System.err.print(1);
                if(true) {
                    throw new Exception();
                }
                System.err.print(2);
            } catch (RuntimeException e) {
                System.err.print(3);
            } finally {
                System.err.print(4);
            }
            System.err.print(5);
        } catch (Exception e) {
            System.err.print(6);
        } finally {
            System.err.print(7);
        }
        System.err.print(8);
    }

    static void tryCatchWithFinally7() {
        try {
            System.err.print(0);
            try {
                System.err.print(1);
                if(true) {
                    throw new Error();
                }
                System.err.print(2);
            } catch (RuntimeException e) {
                System.err.print(3);
            } finally {
                System.err.print(4);
            }
            System.err.print(5);
        } catch (Exception e) {
            System.err.print(6);
        } finally {
            System.err.print(7);
        }
        System.err.print(8);
    }

    public static void main(String[] args) {
//        tryCatchWithFinally1(); // 134
//        tryCatchWithFinally2(); // 0234
//        tryCatchWithFinally3(); // 03Exception in thread "main" java.lang.RuntimeException
//        tryCatchWithFinally4(); // 0124578
//        tryCatchWithFinally5(); // 0134578
//        tryCatchWithFinally6(); // 014678
        tryCatchWithFinally7(); // 0147Exception in thread "main" java.lang.Error
    }
}
