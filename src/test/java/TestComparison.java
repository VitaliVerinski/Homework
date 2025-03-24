import org.example.Comparison;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestComparison {
    private final Comparison comparator = new Comparison();

    @Test
    public void testCompareGreater() {
        Assertions.assertEquals("5 больше 3", comparator.compare(5, 3), "5 должно быть больше 3");
    }

    @Test
    public void testCompareLesser() {
        Assertions.assertEquals("2 меньше 4", comparator.compare(2, 4), "2 должно быть меньше 4");
    }

    @Test
    public void testCompareEqual() {
        Assertions.assertEquals("7 равно 7", comparator.compare(7, 7), "7 должно быть равно 7");
    }

    @Test
    public void testCompareNegativeNumbers() {
        Assertions.assertEquals("-1 больше -5", comparator.compare(-1, -5), "-1 должно быть больше -5");
        Assertions.assertEquals("-3 меньше -2", comparator.compare(-3, -2), "-3 должно быть меньше -2");
        Assertions.assertEquals("-4 равно -4", comparator.compare(-4, -4), "-4 должно быть равно -4");
    }
}
