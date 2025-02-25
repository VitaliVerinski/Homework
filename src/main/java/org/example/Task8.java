package org.example;

public class Task8 {
    public static void register(String word, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(word);
        }
    }
        public static void main(String[] args) {
        int a = 4;
        String word = "Word";
            register(word,a);
    }

}
