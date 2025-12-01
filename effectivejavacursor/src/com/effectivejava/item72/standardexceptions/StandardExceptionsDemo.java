package com.effectivejava.item72.standardexceptions;

/**
 * Demonstration of Item 72: Favor the use of standard exceptions.
 */
public class StandardExceptionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 72: Favor Standard Exceptions ===\n");
        
        System.out.println("1. STANDARD EXCEPTIONS:");
        System.out.println("   - IllegalArgumentException: Parameter value inappropriate");
        System.out.println("   - IllegalStateException: Object state inappropriate");
        System.out.println("   - NullPointerException: Null value where non-null required");
        System.out.println("   - IndexOutOfBoundsException: Index out of range");
        System.out.println("   - ConcurrentModificationException: Concurrent modification");
        System.out.println("   - UnsupportedOperationException: Operation not supported");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Familiar to API users");
        System.out.println("   - Consistent with Java platform");
        System.out.println("   - Less code to maintain");
        System.out.println();
        
        System.out.println("3. EXAMPLES:");
        try {
            StandardExceptions.setValue(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("   IllegalArgumentException: " + e.getMessage());
        }
        
        try {
            StandardExceptions.process(null);
        } catch (NullPointerException e) {
            System.out.println("   NullPointerException: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use standard exceptions when possible");
        System.out.println("2. Familiar to developers");
        System.out.println("3. Consistent with Java platform");
        System.out.println("4. Create custom exceptions only when necessary");
    }
}

