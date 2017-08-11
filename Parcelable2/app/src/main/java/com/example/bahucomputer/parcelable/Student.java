package com.example.bahucomputer.parcelable;

import android.os.Parcel;
import android.os.Parcelable;


public class Student implements Parcelable { // Parcable

    String name;

    String registration;

    public Student(String name, String registration) {
        this.name = name;
        this.registration = registration;
    }


    public Student(Parcel source) {

        name = source.readString();
        registration = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override


    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(registration);
    }

    public String getName() {
        return name;
    }

    public String getRegistration() {
        return registration;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }

        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }
    };

}


