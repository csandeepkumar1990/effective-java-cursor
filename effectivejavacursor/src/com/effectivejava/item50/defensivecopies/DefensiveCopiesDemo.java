package com.effectivejava.item50.defensivecopies;

import java.util.Date;

/**
 * Demonstration of Item 50: Make defensive copies when needed.
 */
public class DefensiveCopiesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 50: Make Defensive Copies When Needed ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   Mutable objects can be modified by clients");
        System.out.println("   This can corrupt class invariants");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   Make defensive copies:");
        System.out.println("   - In constructors (of mutable parameters)");
        System.out.println("   - In accessors (that return mutable objects)");
        System.out.println();
        
        Date start = new Date();
        Date end = new Date(start.getTime() + 86400000); // +1 day
        
        Period period = new Period(start, end);
        System.out.println("3. EXAMPLE:");
        System.out.println("   Period created with start and end dates");
        System.out.println("   Defensive copies prevent modification");
        System.out.println();
        
        // Try to modify (shouldn't affect period)
        start.setTime(0);
        System.out.println("   Modified original start date");
        System.out.println("   Period's start unchanged: " + period.start());
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Make defensive copies of mutable parameters");
        System.out.println("2. Make defensive copies of mutable return values");
        System.out.println("3. Validate after copying (TOCTOU attack prevention)");
        System.out.println("4. Document that defensive copying is performed");
    }
}

