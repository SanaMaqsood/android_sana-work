package com.example.sanapc.practicetabandlist;

import java.io.Serializable;

/**
 * Created by Sana PC on 5/26/2017.
 */

public class Students implements Serializable {

    String SName, SRoll, SAddress,SCNic;

    public Students(String SName, String SRoll, String SAddress, String SCNic) {
        this.SName = SName;
        this.SRoll = SRoll;
        this.SAddress = SAddress;
        this.SCNic = SCNic;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSRoll() {
        return SRoll;
    }

    public void setSRoll(String SRoll) {
        this.SRoll = SRoll;
    }

    public String getSAddress() {
        return SAddress;
    }

    public void setSAddress(String SAddress) {
        this.SAddress = SAddress;
    }

    public String getSCNic() {
        return SCNic;
    }

    public void setSCNic(String SCNic) {
        this.SCNic = SCNic;
    }
}
