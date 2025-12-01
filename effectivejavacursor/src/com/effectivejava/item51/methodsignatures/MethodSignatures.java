package com.effectivejava.item51.methodsignatures;

import java.util.List;

/**
 * Item 51: Design method signatures carefully.
 * 
 * Best practices:
 * - Choose method names carefully
 * - Don't go overboard with convenience methods
 * - Avoid long parameter lists (use builder pattern)
 * - Prefer interfaces to classes for parameters
 * - Use two-element enum types instead of boolean
 */
public class MethodSignatures {
    
    /**
     * GOOD: Clear method name.
     */
    public static void drawCircle(int x, int y, int radius) {
        // Implementation
    }
    
    /**
     * BAD: Unclear method name.
     */
    public static void draw(int a, int b, int c) {
        // What do a, b, c mean?
    }
    
    /**
     * BAD: Too many parameters.
     * Use builder pattern instead.
     */
    public static void createUser(String firstName, String lastName, 
                                  String email, String phone, 
                                  String address, int age, 
                                  boolean active) {
        // Too many parameters - hard to use
    }
    
    /**
     * GOOD: Use builder pattern for many parameters.
     */
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        // ... other fields
        
        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        
        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        
        public User build() {
            return new User(firstName, lastName);
        }
    }
    
    /**
     * GOOD: Prefer interfaces to classes for parameters.
     */
    public static void processList(List<String> list) {
        // Can accept ArrayList, LinkedList, etc.
    }
    
    /**
     * BAD: Using boolean parameter.
     * Use enum for clarity.
     */
    public static void setThermostat(boolean fahrenheit) {
        // Unclear: what does true mean?
    }
    
    /**
     * GOOD: Using enum instead of boolean.
     */
    public enum TemperatureScale { FAHRENHEIT, CELSIUS }
    
    public static void setThermostat(TemperatureScale scale) {
        // Clear and self-documenting
    }
    
    private static class User {
        private final String firstName;
        private final String lastName;
        
        public User(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}

