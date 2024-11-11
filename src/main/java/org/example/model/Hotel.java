package org.example.model;

public class Hotel {
    private int hotelId;
    private String name;
    private String location;

    public Hotel(int hotelId, String name, String location) {
        this.hotelId = hotelId;
        this.name = name;
        this.location = location;
    }

    public int getHotelId() {
        return hotelId;
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}

