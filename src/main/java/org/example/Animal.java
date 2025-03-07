package org.example;

abstract class Animal {
    public static int allAnimals = 0;


    public Animal() {
        allAnimals++;
    }

    public static int infoAllAnimals() {
        return allAnimals;
    }
    public void run(int distance) {

    }
    public void swim(int distance) {

    }



}

