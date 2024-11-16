package org.example.model;

public class Admin extends User {
    private String adminLevel;

    public Admin(int userId, String email, String password, String adminLevel) {
        super(userId, email, password);
        this.adminLevel = adminLevel;
    }

    //getter
    public String getAdminLevel() {
        return adminLevel;
    }
    //setter
    public void setAdminLevel(String adminLevel) {
        this.adminLevel = adminLevel;
    }

    @Override
    public String getRole() {
        return "Admin";
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", adminLevel='" + adminLevel + '\'' +
                '}';
    }
}
