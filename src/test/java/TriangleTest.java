import org.example.AreaTriangle;
import org.example.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TriangleTest {
    private final AreaTriangle calculator = new AreaTriangle();

    @Test
    public void testArea() {
        Assert.assertEquals(calculator.area(3, 4,5), 6, "площадь должна быть ровна 6");
        Assert.assertEquals(calculator.area(3, 3,3), 3.897114317029974, "площадь должна быть ровна 3.897114317029974");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSide() {
    calculator.area(-1,2,3);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidSide() {
        calculator.area(1,2,3);
    }
}
