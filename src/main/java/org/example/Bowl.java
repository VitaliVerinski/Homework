package org.example;

public class Bowl {
    private int food;

    public Bowl(int food)
    {
        this.food = food;
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
        System.out.println("добавлено еды " + amount);
    }
}
