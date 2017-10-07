package com.example.sanapc.studentdatamanagment;


import java.io.Serializable;

/**
 * Created by Sana PC on 4/25/2017.
 */

public class AddData implements Serializable {
    String Name,Address,Education;

    public AddData(String name, String address, String education) {
        Name = name;
        Address = address;
        Education = education;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }
}
