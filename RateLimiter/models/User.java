package com.example.Practice.RateLimiter.models;

import java.util.Objects;

public class User implements Clients  {
    String name;
    String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    @Override
    public String getIdentifier() {
        return email;
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null) return false;
        if(getClass() != obj.getClass()) return false;

        User other = (User) obj;
        return Objects.equals(email, other.email);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
