package com.example.sanapc.studentdatamanagment;

import java.io.Serializable;

/**
 * Created by Sana PC on 4/19/2017.
 */

public class Teacher implements Serializable {
    String TName;
    String classTeacher;
    String cniC;
    String Salary;

    public Teacher(String TName, String classTeacher, String cniC, String salary) {
        this.TName = TName;
        this.classTeacher = classTeacher;
        this.cniC = cniC;
        Salary = salary;
    }

    public String getTName() {
        return TName;
    }

    public void setTName(String TName) {
        this.TName = TName;
    }

    public String getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(String classTeacher) {
        this.classTeacher = classTeacher;
    }

    public String getCniC() {
        return cniC;
    }

    public void setCniC(String cniC) {
        this.cniC = cniC;
    }

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }
}
