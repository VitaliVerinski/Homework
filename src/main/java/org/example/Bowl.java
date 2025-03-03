package org.example;

public class Bowl {
    public int food;

    public Bowl(int _food) {
        this.food = _food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int amount) {
        if (food - amount >= 0) {
            food -= amount;
        }
    }

    public void addFood(int amount) {
        food += amount;
    }
}
