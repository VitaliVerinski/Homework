package org.example;

public class Task9 {

    public static boolean bigYear(int a) {
        if (a % 400 == 0) {
            return true;
        } else if (a % 100 == 0) {
            return false;
        } else return a % 4 == 0;
    }
    public static void main(String[] args) {
        int a =800;
        System.out.println(bigYear(a));
}
}
