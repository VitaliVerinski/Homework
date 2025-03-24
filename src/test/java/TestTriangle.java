import org.example.AreaTriangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTriangle {
    private final AreaTriangle areaTriangle = new AreaTriangle();

    @Test
    public void testAreaValidTriangle() {
        Assertions.assertEquals(6.0, areaTriangle.area(3, 4, 5), 0.0001, "Площадь треугольника с сторонами 3, 4, 5 должна быть 6.0");
        Assertions.assertEquals(12.0, areaTriangle.area(5, 5, 6), 0.0001, "Площадь треугольника с сторонами 5, 5, 6 должна быть 12.0");
    }

    @Test
    public void testAreaInvalidTriangle() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            areaTriangle.area(1, 2, 3);
        });
        Assertions.assertEquals("Стороны не могут образовать треугольник", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            areaTriangle.area(5, 1, 1);
        });
        Assertions.assertEquals("Стороны не могут образовать треугольник", exception.getMessage());
    }

    @Test
    public void testAreaNegativeSides() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            areaTriangle.area(-1, 2, 3);
        });
        Assertions.assertEquals("Длины сторон должны быть положительными", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            areaTriangle.area(1, 0, 3);
        });
        Assertions.assertEquals("Длины сторон должны быть положительными", exception.getMessage());

        exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            areaTriangle.area(1, 2, -3);
        });
        Assertions.assertEquals("Длины сторон должны быть положительными", exception.getMessage());
    }
}
