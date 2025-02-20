package org.example;

public class task3 {
    public static void main(String[] args) {
    PrintColor();
}
    public static void PrintColor(){
        int value = 100;
        if (value <=0) {
            System.out.println("Красный");
        } else if (value<=100) {
            System.out.println("Жёлтый");
        }
        else {
            System.out.println("Зелёный");
        }
    }
}
