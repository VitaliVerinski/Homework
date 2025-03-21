package org.example;

import java.util.Set;

public class Dekanat {
    public static void kickStudent(Set<Student> students) {
        students.removeIf(student -> student.getGrade() < 3.0);
    }
    public static void upStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getGrade() >= 3.0) {
                student.up();
            }
        }
    }
    public static void infoStudents (Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course +" : ");
        for (Student student : students){
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}
