import org.example.Arithmetic;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ArithmeticTest {
    private final Arithmetic operations = new Arithmetic();

    @Test
    public void testAdd() {
        Assert.assertEquals(operations.add(1, 1), 2, "1 + 1 должно быть 2");
        Assert.assertEquals(operations.add(-1, 1), 0, "-1 + 1 должно быть 0");
    }

    @Test
    public void testSubtract() {
        Assert.assertEquals(operations.subtract(2, 1), 1, "2 - 1 должно быть 1");
        Assert.assertEquals(operations.subtract(0, 1), -1, "0 - 1 должно быть -1");
    }

    @Test
    public void testMultiply() {
        Assert.assertEquals(operations.multiply(2, 2), 4, "2 * 2 должно быть 4");
        Assert.assertEquals(operations.multiply(-2, 2), -4, "-2 * 2 должно быть -4");
    }

    @Test
    public void testDivide() {
        Assert.assertEquals(operations.divide(4, 2), 2.0,  "4/2 должно быть 2.0");
        Assert.assertEquals(operations.divide(-4, 2), -2.0, "-4/2 должно быть -2.0");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivideByZero() {
        operations.divide(1, 0);
    }
}
