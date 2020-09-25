package com.journaldev.androidmaterialtextfields.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "UI")
public class UI {
    // columns
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String phone;
    String area;
    String address;
    String city;
    String country;
    String postcode;
    String email;
    String dob;


    public UI(String name, String phone, String area, String address, String city, String country, String postcode, String email, String dob) {
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.email = email;
        this.dob = dob;
    }

    @Ignore
    public UI(int id, String name, String phone, String area, String address, String city, String country, String postcode, String email, String dob) {
        this.name = name;
        this.phone = phone;
        this.area = area;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.email = email;
        this.dob = dob;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String number) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String pincode) {
        this.address = address;
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

    public void setCountry(String pincode) {
        this.country = country;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDob() {
        return dob;
    }
}