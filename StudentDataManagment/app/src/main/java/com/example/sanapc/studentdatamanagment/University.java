package com.example.sanapc.studentdatamanagment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sana PC on 4/20/2017.
 */

public class University implements Serializable {
    String name, city, country;
    List<Courses> mCources = new ArrayList<>();
    ArrayList<Student> mStudent=new ArrayList<>();

    public University(ArrayList<Student> mStudent) {
        this.mStudent = mStudent;
    }

    public University(String name, String city, String country, List<Courses> mCources) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.mCources = mCources;
    }

    public University() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Courses> getmCources() {
        return mCources;
    }

    public void setmCources(List<Courses> mCources) {
        this.mCources = mCources;
    }

    public ArrayList<Student> getmStudent() {
        return mStudent;
    }

    public void setmStudent(ArrayList<Student> mStudent) {
        this.mStudent = mStudent;
    }
}
