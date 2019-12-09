package hw_exceptions_from_habr_articles.blog_225585_exceptions_part_2;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Checked_unchecked_exceptions {

    static void thr1() throws RuntimeException { // method throws unchecked exception
    }

    static void noObligationToProcessUncheckedException() {
        thr1();
    }

    static void mult1() throws EOFException, FileNotFoundException { // multiple checked exceptions throwing
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }

    static void thr2() throws EOFException {
    }

    static void thr3() throws FileNotFoundException {
    }

    static void thr4() throws InterruptedException {
    }

    static void mult2() throws EOFException, FileNotFoundException { // multiple checked exceptions throwing
        thr2();
        thr3();
    }

    static void mult3() throws IOException { // IOException - parent class for the both exceptions in the method
        if (System.currentTimeMillis() % 2 == 0) {
            throw new EOFException();
        } else {
            throw new FileNotFoundException();
        }
    }

    static void mult4() throws IOException, InterruptedException { // multiple checked exceptions throwing
        thr2();
        thr3();
        thr4();
    }

    static void partlyCaught() throws FileNotFoundException { // do not indicate as "throws" what already caught
        try {
            if (System.currentTimeMillis() % 2 == 0) {
                throw new EOFException();
            } else {
                throw new FileNotFoundException();
            }
        } catch (EOFException e) {
            e.printStackTrace();
        }
    }

    static void exceptionTypeMismatch1() throws Exception {
        Throwable t = new Exception();
//        throw t; // compilation error as the reference is of type Throwable - is not what the method throws
    }

    static void exceptionTypeMatch2() throws Exception {
        try {
            Throwable t = new Exception();
//            throw t; // compilation error as the reference is of type Throwable - is not what the method throws
        }catch (Exception e) { // even providing Exception catching
            System.out.println("Caught");
        }
    }

    static void exceptionTypeMatch() throws Throwable { // now it is accepted (matching exception types)
        try {
            Throwable t = new Exception();
            throw t;
        }catch (Exception e) {
            System.out.println("Caught");
        }
    }
}
