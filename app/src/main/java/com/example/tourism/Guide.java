package com.example.tourism;

public class Guide {
    private String name;
    private String contact;

    public Guide() {
        // Default constructor required for Firebase
    }

    public Guide(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
