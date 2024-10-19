```mermaid
classDiagram
    class User {
      <<abstract>>
      -string userID PK
      +string name
      +string email
      -string password
      +string role
      +login()
      +logout()
    }
    class Customer {
      +list booking
      +searchPackage()
      +makeBooking()
      +cancelBooking()
    }
    class Admin {
      +addTravelPackage()
      +updateTravelPackage()
      +removeTravelPackage()
      +printBookings(string UserID)
    }
    class TravelPackage {
      <<abstract>>
      +string packageID
      +string destination
      +string price
      +string availability
      +string type
    }
    class Flight {
      +string flightNumber
    }
    class Hotel {
      +string hotelName
    }
    class Tour {
      +string tourGuide
    }
    class Booking {
      -string bookingID
      -User user
      -TravelPackage travelPackage
      -date date
      -string status
      +confirmBooking()
      +cancelBooking()
    }

    User <|-- Customer
    User <|-- Admin
    TravelPackage <|-- Flight
    TravelPackage <|-- Hotel
    TravelPackage <|-- Tour
    Customer --> Booking : has 
    Booking "1" --> "1" TravelPackage : contains 