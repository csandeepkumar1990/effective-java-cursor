package com.effectivejava.item37.useenummap;

/**
 * Demonstration of Item 37: Use EnumMap instead of ordinal indexing.
 */
public class UseEnumMapDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 37: Use EnumMap Instead of Ordinal Indexing ===\n");
        
        System.out.println("1. PROBLEM WITH ORDINAL INDEXING:");
        System.out.println("   - Arrays indexed by ordinals are error-prone");
        System.out.println("   - No type safety");
        System.out.println("   - Hard to maintain");
        System.out.println();
        
        System.out.println("2. SOLUTION: EnumMap");
        System.out.println("   - Type-safe");
        System.out.println("   - More efficient than HashMap");
        System.out.println("   - Handles null values correctly");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        Phase.Transition transition = Phase.Transition.from(Phase.SOLID, Phase.LIQUID);
        System.out.println("   Transition from SOLID to LIQUID: " + transition);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use EnumMap instead of arrays indexed by ordinals");
        System.out.println("2. EnumMap is type-safe and efficient");
        System.out.println("3. Better for two-dimensional mappings");
    }
}

