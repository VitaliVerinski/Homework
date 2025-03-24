import org.example.Arithmetic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestArithmetic {
    private final Arithmetic operations = new Arithmetic();

    @Test
    public void testAdd() {
        Assertions.assertEquals(5, operations.add(2, 3), "2 + 3 должно быть 5");
        Assertions.assertEquals(-1, operations.add(-2, 1), "-2 + 1 должно быть -1");
    }

    @Test
    public void testSubtract() {
        Assertions.assertEquals(-1, operations.subtract(2, 3), "2 - 3 должно быть -1");
        Assertions.assertEquals(-3, operations.subtract(-2, 1), "-2 - 1 должно быть -3");
    }

    @Test
    public void testMultiply() {
        Assertions.assertEquals(6, operations.multiply(2, 3), "2 * 3 должно быть 6");
        Assertions.assertEquals(-2, operations.multiply(-2, 1), "-2 * 1 должно быть -2");
    }

    @Test
    public void testDivide() {
        Assertions.assertEquals(2.0, operations.divide(6, 3), "6 / 3 должно быть 2.0");
        Assertions.assertEquals(-2.0, operations.divide(-6, 3), "-6 / 3 должно быть -2.0");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            operations.divide(1, 0);
        });
        Assertions.assertEquals("Деление на ноль невозможно.", exception.getMessage());
    }
}
