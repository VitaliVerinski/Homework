package org.example;
import java.util.Arrays;

public class task13 {
    public static void main(String[] args) {
        int a = 5;
        int[][] array = new int[a][a];
        for (int i = 0; i < a; i++) {
            array[i][i] = 1;
        }
        diagonal(array);
    }

    public static void diagonal(int[][] array) {
        for (int[] i : array) {
            for (int value : i) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}
