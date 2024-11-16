package org.example.model;

import java.util.Date;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Flight flight;
    private Hotel hotel;

    public Booking(int bookingId, Customer customer, Flight flight, Hotel hotel) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.flight = flight;
        this.hotel = hotel;
    }
    //getters
    public int getBookingId() {
        return bookingId;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Flight getFlight() {
        return flight;
    }
    public Hotel getHotel() {
        return hotel;
    }
    //setters
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setFlight(Flight flight) { this.flight = flight; }
    public void setHotel(Hotel hotel) { this.hotel = hotel; }
}

