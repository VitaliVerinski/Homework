package org.example;

public class Triangle implements Task2 {
    public double sideA;
    public double sideB;
    public double sideC;
    public String fillColor;
    public String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
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
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = (sideA + sideB + sideC)/2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
}
