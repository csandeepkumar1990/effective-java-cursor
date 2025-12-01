package com.effectivejava.item30.favorgenericmethods;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstration of Item 30: Favor generic methods.
 */
public class FavorGenericMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 30: Favor Generic Methods ===\n");
        
        System.out.println("1. GENERIC METHODS:");
        System.out.println("   Methods that declare their own type parameters");
        System.out.println("   Provide type safety and flexibility");
        System.out.println();
        
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = GenericMethods.union(guys, stooges);
        
        System.out.println("2. EXAMPLE:");
        System.out.println("   Set<String> union = union(guys, stooges);");
        System.out.println("   Result: " + aflCio);
        System.out.println("   (Type-safe - no casting needed)");
        System.out.println();
        
        System.out.println("3. RECURSIVE TYPE BOUNDS:");
        System.out.println("   <T extends Comparable<T>>");
        System.out.println("   Type parameter bounded by type that includes itself");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Make methods generic when they can be parameterized");
        System.out.println("2. Generic methods provide type safety");
        System.out.println("3. Use recursive type bounds when needed");
        System.out.println("4. Prefer generic methods to raw methods");
    }
}

