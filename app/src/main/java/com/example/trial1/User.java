package com.example.trial1;

public class User{

    private String username;
    private String telehandle;
    public int number;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String telegramHandle) {
        this.telehandle = telegramHandle;
    }

    public User(String username, String telegramHandle, int number) {
        this.username = username;
        this.telehandle = telegramHandle;
        this.number = number;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelehandle() {
        return telehandle;
    }

    public void setTelehandle(String telehandle) {
        this.telehandle = telehandle;
    }
}

