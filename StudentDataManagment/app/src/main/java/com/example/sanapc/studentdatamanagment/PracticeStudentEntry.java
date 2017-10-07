package com.example.sanapc.studentdatamanagment;

import java.io.Serializable;


/**
 * Created by Sana PC on 5/15/2017.
 */

public class PracticeStudentEntry implements Serializable{
    String sName;
    String sRoll;
    String sAddress;
    String sEdu;

    public PracticeStudentEntry(String sName, String sRoll, String sAddress, String sEdu) {
        this.sName = sName;
        this.sRoll = sRoll;
        this.sAddress = sAddress;
        this.sEdu = sEdu;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsRoll() {
        return sRoll;
    }

    public void setsRoll(String sRoll) {
        this.sRoll = sRoll;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsEdu() {
        return sEdu;
    }

    public void setsEdu(String sEdu) {
        this.sEdu = sEdu;
    }
}
