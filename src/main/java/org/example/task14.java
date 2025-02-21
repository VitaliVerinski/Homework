package org.example;

import java.util.Arrays;

public class task14 {
    public static void main(String[] args) {
        int len = 7;
        int initialValue = 8;
        int[] array = Array(len, initialValue);
        System.out.println(Arrays.toString(array));
    }

    public static int[] Array(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}
