import org.example.Comparison;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCompare {
    private final Comparison comparator = new Comparison();

    @Test
    public void testCompareGreater() {
        Assert.assertEquals(comparator.compare(2, 1), "2 больше 1", "2 должно быть больше 1");
    }

    @Test
    public void testCompareLesser() {
        Assert.assertEquals(comparator.compare(1, 2), "1 меньше 2", "1 должно быть меньше 2");
    }

    @Test
    public void testCompareEqual() {
        Assert.assertEquals(comparator.compare(3, 3), "3 равно 3", "3 должно быть равно 3");
    }

    @Test
    public void testCompareNegativeNumbers() {
        Assert.assertEquals(comparator.compare(-1, -5), "-1 больше -5", "-1 должно быть больше -5");
        Assert.assertEquals(comparator.compare(-2, -1), "-2 меньше -1", "-2 должно быть меньше -1");
        Assert.assertEquals(comparator.compare(-2, -2), "-2 равно -2", "-2 должно быть равно -2");
    }
}
