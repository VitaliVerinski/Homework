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
    protected double getGrade() {
        return grade;
    }
    protected void up() {
        this.course++;
    }
    protected String getName() {
        return name;
    }
    protected int getCourse() {
        return course;
    }
}
