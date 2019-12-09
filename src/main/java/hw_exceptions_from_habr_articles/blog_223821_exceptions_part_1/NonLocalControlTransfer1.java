package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class NonLocalControlTransfer1 {

    static void e() {
        System.err.println("#1.in");
        f(); // a frame created, control passed to it
        System.err.println("#1.out"); // exiting after instructions end
    }

    static void f() {
        System.err.println(".   #2.in");
        g(); // a frame created, control passed to it
        System.err.println(".   #2.out"); // exiting after instructions end
    }

    static void g() {
        System.err.println(".   .   #3.in");
        h(); // a frame created, control passed to it
        System.err.println(".   .   #3.out"); // exiting after instructions end
    }

    static void h() {
        System.err.println(".   .   .   #4.in");
        if (true) {
            System.err.println(".   .   .   #4.RETURN"); // exiting from the current frame with return
            return;
        }
        System.err.println(".   .   .   #4.out"); // not entering
    }

    public static void main(String[] args) {
        e();
    }
}
