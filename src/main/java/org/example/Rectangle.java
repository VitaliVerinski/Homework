package org.example;

public class Rectangle implements Task2 {
    public double width;
    public double height;
    public String fillColor;
    public String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public String getFillColor() {
        return "";
    }

    @Override
    public String getBorderColor() {
        return "";
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }
}
