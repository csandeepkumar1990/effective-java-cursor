package com.effectivejava.item88.defensivereadobject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Item 88: Write readObject methods defensively.
 * 
 * When implementing readObject:
 * 1. Validate all parameters
 * 2. Make defensive copies
 * 3. Check invariants
 * 4. Don't invoke overridable methods
 * 
 * This prevents attacks and ensures object integrity.
 */
public final class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Date start;
    private Date end;
    
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());  // Defensive copy
        this.end = new Date(end.getTime());       // Defensive copy
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }
    
    /**
     * BAD: Default readObject.
     * Vulnerable to attack - no validation!
     */
    // Default readObject would be vulnerable
    
    /**
     * GOOD: Defensive readObject.
     * Validates and makes defensive copies.
     */
    private void readObject(ObjectInputStream s) 
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        
        // Defensive copy and validate
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        
        // Validate invariants
        if (start.compareTo(end) > 0) {
            throw new java.io.InvalidObjectException(start + " after " + end);
        }
    }
    
    public Date start() {
        return new Date(start.getTime());  // Defensive copy
    }
    
    public Date end() {
        return new Date(end.getTime());    // Defensive copy
    }
}

