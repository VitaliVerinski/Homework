package org.example;

public class Circle implements Task2 {

    public double radius;
    public String fillColor;
    public String borderColor;



    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }

    @Override
    public double calculatePerimeter() {
        return 3.14 * radius ;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

