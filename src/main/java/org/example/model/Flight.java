package org.example.model;

public class Flight {
    private int flightId;
    private String origin;
    private String destination;
    private String departureDate;

    public Flight(int flightId, String origin, String destination, String departureDate) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
    }
    //getters and setters
    public int getFlightId() {
        return flightId;
    }


    public String getOrigin() {
        return origin;
    }
    public String getDestination() {
        return destination;
    }
    public String getDepartureDate() {
        return departureDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }
}

