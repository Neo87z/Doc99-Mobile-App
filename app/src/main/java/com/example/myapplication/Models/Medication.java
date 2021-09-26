package com.example.myapplication.Models;

public class Medication {
    private String RequesterName;
    private String ContactNumber;
    private String Address;
    private String Prescription;
    private String MesSage;
    private String USerID;
    private String Status;



    public Medication() {
    }

    public Medication(String requesterName, String contactNumber, String address, String prescription, String mesSage, String USerID) {
        RequesterName = requesterName;
        ContactNumber = contactNumber;
        Address = address;
        Prescription = prescription;
        MesSage = mesSage;
        this.USerID = USerID;
    }

    public String getRequesterName() {
        return RequesterName;
    }

    public void setRequesterName(String requesterName) {
        RequesterName = requesterName;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPrescription() {
        return Prescription;
    }

    public void setPrescription(String prescription) {
        Prescription = prescription;
    }

    public String getMesSage() {
        return MesSage;
    }

    public void setMesSage(String mesSage) {
        MesSage = mesSage;
    }

    public String getUSerID() {
        return USerID;
    }

    public void setUSerID(String USerID) {
        this.USerID = USerID;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
