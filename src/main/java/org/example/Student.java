package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Student {
    String name;
    String group;
    int course;
    int grade;
    public Student(String name, String group, int course, int grade){
        this.name = name;
        this.group =group;
        this.course = course;
        this.grade =grade;
    }
    public double getGrade() {
        return grade;
    }
    private void up() {
        this.course++;
    }
    public String getName() {
        return name;
    }
    public int getCourse() {
        return course;
    }

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
