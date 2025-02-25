package org.example;

public class Task6 {
    public static void upOrDown(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    public static void main(String[] args) {
        int a =-12;
        upOrDown(a);
    }
}