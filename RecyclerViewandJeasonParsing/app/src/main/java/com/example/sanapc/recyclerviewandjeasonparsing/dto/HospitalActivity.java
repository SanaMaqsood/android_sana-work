package com.example.sanapc.recyclerviewandjeasonparsing.dto;

import java.util.ArrayList;

/**
 * Created by Sana PC on 7/26/2017.
 */

public class HospitalActivity {
    int id;
    String name, email, contact,city, country,timestamp;
    double longitude, latitude;
    Staff staff=new Staff();

    ArrayList<Rooms> roomses= new ArrayList<>();

    public ArrayList<Rooms> getRoomses() {
        return roomses;
    }

    public void setRoomses(ArrayList<Rooms> roomses) {
        this.roomses = roomses;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

   public class Staff{
        public ArrayList<doctors> getDoctorses() {
            return doctorses;
        }

        public void setDoctorses(ArrayList<doctors> doctorses) {
            this.doctorses = doctorses;
        }

        public ArrayList<Swipper> getSwippers() {
            return swippers;
        }

        public void setSwippers(ArrayList<Swipper> swippers) {
            this.swippers = swippers;
        }

        ArrayList<doctors> doctorses=new ArrayList<>();
        ArrayList<Swipper> swippers=new ArrayList<>();
    }
 public static final class doctors{
    String doctr_name;

    public doctors(String doctr_name) {
        this.doctr_name = doctr_name;
    }

    public String getDoctr_name() {
        return doctr_name;
    }

    public void setDoctr_name(String doctr_name) {
        this.doctr_name = doctr_name;
    }
}
    public static final class Swipper{
        public Swipper(String name) {
            this.name = name;
        }

        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static final class Rooms{
        public Rooms(String rooms) {
            this.rooms = rooms;
        }

        String rooms;

        public String getRooms() {
            return rooms;
        }

        public void setRooms(String rooms) {
            this.rooms = rooms;
        }
    }
}
