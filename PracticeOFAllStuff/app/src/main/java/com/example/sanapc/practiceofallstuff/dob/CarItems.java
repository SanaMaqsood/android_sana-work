package com.example.sanapc.practiceofallstuff.dob;

import java.io.Serializable;

/**
 * Created by Sana PC on 7/18/2017.
 */

public class CarItems implements Serializable {
   public int id;
   public String name, model, year, regNo;

    public CarItems(int id, String name, String model, String year, String regNo) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.year = year;
        this.regNo = regNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
