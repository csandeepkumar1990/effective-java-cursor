package com.effectivejava.item17.minimizemutability;

/**
 * Demonstration of Item 17: Minimize mutability.
 */
public class ImmutableDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 17: Minimize Mutability ===\n");
        
        System.out.println("1. RULES FOR IMMUTABLE CLASSES:");
        System.out.println("   1. Don't provide methods that modify the object's state");
        System.out.println("   2. Ensure the class can't be extended (final)");
        System.out.println("   3. Make all fields final");
        System.out.println("   4. Make all fields private");
        System.out.println("   5. Ensure exclusive access to any mutable components");
        System.out.println();
        
        System.out.println("2. BENEFITS OF IMMUTABILITY:");
        System.out.println("   - Thread-safe (no synchronization needed)");
        System.out.println("   - Can be shared freely");
        System.out.println("   - No defensive copies needed");
        System.out.println("   - Can cache hash codes");
        System.out.println("   - Make great map keys and set elements");
        System.out.println();
        
        // Functional approach
        System.out.println("3. FUNCTIONAL APPROACH:");
        Complex a = new Complex(1, 2);
        Complex b = new Complex(3, 4);
        
        System.out.println("   a = " + a);
        System.out.println("   b = " + b);
        
        Complex sum = a.plus(b);
        System.out.println("   a.plus(b) = " + sum);
        System.out.println("   a is unchanged: " + a);
        System.out.println("   (Returns new instance instead of modifying)");
        System.out.println();
        
        // Static constants
        System.out.println("4. STATIC CONSTANTS:");
        System.out.println("   Complex.ZERO = " + Complex.ZERO);
        System.out.println("   Complex.ONE = " + Complex.ONE);
        System.out.println("   Complex.I = " + Complex.I);
        System.out.println("   (Can be shared freely - no need to create new instances)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Make classes immutable unless there's a good reason not to");
        System.out.println("2. Follow the five rules for immutability");
        System.out.println("3. Use functional approach: return new instances");
        System.out.println("4. Provide static factory methods for common values");
        System.out.println("5. If mutability is needed, make it explicit");
    }
}

