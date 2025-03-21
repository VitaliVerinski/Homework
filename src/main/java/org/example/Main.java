package org.example;

import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Виталий", "Группа 1", 1, 8));
        students.add(new Student("Анна", "Группа 2", 2, 6));
        students.add(new Student("Сергей", "Группа 1", 1, 3));
        students.add(new Student("Геннадий", "Группа 2", 1, 2));
        Dekanat.infoStudents(students, 1);
        Dekanat.kickStudent(students);
        Dekanat.upStudents(students);
        Dekanat.infoStudents(students, 2);
        Dekanat.infoStudents(students, 3);
        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", 123456);
        td.add("Иванов", 123456);
        td.add("Иванов", 1234567);
        td.add("Петров", 123456);
        td.add("Петров", 123456789);
        td.add("Сидоров", 123456);
        td.add("Сидоров", 42342342);
        System.out.println("Телефоны Иванова: " + td.get("Иванов"));
        System.out.println("Телефоны Петрова: " + td.get("Петров"));
        System.out.println("Телефоны сидорова: " + td.get("Сидоров"));
    }

}