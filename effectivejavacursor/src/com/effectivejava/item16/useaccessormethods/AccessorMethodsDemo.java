package com.effectivejava.item16.useaccessormethods;

/**
 * Demonstration of Item 16: In public classes, use accessor methods.
 */
public class AccessorMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 16: Use Accessor Methods ===\n");
        
        System.out.println("1. PROBLEM WITH PUBLIC FIELDS:");
        System.out.println("   - Can't change representation without changing API");
        System.out.println("   - Can't enforce invariants");
        System.out.println("   - Can't add side effects");
        System.out.println("   - Can't synchronize access");
        System.out.println();
        
        System.out.println("2. SOLUTION: USE ACCESSOR METHODS");
        Time time = new Time(14, 30);
        System.out.println("   Time time = new Time(14, 30);");
        System.out.println("   time.getHour(): " + time.getHour());
        System.out.println("   time.getMinute(): " + time.getMinute());
        System.out.println("   (Can enforce invariants in setters)");
        System.out.println();
        
        System.out.println("3. VALIDATION EXAMPLE:");
        try {
            time.setHour(25);  // Invalid
        } catch (IllegalArgumentException e) {
            System.out.println("   time.setHour(25) throws: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. In public classes, use accessor methods, not public fields");
        System.out.println("2. Accessor methods allow:");
        System.out.println("   - Changing representation");
        System.out.println("   - Enforcing invariants");
        System.out.println("   - Adding side effects");
        System.out.println("   - Synchronizing access");
        System.out.println("3. Public fields are acceptable only for:");
        System.out.println("   - Package-private classes");
        System.out.println("   - Private nested classes");
        System.out.println("   - When fields represent the abstraction directly");
    }
}

