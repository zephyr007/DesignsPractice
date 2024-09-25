package com.example.Practice.RateLimiter;

import com.example.Practice.RateLimiter.models.Device;
import com.example.Practice.RateLimiter.models.User;

public class Main {
    public static void main(String[] args) {

        User user = new User("Alice", "alice@gmail.com");
        User user2 = new User("Bob", "bob@gmail.com");
        User user3 = new User("Carl", "carl@gmail.com");
        Device device = new Device("Samsung-Device2846q8", "Sam's Phone");
        Device device1 = new Device("Samsung-Alice", "Alice's Phone");

        RateLimiter rateLimiter = new RateLimiter(5); // Quota: 5 requests per minute

        // Simulating multiple requests with a small wait between them
        for (int i = 0; i < 70; i++) {
            System.out.println("TimeStamp ->");

            rateLimiter.isAllowed(device);
            rateLimiter.isAllowed(user);
            rateLimiter.isAllowed(device1);
            rateLimiter.isAllowed(user2);
            rateLimiter.isAllowed(user3);

            // Add a wait of 1 second between each iteration
            waitFor(1000);
        }
    }

    // Wait function to introduce a delay in milliseconds
    public static void waitFor(int milliseconds) {
        try {
            Thread.sleep(milliseconds); // Sleep for the specified time in milliseconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
