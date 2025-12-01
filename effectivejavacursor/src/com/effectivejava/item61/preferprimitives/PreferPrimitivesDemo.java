package com.effectivejava.item61.preferprimitives;

/**
 * Demonstration of Item 61: Prefer primitive types to boxed primitives.
 */
public class PreferPrimitivesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 61: Prefer Primitive Types ===\n");
        
        System.out.println("1. PROBLEMS WITH BOXED PRIMITIVES:");
        System.out.println("   - Performance overhead");
        System.out.println("   - NullPointerException risk");
        System.out.println("   - Identity vs equality confusion");
        System.out.println("   - Autoboxing can hide performance problems");
        System.out.println();
        
        System.out.println("2. EXAMPLE - NULL RISK:");
        System.out.println("   Integer i;  // null");
        System.out.println("   if (i == 42) { ... }  // NullPointerException!");
        System.out.println();
        
        System.out.println("3. EXAMPLE - PERFORMANCE:");
        System.out.println("   Long sum = 0L;  // Boxed");
        System.out.println("   sum += i;  // Autoboxing on every iteration!");
        System.out.println();
        System.out.println("   long sum = 0L;  // Primitive");
        System.out.println("   sum += i;  // No autoboxing - much faster!");
        System.out.println();
        
        System.out.println("4. WHEN TO USE BOXED PRIMITIVES:");
        System.out.println("   - Must be used in collections (generics)");
        System.out.println("   - Null values are meaningful");
        System.out.println("   - As type parameters");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer primitives to boxed primitives");
        System.out.println("2. Boxed primitives have performance overhead");
        System.out.println("3. Boxed primitives can be null (risk of NPE)");
        System.out.println("4. Use boxed primitives only when necessary");
    }
}

