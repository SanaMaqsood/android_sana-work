package com.example.sanapc.studentdatamanagment;

import java.io.Serializable;

/**
 * Created by Sana PC on 4/20/2017.
 */

public class Courses implements Serializable{
    String courseName;
    Integer Id;  //int

    public Courses(String courseName, Integer id) {
        this.courseName = courseName;
        Id = id;
    }

    public Courses() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }
}
