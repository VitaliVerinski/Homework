package org.example;

public class Dog extends Animal {
    private static int allDogs = 0;
    private String name;


    public Dog (String name){
        super();
        this.name =name;
        allDogs++;
    }
    public static int infoAllDogs() {

        return allDogs;
    }

    public void swim (int distance){
        if (distance <=10) {
            System.out.println("Собака " + name + " проплыла " + distance + " метров");
        }
        else System.out.println("Собака не может проплыть больше 10 метров");
    }
    public  void  run (int distance){
        if (distance <=500) {
            System.out.println("Собака " + name +" пробежала " + distance + " метров");
        }
        else System.out.println("Собака не может бежать больше 500 метров");
    }
}
