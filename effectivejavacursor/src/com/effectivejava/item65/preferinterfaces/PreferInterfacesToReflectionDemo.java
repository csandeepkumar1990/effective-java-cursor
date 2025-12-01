package com.effectivejava.item65.preferinterfaces;

import java.util.Set;

/**
 * Demonstration of Item 65: Prefer interfaces to reflection.
 */
public class PreferInterfacesToReflectionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 65: Prefer Interfaces to Reflection ===\n");
        
        System.out.println("1. REFLECTION DISADVANTAGES:");
        System.out.println("   - Loses compile-time type checking");
        System.out.println("   - Verbose and error-prone");
        System.out.println("   - Performance overhead");
        System.out.println("   - Can't use language features");
        System.out.println();
        
        System.out.println("2. WHEN TO USE REFLECTION:");
        System.out.println("   - You truly need runtime class analysis");
        System.out.println("   - Working with frameworks that require it");
        System.out.println("   - Component-based applications");
        System.out.println();
        
        System.out.println("3. PREFER INTERFACES:");
        System.out.println("   - Type-safe");
        System.out.println("   - Better performance");
        System.out.println("   - Compile-time checking");
        System.out.println("   - Can use language features");
        System.out.println();
        
        Set<String> set = ReflectionExample.createSetGood();
        System.out.println("4. EXAMPLE:");
        System.out.println("   Set<String> set = createSetGood();");
        System.out.println("   (Type-safe, no reflection needed)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer interfaces to reflection");
        System.out.println("2. Reflection loses compile-time safety");
        System.out.println("3. Use reflection only when necessary");
        System.out.println("4. Frameworks may require reflection");
    }
}

