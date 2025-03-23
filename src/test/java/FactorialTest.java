import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialTest {
    private final Factorial calculator = new Factorial();

    @Test
    public void testFactorialOfZero() {
        Assert.assertEquals(calculator.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        Assert.assertEquals(calculator.factorial(5), 120, "Факториал 5 должен быть 120");
        Assert.assertEquals(calculator.factorial(10), 3628800, "Факториал 10 должен быть 3628800");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOfNegativeNumber() {
        calculator.factorial(-1);
    }
}
