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

        // Выводим общее количество животных
        System.out.println("Всего животных: " + Animal.infoAllAnimals());
        System.out.println("Всего котов: " + Animal.infoAllCats());
        System.out.println("Всего собак: " + Animal.infoAllDogs());

        Bowl bowl = new Bowl(30);
        Cat.setBowl(bowl);


        // Коты пытаются покушать
        catBoris.eat(10);
        catSnezok.eat(20);
        catBoris.eat(5);
    }
}
