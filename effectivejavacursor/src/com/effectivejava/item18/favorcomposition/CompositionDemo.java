package com.effectivejava.item18.favorcomposition;

import java.util.HashSet;
import java.util.Set;

/**
 * Demonstration of Item 18: Favor composition over inheritance.
 */
public class CompositionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 18: Favor Composition Over Inheritance ===\n");
        
        System.out.println("1. PROBLEM WITH INHERITANCE:");
        System.out.println("   - Fragile: breaks when superclass changes");
        System.out.println("   - Tight coupling");
        System.out.println("   - Can't change implementation at runtime");
        System.out.println("   - Violates encapsulation");
        System.out.println("   - Can lead to broken code (see InstrumentedHashSet example)");
        System.out.println();
        
        System.out.println("2. SOLUTION: COMPOSITION");
        System.out.println("   - Wrapper class contains instance of wrapped class");
        System.out.println("   - Forwards method calls to wrapped instance");
        System.out.println("   - Can add functionality without breaking superclass");
        System.out.println("   - More flexible");
        System.out.println();
        
        // Composition example
        System.out.println("3. COMPOSITION EXAMPLE:");
        Set<String> hashSet = new HashSet<>();
        InstrumentedSet<String> instrumentedSet = new InstrumentedSet<>(hashSet);
        
        instrumentedSet.add("Snap");
        instrumentedSet.add("Crackle");
        instrumentedSet.add("Pop");
        
        System.out.println("   instrumentedSet.addAll([\"Snap\", \"Crackle\", \"Pop\"])");
        System.out.println("   Count: " + instrumentedSet.getAddCount());
        System.out.println("   (Works correctly - no double counting!)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Inheritance is appropriate only when:");
        System.out.println("   - There's a true is-a relationship");
        System.out.println("   - The subclass is truly a subtype");
        System.out.println("   - The superclass is designed for extension");
        System.out.println("2. Use composition when:");
        System.out.println("   - You want to add functionality");
        System.out.println("   - There's no true is-a relationship");
        System.out.println("   - You want flexibility");
        System.out.println("3. Composition is more flexible and less fragile");
    }
}

