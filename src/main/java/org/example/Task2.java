package org.example;

public interface Task2 {
    String getFillColor();
    String getBorderColor();

    default double calculatePerimeter() {
        return 0;
    }

    default double calculateArea() {
        return 0;
    }
}
