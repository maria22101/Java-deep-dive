package hw_exceptions_from_habr_articles.blog_223821_exceptions_part_1;

public class MultiCatch {

    static void multiCatch1() {
        try {
            throw new Exception();
        } catch (RuntimeException e) {
            System.err.println("Catch RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception");
        } catch (Throwable e) {
            System.out.println("Catch Throwable");
        }
        System.out.println("Next statement");
    }

    static void multiCatch2() {
        try {
            Throwable t =  new Exception();
            throw t;
        } catch (RuntimeException e) {
            System.err.println("Catch RuntimeException");
        } catch (Exception e) {
            System.out.println("Catch Exception"); // the Exception is catching
        } catch (Throwable e) {
            System.out.println("Catch Throwable");
        }
        System.out.println("Next statement");
    }

    public static void main(String[] args) {
        multiCatch1();
        multiCatch2();
    }
}
