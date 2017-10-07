package com.example.sanapc.studentdatamanagment;

/**
 * Created by Sana PC on 4/19/2017.
 */

public class Student {


    String name;
    String roolNo;

    public Student(String name, String roolNo) {
        this.name = name;
        this.roolNo = roolNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoolNo() {
        return roolNo;
    }

    public void setRoolNo(String roolNo) {
        this.roolNo = roolNo;
    }
}
