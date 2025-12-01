package com.effectivejava.item16.useaccessormethods;

/**
 * Item 16: In public classes, use accessor methods, not public fields.
 * 
 * This class demonstrates the problem with public fields and the solution.
 * 
 * BAD: Public fields
 * - Can't change representation without changing API
 * - Can't enforce invariants
 * - Can't add side effects
 * 
 * GOOD: Accessor methods
 * - Can change representation
 * - Can enforce invariants
 * - Can add side effects
 * - Better encapsulation
 */
public class Time {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_HOUR = 60;
    
    private int hour;   // 0-23
    private int minute;  // 0-59
    
    public Time(int hour, int minute) {
        if (hour < 0 || hour >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        if (minute < 0 || minute >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Minute: " + minute);
        }
        this.hour = hour;
        this.minute = minute;
    }
    
    // Accessor methods - GOOD
    public int getHour() {
        return hour;
    }
    
    public int getMinute() {
        return minute;
    }
    
    // Mutator methods with validation - GOOD
    public void setHour(int hour) {
        if (hour < 0 || hour >= HOURS_PER_DAY) {
            throw new IllegalArgumentException("Hour: " + hour);
        }
        this.hour = hour;
    }
    
    public void setMinute(int minute) {
        if (minute < 0 || minute >= MINUTES_PER_HOUR) {
            throw new IllegalArgumentException("Minute: " + minute);
        }
        this.minute = minute;
    }
    
    @Override
    public String toString() {
        return String.format("%02d:%02d", hour, minute);
    }
}

