package com.effectivejava.item50.defensivecopies;

import java.util.Date;

/**
 * Item 50: Make defensive copies when needed.
 * 
 * When a class has mutable components, make defensive copies:
 * - In constructors
 * - In accessors that return mutable objects
 * 
 * This prevents clients from corrupting the class's invariants.
 */
public final class Period {
    private final Date start;
    private final Date end;
    
    /**
     * GOOD: Defensive copies in constructor.
     * Client cannot modify the internal Date objects.
     * 
     * Note: We copy first, then validate, to prevent TOCTOU attacks.
     */
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());  // Defensive copy
        this.end = new Date(end.getTime());      // Defensive copy
        
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(this.start + " after " + this.end);
        }
    }
    
    /**
     * GOOD: Returns defensive copy.
     * Client cannot modify internal state.
     */
    public Date start() {
        return new Date(start.getTime());  // Defensive copy
    }
    
    public Date end() {
        return new Date(end.getTime());  // Defensive copy
    }
    
    /**
     * BAD EXAMPLE (commented out for illustration):
     * 
     * // BAD: No defensive copy in constructor
     * // public Period(Date start, Date end) {
     * //     if (start.compareTo(end) > 0) {
     * //         throw new IllegalArgumentException(start + " after " + end);
     * //     }
     * //     this.start = start;  // BAD: Mutable reference
     * //     this.end = end;      // BAD: Mutable reference
     * // }
     * 
     * // BAD: Returns mutable reference
     * // public Date start() {
     * //     return start;  // BAD: Client can modify internal state
     * // }
     */
}

