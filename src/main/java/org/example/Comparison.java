package org.example;

public class Comparison {
    public String compare(int a, int b) {
        if (a > b) {
            return a + " больше " + b;
        } else if (a < b) {
            return a + " меньше " + b;
        } else {
            return a + " равно " + b;
        }
    }
}
