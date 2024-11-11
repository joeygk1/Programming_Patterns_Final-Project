package org.example;

import java.time.LocalDateTime;

public abstract class TravelPackage {

    public String packageId;
    public String destination;
    public String price;
    public LocalDateTime AvailableFrom; //replaced (String Availability, with Available From
    public LocalDateTime AvailableTo; //replaced (String Availability, with Available To
    public String type;

}
