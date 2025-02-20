package org.example;

public class task2 {
    public static void main(String[] args) {
    checkSumSign();
}
    public static void checkSumSign(){
    int a = 4;
    int b = -5;
    int c = a + b;
    if (c>=0) {
        System.out.println("Сумма положительная");
    }
    else {
        System.out.println("Сумма отрицательная");
    }
    }
}
