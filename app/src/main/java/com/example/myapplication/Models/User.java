package com.example.myapplication.Models;

public class User {
    private String FirstName;
    private String LastName;
    private String Password;
    private String NIC;
    private String Sex;
    private String Country;
    private String Email;

    public User(String firstName, String lastName, String password, String NIC, String sex, String country, String email) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
        this.NIC = NIC;
        Sex = sex;
        Country = country;
        Email = email;
    }

    public User() {

    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }




}
