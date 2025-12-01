package com.effectivejava.item76.failureatomicity;

/**
 * Demonstration of Item 76: Strive for failure atomicity.
 */
public class FailureAtomicityDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 76: Strive for Failure Atomicity ===\n");
        
        System.out.println("1. FAILURE ATOMICITY:");
        System.out.println("   After an object throws an exception,");
        System.out.println("   it should still be in a valid state");
        System.out.println();
        
        System.out.println("2. WAYS TO ACHIEVE:");
        System.out.println("   1. Make objects immutable");
        System.out.println("   2. Check parameters before modifying state");
        System.out.println("   3. Perform operations on temporary copies");
        System.out.println("   4. Write recovery code");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   GOOD: Check size before modifying");
        System.out.println("   if (size == 0) throw ...;");
        System.out.println("   Object result = elements[--size];");
        System.out.println("   (Object still valid if exception thrown)");
        System.out.println();
        
        System.out.println("4. BENEFITS:");
        System.out.println("   - Object remains usable after exception");
        System.out.println("   - Easier to recover from errors");
        System.out.println("   - More robust code");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Strive for failure atomicity");
        System.out.println("2. Check parameters before modifying state");
        System.out.println("3. Use temporary copies for complex operations");
        System.out.println("4. Immutable objects are naturally failure-atomic");
    }
}

