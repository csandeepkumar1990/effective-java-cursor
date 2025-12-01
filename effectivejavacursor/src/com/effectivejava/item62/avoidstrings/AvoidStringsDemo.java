package com.effectivejava.item62.avoidstrings;

/**
 * Demonstration of Item 62: Avoid strings where other types more appropriate.
 */
public class AvoidStringsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 62: Avoid Strings Where Other Types More Appropriate ===\n");
        
        System.out.println("1. DON'T USE STRINGS AS:");
        System.out.println("   - Types (use enums, classes, or interfaces)");
        System.out.println("   - Capability keys (use separate types)");
        System.out.println("   - Aggregate types (use classes)");
        System.out.println();
        
        System.out.println("2. STRINGS ARE POOR SUBSTITUTES FOR:");
        System.out.println("   - Types");
        System.out.println("   - Enumerations");
        System.out.println("   - Aggregate types");
        System.out.println("   - Capabilities");
        System.out.println();
        
        System.out.println("3. EXAMPLE - THREAD LOCAL:");
        System.out.println("   BAD: ThreadLocal with String (no type safety)");
        System.out.println("   GOOD: ThreadLocal<T> (type-safe)");
        System.out.println();
        
        ThreadLocal.GoodThreadLocal<String> threadLocal = new ThreadLocal.GoodThreadLocal<>();
        threadLocal.set("value");
        System.out.println("   threadLocal.get() = " + threadLocal.get());
        System.out.println();
        
        System.out.println("4. EXAMPLE - AGGREGATE TYPE:");
        System.out.println("   BAD: String compoundKey = className + \"#\" + methodName");
        System.out.println("   GOOD: CompoundKey class with proper equals/hashCode");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't use strings as types");
        System.out.println("2. Use proper types for better type safety");
        System.out.println("3. Use classes for aggregate types");
        System.out.println("4. Strings are for text, not for representing other concepts");
    }
}

