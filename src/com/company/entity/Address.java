package com.company.entity;

public class Address {
    private int id;
    private String city;
    private String street;
    private String numHome;
    private int building;
    private int numApart;

    public Address(int id, String city, String street, String numHome, int building, int numApart) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.numHome = numHome;
        this.building = building;
        this.numApart = numApart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumHome() {
        return numHome;
    }

    public void setNumHome(String numHome) {
        this.numHome = numHome;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public int getNumApart() {
        return numApart;
    }

    public void setNumApart(int numApart) {
        this.numApart = numApart;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", numHome='" + numHome + '\'' +
                ", building=" + building + '\'' +
                ", numApart=" + numApart +
                '}';
    }
}
