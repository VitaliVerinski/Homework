package org.example;

public interface Interface {
    String getFillColor();
    String getBorderColor();

    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }
}
