package com.example.Practice.RateLimiter.models;

import java.util.Objects;

public class Device implements Clients {
    String deviceId;
    String name;

    public Device(String deviceId, String name) {
        this.deviceId = deviceId;
        this.name = name;
    }

    @Override
    public String getIdentifier() {
        return deviceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(deviceId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Device other = (Device) obj;
        return Objects.equals(deviceId, other.deviceId);
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId='" + deviceId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }
}
