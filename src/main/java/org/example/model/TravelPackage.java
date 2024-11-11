package org.example.model;

public abstract class TravelPackage {
    protected String packageID;
    protected String destination;
    protected double price;
    protected boolean availability;

    public TravelPackage(String packageID, String destination, double price, boolean availability) {
        this.packageID = packageID;
        this.destination = destination;
        this.price = price;
        this.availability = availability;
    }

    public String getPackageID() {
        return packageID;
    }

    public void setPackageID(String packageID) {
        this.packageID = packageID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public abstract String getType();
}
