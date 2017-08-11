package com.example.sanapc.recyclerviewandjeasonparsing.dto;

/**
 * Created by Sana PC on 7/25/2017.
 */

public class HospitalItems {
    int id ;
    String name;
    String email;
    String contact;
    double longitude;
    double latitude;
    String city;
    String country;
    String timeStamp;

    public HospitalItems(int id, String name, String email, String contact, double longitude, double latitude, String city, String timeStamp, String country) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.timeStamp = timeStamp;
        this.country = country;
    }
}
