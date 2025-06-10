package com.tourandtravel.data;

import java.util.HashMap;

public class DistanceData {
    // Map to hold city-to-city distances in kilometers
    private static final HashMap<String, Integer> distanceMap = new HashMap<>();

    static {
        // Example distances between city pairs
        distanceMap.put("Delhi-Mumbai", 1400);
        distanceMap.put("Mumbai-Delhi", 1400);

        distanceMap.put("Delhi-Bangalore", 2150);
        distanceMap.put("Bangalore-Delhi", 2150);

        distanceMap.put("Mumbai-Bangalore", 980);
        distanceMap.put("Bangalore-Mumbai", 980);

        distanceMap.put("Kolkata-Chennai", 1670);
        distanceMap.put("Chennai-Kolkata", 1670);

        // Add more as needed
    }

    public static int getDistance(String from, String to) {
        String key = from + "-" + to;
        return distanceMap.getOrDefault(key, -1); // return -1 if distance not found
    }

    public static int calculateFlightPrice(String from, String to, String flightClass) {
        int baseRatePerKm = switch (flightClass) {
            case "Economy" -> 5;
            case "Business" -> 10;
            case "First Class" -> 20;
            default -> 5;
        };

        int distance = getDistance(from, to);
        if (distance == -1) {
            return -1; // Invalid route
        }

        return baseRatePerKm * distance;
    }
}
