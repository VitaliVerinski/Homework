package org.example;

public class Cat extends Animal{
    private String name;
    private boolean catFull;
    private static Bowl bowl;
    private static int allCats = 0;

    public static int infoAllCats() {

        return allCats;
    }

    public Cat (String name ){
        super();
        this.name =name;
        allCats++;
        this.catFull = false;
    }

    public void swim (int distance) {
        if (distance > 0) {
            System.out.println("Коты не умеют плавать");
        }
        else System.out.println("кот не плыл");
    }
    public  void  run (int distance){
        if (distance <=200) {
            System.out.println("Кот " + name + " пробежал " + distance + " метров");
        }
        else System.out.println("Кот не может бежать больше 200 метров");
    }
    public void eat(int amount) {
        if (bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            catFull = true;
            System.out.println(name + " покушал " + amount + " единиц еды.");
        } else {
            System.out.println("коту" + name + " не хватает еды в миске");
        }
    }

    public static void setBowl(Bowl bowl) {
        Cat.bowl = bowl;
    }

    public boolean isFull() {
        return catFull;
    }
}
