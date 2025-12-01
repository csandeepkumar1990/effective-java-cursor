package com.effectivejava.item6.avoidunnecessaryobjects;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Example demonstrating when object creation is appropriate vs when to reuse.
 * 
 * This class shows the "baby boom" example from the book.
 */
public class Person {
    private final Date birthDate;
    
    public Person(Date birthDate) {
        this.birthDate = new Date(birthDate.getTime());  // Defensive copy
    }
    
    /**
     * BAD: Creates new Calendar, TimeZone, and Date objects on every call.
     * These objects are expensive to create and are recreated unnecessarily.
     */
    public boolean isBabyBoomerBad() {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomStart = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        Date boomEnd = gmtCal.getTime();
        return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
    }
    
    /**
     * GOOD: Reuses static final Calendar and Date objects.
     * These are created once and reused for all calls.
     */
    private static final Date BOOM_START;
    private static final Date BOOM_END;
    
    static {
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }
    
    public boolean isBabyBoomerGood() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }
}

