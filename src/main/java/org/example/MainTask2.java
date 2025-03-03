package org.example;

public class MainTask2 {
    public static void main(String[] args) {
        Task2 circle = new Circle(5, "Красный", "Черный");
        Task2 rectangle = new Rectangle(4, 6, "Зеленый", "Черный");
        Task2 triangle = new Triangle(3, 4, 5, "Красный", "Синий");

        System.out.println("Круг: ");
        System.out.println("Цвет фона: " + circle.getFillColor());
        System.out.println("Цвет границ: " + circle.getBorderColor());
        System.out.println("Периметр: " + circle.calculatePerimeter());
        System.out.println("Площадь: " + circle.calculateArea());

        System.out.println("Прямоугольник: ");
        System.out.println("Цвет фона: " + rectangle.getFillColor());
        System.out.println("Цвет границ: " + rectangle.getBorderColor());
        System.out.println("Периметр: " + rectangle.calculatePerimeter());
        System.out.println("Площадь: " + rectangle.calculateArea());

        System.out.println("Треугольник: ");
        System.out.println("Цвет фона: " + triangle.getFillColor());
        System.out.println("Цвет границ: " + triangle.getBorderColor());
        System.out.println("Периметр: " + triangle.calculatePerimeter());
        System.out.println("Площадь: " + triangle.calculateArea());
    }
}
