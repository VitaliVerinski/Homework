package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cat catBoris = new Cat("Борис");
        Dog dogBobik = new Dog("Бобик");
        Cat catSnezok = new Cat("Снежок");

        catSnezok.run(80);
        catSnezok.swim(0);

        catBoris.run(60);
        catBoris.swim(5);

        dogBobik.run(200);
        dogBobik.swim(6);


        System.out.println("Всего животных: " + Animal.infoAllAnimals());
        System.out.println("Всего котов: " + Animal.infoAllCats());
        System.out.println("Всего собак: " + Animal.infoAllDogs());

        Bowl bowl = new Bowl(30);
        Cat.setBowl(bowl);

        catBoris.eat(10);
        catSnezok.eat(20);
        catBoris.eat(5);

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
