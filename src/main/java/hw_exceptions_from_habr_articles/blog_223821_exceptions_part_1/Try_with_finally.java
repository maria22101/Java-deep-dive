package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class Try_with_finally {

    static void tryWithFinally1() {
        try {
            System.err.println("try");
        } finally {
            System.err.println("finally");
        }
    }

    static void tryWithFinally2() {
        try {
            throw new RuntimeException();
        } finally {
            System.err.println("finally");
        }
    }

    static void tryWithFinally3() {
        try {
            return;
        } finally {
            System.err.println("finally");
        }
    }

    static void tryWithFinally4() {
        try {
            System.exit(42); // or Runtime.getRuntime().exit(42) => JVM is out
        } finally {
            System.err.println("finally"); // will not be executed
        }
    }

    static void tryWithFinally5() {
        try {
            System.err.println("try");
            if(true) {
                throw new RuntimeException();
            }
        } finally {
            System.err.println("finally");
        }
        System.err.println("more"); // will not be executed
    }

    static void tryWithFinally6() {
        try {
            System.err.println("try");
            if(true) {
                return;
            }
        } finally {
            System.err.println("finally"); // finally does not prevent exit from the method
        }
        System.err.println("more"); // will not be executed
    }

    static int tryWithFinally7() {
        try {
            return 1;
        } finally {
            return 0; // return in finally block has priority
        }
    }

    static int tryWithFinally8() {
        try {
            throw new RuntimeException();
        } finally {
            return 0; // return in finally block has priority, will suppress throwing the RuntimeException in try block
        }
    }

    static int tryWithFinally9() {
        try {
            return 0;
        } finally {
            throw new RuntimeException(); // has priority, will suppress return in the try block
        }
    }

    public static void main(String[] args) {
//        tryWithFinally1();
//        tryWithFinally2();
//        tryWithFinally3();
//        tryWithFinally4();
//        tryWithFinally5();
//        tryWithFinally6();
        System.out.println(tryWithFinally7());
        System.out.println(tryWithFinally8());
        System.out.println(tryWithFinally9());
    }
}
