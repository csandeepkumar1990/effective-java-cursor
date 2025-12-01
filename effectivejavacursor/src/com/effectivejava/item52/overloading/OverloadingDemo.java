package com.effectivejava.item52.overloading;

import java.util.*;

/**
 * Demonstration of Item 52: Use overloading judiciously.
 */
public class OverloadingDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 52: Use Overloading Judiciously ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   Overloading is resolved at compile time");
        System.out.println("   Based on static types, not runtime types");
        System.out.println();
        
        System.out.println("2. EXAMPLE:");
        CollectionClassifier.demonstrateProblem();
        System.out.println("   (All print 'Unknown Collection' - not what we want!)");
        System.out.println();
        
        System.out.println("3. RULE:");
        System.out.println("   Never export two overloadings with the same number of parameters");
        System.out.println("   Use different method names instead");
        System.out.println();
        
        System.out.println("4. SOLUTION:");
        System.out.println("   - Use different method names");
        System.out.println("   - Use instanceof for runtime type checking");
        System.out.println("   - Use varargs carefully");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Overloading is resolved at compile time");
        System.out.println("2. Never export overloadings with same parameter count");
        System.out.println("3. Use different method names instead");
        System.out.println("4. Use instanceof for runtime type checking");
    }
}

