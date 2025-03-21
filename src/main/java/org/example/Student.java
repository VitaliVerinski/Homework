package org.example;

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
    public void up() {
        this.course++;
    }
    public String getName() {
        return name;
    }
    public int getCourse() {
        return course;
    }
}
