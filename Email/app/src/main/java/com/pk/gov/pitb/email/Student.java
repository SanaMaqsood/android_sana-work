package com.pk.gov.pitb.email;

/**
 * Created by Raza Mehdi on 10/7/2017.
 */

public class Student{
    String name;
    int marks;

    public Student() {
    }

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
