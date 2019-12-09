package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class NonLocalControlTransfer5 {
    static void e() {
        System.err.println("#1.in");
        f(); // a frame created, control passed to it
        System.err.println("#1.out"); // keep on working
    }

    static void f() {
        System.err.println(".   #2.in");
        g(); // a frame created, control passed to it
        System.err.println(".   #2.out"); // keep on working
    }

    static void g() {
        System.err.println(".   .   #3.in");
        try {
            h(); // a frame created, control passed to it
        } catch (Error e) { // catching error
            System.err.println(".   .   #3.CATCH"); // keep on working
        }
        System.err.println(".   .   #3.out"); // keep on working
    }

    static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.THROW");
            throw new Error(); // exiting from all the frames ("stack unrolling") using "throw"
        }
        System.err.println(".   .   .   #4.out"); // do not entering
    }

    public static void main(String[] args) {
        e();
    }
}
