```mermaid
erDiagram
    User ||--o{ Booking : "has"
    Booking ||--|| TravelPackage : "refers to"
    User {
        string userID
        string name
        string email
        string password
        string role "Customer/Admin"
    }
    TravelPackage {
        string packageID
        string destination
        string price
        string availability
        string type "Flight/Hotel/Tour"
    }
    Booking {
        string bookingID
        string userID
        string packageID
        date date
        string status
    }