package org.example;

import java.util.Arrays;

public class task11 {
    public static void main(String[] args) {
        int[] array = new int[101];
        for (int i = 0; i <= 100; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
    }
}