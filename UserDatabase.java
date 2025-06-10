package com.tourandtravel.data;

import java.util.ArrayList;

public class UserDatabase {
    // Session-related info (if needed globally)
    public static String cityFrom;
    public static String cityTo;
    public static String departureDate;
    public static String returnDate;
    public static String selectedClass;
    public static User loggedInUser;

    // List to store all registered users
    public static ArrayList<User> registeredUsers = new ArrayList<>();
    
    static 
    {
        registeredUsers.add(new User("guest", "123")); //default user
    }

    // ✅ Add new user (returns false if username already exists)
    public static boolean addUser(User newUser) 
    {
        if (userExists(newUser.getUsername())) 
        {
            return false;
        }
        registeredUsers.add(newUser);
        return true;
    }

    // ✅ Validate login credentials
    public static boolean validateLogin(String username, String password) {
        for (User u : registeredUsers) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // ✅ Get user by username
    public static User getUser(String username) 
    {
        for (User u : registeredUsers) {
            if (u.getUsername().equalsIgnoreCase(username))
            {
                return u;
            }
        }
        return null;
    }

    // ✅ Check if user exists by username
    public static boolean userExists(String username) 
    {
        for (User u : registeredUsers) {
            if (u.getUsername().equalsIgnoreCase(username))
            {
                return true;
            }
        }
        return false;
    }

    public static class User 
    {
        private String username;
        private String password;
        private String age;
        private String phone;
        private ArrayList<String> pastTours;
        private ArrayList<String> futureTours;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.age = "";
            this.phone = "";
            this.pastTours = new ArrayList<>();
            this.futureTours = new ArrayList<>();
        }

        public String getUsername() { return username; }
        public String getPassword() { return password; }

        public String getAge() { return age; }
        public void setAge(String age) { this.age = age; }

        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }

        public ArrayList<String> getPastTours() { return pastTours; }
        public ArrayList<String> getFutureTours() { return futureTours; }

        public void addPastTour(String tour) 
        {
            pastTours.add(tour);
        }

        public void addFutureTour(String tour)
        {
            futureTours.add(tour);
        }
    }
}
