package com.project.basebeauty.entities.concretes;

public class Expert {

    private int expertID;
    private String expertFirstName;
    private String expertLastName;
    private String expertPhoneNumber;
    private String expertEMail;
    private String expertServiceArea; //cruelty-free, acne-prone etc.
    private boolean expertState; //available (1), not-available(0)

    //dummy constructor
    public Expert() {
    }//end of dummy constructor

    public Expert(int expertID, String expertFirstName, String expertLastName, String expertPhoneNumber, String expertEMail, String expertServiceArea, boolean expertState) {
        this.expertID = expertID;
        this.expertFirstName = expertFirstName;
        this.expertLastName = expertLastName;
        this.expertPhoneNumber = expertPhoneNumber;
        this.expertEMail = expertEMail;
        this.expertServiceArea = expertServiceArea;
        this.expertState = expertState;
    }//end of constructor

    public int getExpertID() {
        return expertID;
    }

    public void setExpertID(int expertID) {
        this.expertID = expertID;
    }

    public String getExpertFirstName() {
        return expertFirstName;
    }

    public void setExpertFirstName(String expertFirstName) {
        this.expertFirstName = expertFirstName;
    }

    public String getExpertLastName() {
        return expertLastName;
    }

    public void setExpertLastName(String expertLastName) {
        this.expertLastName = expertLastName;
    }

    public String getExpertPhoneNumber() {
        return expertPhoneNumber;
    }

    public void setExpertPhoneNumber(String expertPhoneNumber) {
        this.expertPhoneNumber = expertPhoneNumber;
    }

    public String getExpertEMail() {
        return expertEMail;
    }

    public void setExpertEMail(String expertEMail) {
        this.expertEMail = expertEMail;
    }

    public String getExpertServiceArea() {
        return expertServiceArea;
    }

    public void setExpertServiceArea(String expertServiceArea) {
        this.expertServiceArea = expertServiceArea;
    }

    public boolean isExpertState() {
        return expertState;
    }

    public void setExpertState(boolean expertState) {
        this.expertState = expertState;
    }
}
