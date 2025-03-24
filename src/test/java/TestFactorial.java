import org.example.Factorial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFactorial {
    private final Factorial factorialCalculator = new Factorial();

    @Test
    public void testFactorialZero() {
        Assertions.assertEquals(1, factorialCalculator.factorial(0), "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialNumbers() {
        Assertions.assertEquals(1, factorialCalculator.factorial(1), "Факториал 1 должен быть 1");
        Assertions.assertEquals(2, factorialCalculator.factorial(2), "Факториал 2 должен быть 2");
        Assertions.assertEquals(6, factorialCalculator.factorial(3), "Факториал 3 должен быть 6");
    }

    @Test
    public void testFactorialNegativeNumber() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            factorialCalculator.factorial(-1);
        });
        Assertions.assertEquals("Число должно быть положительным", exception.getMessage());
    }
}
