package com.effectivejava.item28.preferlists;

/**
 * Demonstration of Item 28: Prefer lists to arrays.
 */
public class PreferListsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 28: Prefer Lists to Arrays ===\n");
        
        System.out.println("1. KEY DIFFERENCES:");
        System.out.println("   Arrays:");
        System.out.println("   - Covariant (String[] is subtype of Object[])");
        System.out.println("   - Reified (know type at runtime)");
        System.out.println("   - Fail at runtime");
        System.out.println();
        System.out.println("   Generics (Lists):");
        System.out.println("   - Invariant (List<String> is NOT subtype of List<Object>)");
        System.out.println("   - Erased (type info removed at runtime)");
        System.out.println("   - Fail at compile time");
        System.out.println();
        
        System.out.println("2. PROBLEM: Arrays and generics don't mix");
        System.out.println("   - Can't create arrays of generic types");
        System.out.println("   - Arrays are covariant, generics are invariant");
        System.out.println();
        
        System.out.println("3. SOLUTION: Use lists");
        System.out.println("   - Type-safe at compile time");
        System.out.println("   - More flexible");
        System.out.println("   - Better API");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer lists to arrays when using generics");
        System.out.println("2. Arrays and generics don't mix well");
        System.out.println("3. Lists provide compile-time type safety");
        System.out.println("4. Use arrays only when necessary (performance, etc.)");
    }
}

