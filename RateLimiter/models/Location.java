package com.example.Practice.RateLimiter.models;

import java.util.Objects;

public class Location implements Clients  {
    String locationId;
    String name;

    public Location(String name, String email) {
        this.locationId = name;
        this.name = email;
    }


    @Override
    public String getIdentifier() {
        return locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        Location other = (Location) obj;
        return Objects.equals(locationId, other.locationId);
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
