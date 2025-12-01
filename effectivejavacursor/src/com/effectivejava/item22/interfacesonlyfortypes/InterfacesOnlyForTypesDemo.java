package com.effectivejava.item22.interfacesonlyfortypes;

/**
 * Demonstration of Item 22: Use interfaces only to define types.
 */
public class InterfacesOnlyForTypesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 22: Use Interfaces Only to Define Types ===\n");
        
        System.out.println("1. ANTI-PATTERN: Constant Interface");
        System.out.println("   BAD: Using interfaces just to export constants");
        System.out.println("   Problems:");
        System.out.println("   - Pollutes the namespace of implementing classes");
        System.out.println("   - Can cause confusion");
        System.out.println("   - No benefit (constants are already public static final)");
        System.out.println();
        
        System.out.println("2. SOLUTION: Utility Class");
        System.out.println("   GOOD: Use a utility class with private constructor");
        System.out.println("   Example: PhysicalConstantsGood");
        System.out.println("   double value = PhysicalConstantsGood.AVOGADROS_NUMBER;");
        System.out.println();
        
        System.out.println("3. ALTERNATIVE: Enum");
        System.out.println("   For related constants, consider using an enum");
        System.out.println("   Example: Planet enum with mass and radius");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Interfaces should define types, not export constants");
        System.out.println("2. Use utility classes for constants");
        System.out.println("3. Use enums for related constants");
        System.out.println("4. If you must use constants in an interface,");
        System.out.println("   ensure the interface represents a type");
    }
}

