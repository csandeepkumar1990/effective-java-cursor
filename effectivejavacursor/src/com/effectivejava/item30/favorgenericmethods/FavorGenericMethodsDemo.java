package com.effectivejava.item30.favorgenericmethods;

import java.util.Set;

/**
 * Demonstration of Item 30: Favor generic methods.
 * 
 * This demo explains:
 * 1. The limitation of the union method (all sets must have same type)
 * 2. The generic singleton factory pattern
 */
public class FavorGenericMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 30: Favor Generic Methods ===\n");
        
        System.out.println("1. GENERIC METHODS:");
        System.out.println("   Methods that declare their own type parameters");
        System.out.println("   Provide type safety and flexibility");
        System.out.println();
        
        // Example 1: Basic union with same types
        Set<String> guys = Set.of("Tom", "Dick", "Harry");
        Set<String> stooges = Set.of("Larry", "Moe", "Curly");
        Set<String> aflCio = GenericMethods.union(guys, stooges);
        
        System.out.println("2. BASIC UNION EXAMPLE:");
        System.out.println("   Set<String> guys = Set.of(\"Tom\", \"Dick\", \"Harry\");");
        System.out.println("   Set<String> stooges = Set.of(\"Larry\", \"Moe\", \"Curly\");");
        System.out.println("   Set<String> union = union(guys, stooges);");
        System.out.println("   Result: " + aflCio);
        System.out.println("   (Works because both sets are Set<String>)");
        System.out.println();
        
        // Example 2: Limitation - different types don't work
        System.out.println("3. LIMITATION OF UNION METHOD:");
        System.out.println("   All three sets (s1, s2, and return value) must have");
        System.out.println("   exactly the same type parameter.");
        System.out.println();
        
        Set<Integer> ints = Set.of(1, 2, 3);
        Set<Double> doubles = Set.of(1.0, 2.0, 3.0);
        
        System.out.println("   Set<Integer> ints = Set.of(1, 2, 3);");
        System.out.println("   Set<Double> doubles = Set.of(1.0, 2.0, 3.0);");
        System.out.println("   Set<Number> numbers = union(ints, doubles);");
        System.out.println("   // WON'T COMPILE! Types don't match exactly");
        System.out.println();
        
        // Example 3: Flexible version with wildcards
        System.out.println("4. SOLUTION: Bounded Wildcards (Item 31):");
        Set<Number> numbers = GenericMethods.unionFlexible(ints, doubles);
        System.out.println("   Set<Number> numbers = unionFlexible(ints, doubles);");
        System.out.println("   Result: " + numbers);
        System.out.println("   (Works because of bounded wildcards)");
        System.out.println();
        
        // Generic singleton factory pattern
        System.out.println("5. GENERIC SINGLETON FACTORY PATTERN:");
        System.out.println("   Problem: Need an immutable object that works for many types");
        System.out.println("   Solution: Create one instance, return it with appropriate type");
        System.out.println();
        
        System.out.println("   How it works:");
        System.out.println("   1. Create a single instance (typed as Object or raw type)");
        System.out.println("   2. Use static factory method to return it with type parameter");
        System.out.println("   3. Due to erasure, same object works for all types");
        System.out.println();
        
        // Demonstrate identity function
        java.util.function.Function<String, String> stringIdentity = 
            GenericMethods.identityFunction();
        java.util.function.Function<Integer, Integer> intIdentity = 
            GenericMethods.identityFunction();
        
        System.out.println("   Example: Identity Function");
        System.out.println("   Function<String, String> stringId = identityFunction();");
        System.out.println("   Function<Integer, Integer> intId = identityFunction();");
        System.out.println("   stringId.apply(\"hello\"): " + stringIdentity.apply("hello"));
        System.out.println("   intId.apply(42): " + intIdentity.apply(42));
        System.out.println("   (Same instance, different type parameterizations!)");
        System.out.println();
        
        // Demonstrate empty set
        Set<String> emptyStringSet = GenericMethods.emptySet();
        Set<Integer> emptyIntSet = GenericMethods.emptySet();
        
        System.out.println("   Example: Empty Set (like Collections.emptySet())");
        System.out.println("   Set<String> empty1 = emptySet();");
        System.out.println("   Set<Integer> empty2 = emptySet();");
        System.out.println("   empty1.size(): " + emptyStringSet.size());
        System.out.println("   empty2.size(): " + emptyIntSet.size());
        System.out.println("   (Same empty set instance, different types!)");
        System.out.println();
        
        System.out.println("6. WHY THIS WORKS:");
        System.out.println("   - Generics are implemented by erasure (Item 28)");
        System.out.println("   - At runtime, Set<String> and Set<Integer> are both just Set");
        System.out.println("   - The function/object doesn't depend on the type parameter");
        System.out.println("   - So one instance can serve all type parameterizations");
        System.out.println();
        
        System.out.println("7. REAL-WORLD EXAMPLES:");
        System.out.println("   - Collections.reverseOrder() - same Comparator for all types");
        System.out.println("   - Collections.emptySet() - same empty set for all types");
        System.out.println("   - Collections.emptyList() - same empty list for all types");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Union method limitation: all sets must have same type");
        System.out.println("2. Use bounded wildcards (Item 31) for more flexibility");
        System.out.println("3. Generic singleton factory: one instance, many type parameterizations");
        System.out.println("4. Works because of type erasure - same class at runtime");
        System.out.println("5. Used in Java Collections API (emptySet, reverseOrder, etc.)");
    }
}

