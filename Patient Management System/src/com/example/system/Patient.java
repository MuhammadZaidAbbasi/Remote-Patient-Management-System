package com.example.system;

public class Patient {
    private String name;
    private int heartRate;

    public Patient(String name, int heartRate) {
        this.name = name;
        this.heartRate = heartRate;
    }

    public String getName() {
        return name;
    }

    public int getHeartRate() {
        return heartRate;
    }
}
