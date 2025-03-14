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
        Student.infoStudents(students, 1);
        Student.kickStudent(students);
        Student.upStudents(students);
        Student.infoStudents(students, 2);
        Student.infoStudents(students, 3);

        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", 41235123);
        td.add("Иванов", 41235123);
        td.add("Петров", 42342342);

        System.out.println("Телефоны Иванова: " + td.get("Иванов"));
        System.out.println("Телефоны Петрова: " + td.get("Петров"));
    }

}