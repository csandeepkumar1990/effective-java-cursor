package com.effectivejava.item4.noninstantiability;

/**
 * Demonstration of Item 4: Enforce noninstantiability with a private constructor.
 * 
 * This demo shows:
 * 1. Why utility classes should not be instantiated
 * 2. How to prevent instantiation with a private constructor
 * 3. What happens when someone tries to instantiate (compile-time vs runtime)
 */
public class NoninstantiabilityDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 4: Enforce Noninstantiability ===\n");
        
        System.out.println("1. UTILITY CLASSES:");
        System.out.println("   Utility classes are collections of static methods and fields.");
        System.out.println("   They are not meant to be instantiated.");
        System.out.println("   Examples: java.util.Collections, java.util.Arrays, java.lang.Math");
        System.out.println();
        
        // Using static methods - correct way
        System.out.println("2. USING UTILITY CLASS (CORRECT):");
        System.out.println("   UtilityClass.add(5, 3) = " + UtilityClass.add(5, 3));
        System.out.println("   UtilityClass.multiply(4, 7) = " + UtilityClass.multiply(4, 7));
        System.out.println("   UtilityClass.PI = " + UtilityClass.PI);
        System.out.println();
        
        // Attempting to instantiate - this would cause compile error
        System.out.println("3. ATTEMPTING TO INSTANTIATE:");
        System.out.println("   // UtilityClass util = new UtilityClass(); // Compile error!");
        System.out.println("   The private constructor prevents instantiation at compile time.");
        System.out.println();
        
        // Reflection attack demonstration
        System.out.println("4. REFLECTION ATTACK PROTECTION:");
        demonstrateReflectionAttack();
        System.out.println();
        
        System.out.println("=== Key Points ===");
        System.out.println("1. Use private constructor to prevent instantiation");
        System.out.println("2. Throw AssertionError in constructor to prevent reflection attacks");
        System.out.println("3. This pattern is used by java.util.Collections, java.util.Arrays");
        System.out.println("4. Never make utility class abstract - it can still be subclassed");
        System.out.println("5. Private constructor with AssertionError is the best approach");
    }
    
    /**
     * Demonstrates that even reflection cannot instantiate the utility class.
     */
    private static void demonstrateReflectionAttack() {
        System.out.println("   Attempting to instantiate via reflection...");
        try {
            java.lang.reflect.Constructor<UtilityClass> constructor = 
                UtilityClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            UtilityClass instance = constructor.newInstance();
            System.out.println("   Reflection attack succeeded: " + instance);
        } catch (Exception e) {
            System.out.println("   Reflection attack blocked: " + e.getClass().getSimpleName());
            System.out.println("   Message: " + e.getMessage());
            System.out.println("   The AssertionError in the constructor prevents instantiation");
        }
    }
}

