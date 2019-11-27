package HW_2_test_video_exercise;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class ArithmeticsTest {
    private static Arithmetics a;

    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Rule
    public Timeout time = new Timeout(1000);

    @BeforeClass
    public static void runTest() {
        a = new Arithmetics();
    }

    @Test
    public void testAdd() {
        int result = a.add(1, 2);
        Assert.assertEquals(3, result);
    }

    @Ignore
    @Test
    public void testDeduct() {
        int result = a.deduct(1, 2);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testMultiply() {
        int result = a.multiply(2, 3);
        Assert.assertEquals(6, result);
    }

    @Test
    public void testDivide() {
        double result = a.divide(6, 2);
//        if(result != 3.0) Assert.fail();
        Assert.assertEquals(3.0, result, 0.0 );
    }

//    @Test(expected = Exception.class)
    @Test
    public void testDivideException() {
        exp.expect(ArithmeticException.class);
        a.divide(6, 0);
    }
}