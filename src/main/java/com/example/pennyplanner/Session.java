package com.example.pennyplanner;

public class Session {

    private static Session instance;
    private String userID;

    // Private constructor to prevent instantiation
    private Session() {}

    // Get the single instance of Session
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // Getter and Setter for userID
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
