package org.example;

public class Animal {
    public static int allAnimals = 0;
    public static int allCats = 0;
    public static int allDogs = 0;

    public Animal() {
        allAnimals++;
    }

    public static int infoAllAnimals() {
        return allAnimals;
    }

    public static int infoAllCats() {
        return allCats;
    }

    public static int infoAllDogs() {
        return allDogs;
    }
    }

