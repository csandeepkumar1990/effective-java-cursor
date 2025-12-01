package com.effectivejava.item26.dontuserawtypes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Demonstration of Item 26: Don't use raw types.
 */
public class DontUseRawTypesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 26: Don't Use Raw Types ===\n");
        
        System.out.println("1. RAW TYPES:");
        System.out.println("   Raw types are generic types used without type parameters.");
        System.out.println("   Example: Collection (instead of Collection<String>)");
        System.out.println("   They exist for backward compatibility only.");
        System.out.println();
        
        System.out.println("2. PROBLEMS WITH RAW TYPES:");
        System.out.println("   - Lose type safety");
        System.out.println("   - Can cause ClassCastException at runtime");
        System.out.println("   - Defeats the purpose of generics");
        System.out.println();
        
        // Example
        Collection<Stamp> stamps = new ArrayList<>();
        stamps.add(new Stamp("Liberty"));
        stamps.add(new Stamp("Eagle"));
        
        System.out.println("3. GOOD: Parameterized Type");
        System.out.println("   Collection<Stamp> stamps = new ArrayList<>();");
        System.out.println("   Type-safe - compiler catches errors");
        System.out.println();
        
        System.out.println("4. UNBOUNDED WILDCARD:");
        System.out.println("   Use Collection<?> when you need to accept any collection");
        System.out.println("   but don't need to add elements");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Never use raw types in new code");
        System.out.println("2. Use parameterized types for type safety");
        System.out.println("3. Use unbounded wildcards (Collection<?>) when appropriate");
        System.out.println("4. Raw types defeat the purpose of generics");
    }
}

