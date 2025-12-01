package com.effectivejava.item10.overrideequals;

import java.util.Objects;

/**
 * Example demonstrating the equals contract violation problem with inheritance.
 * 
 * This shows the "ColorPoint problem" - you cannot add a value component
 * to an equals contract without violating the contract.
 * 
 * Problem: If Point.equals() ignores color and ColorPoint.equals() considers color,
 * then symmetry is violated:
 * - point.equals(colorPoint) might be true
 * - colorPoint.equals(point) might be false
 * 
 * Solutions:
 * 1. Use composition instead of inheritance (preferred)
 * 2. Make equals() final in superclass (prevents subclassing)
 * 3. Use getClass() instead of instanceof (violates Liskov Substitution Principle)
 */
public class ColorPoint {
    private final Point point;
    private final String color;  // Using String instead of java.awt.Color for module compatibility
    
    public ColorPoint(int x, int y, String color) {
        this.point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }
    
    /**
     * Returns the point-view of this color point.
     */
    public Point asPoint() {
        return point;
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint)) {
            return false;
        }
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }
    
    @Override
    public String toString() {
        return String.format("ColorPoint[point=%s, color=%s]", point, color);
    }
    
    /**
     * Simple Point class for demonstration.
     */
    public static class Point {
        private final int x, y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point)) {
                return false;
            }
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
        
        @Override
        public String toString() {
            return String.format("Point(%d, %d)", x, y);
        }
    }
}

