package com.effectivejava.item1;

/**
 * Example class demonstrating advantages of static factory methods.
 * This Point class shows how static factory methods can provide:
 * 1. Named methods (better readability)
 * 2. Flexibility in object creation
 * 3. Ability to return subtypes
 */
public class Point {
    private final double x;
    private final double y;
    
    // Private constructor - forces use of static factory methods
    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Static factory method with descriptive name
    public static Point fromCartesian(double x, double y) {
        return new Point(x, y);
    }
    
    // Another static factory method with different name and logic
    public static Point fromPolar(double radius, double angle) {
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        return new Point(x, y);
    }
    
    // Static factory method that can return null (constructor cannot)
    public static Point fromString(String coordinates) {
        if (coordinates == null || coordinates.trim().isEmpty()) {
            return null;
        }
        try {
            String[] parts = coordinates.split(",");
            double x = Double.parseDouble(parts[0].trim());
            double y = Double.parseDouble(parts[1].trim());
            return new Point(x, y);
        } catch (Exception e) {
            return null;
        }
    }
    
    // Static factory method that returns cached instance
    public static Point origin() {
        return new Point(0, 0);
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }
}


