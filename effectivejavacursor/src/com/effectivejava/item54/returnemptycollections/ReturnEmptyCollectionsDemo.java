package com.effectivejava.item54.returnemptycollections;

import java.util.List;

/**
 * Demonstration of Item 54: Return empty collections or arrays, not nulls.
 */
public class ReturnEmptyCollectionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 54: Return Empty Collections, Not Nulls ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Never return null from a method that returns");
        System.out.println("   a collection or array");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - No need for null checks");
        System.out.println("   - Simpler client code");
        System.out.println("   - No NullPointerException risk");
        System.out.println();
        
        Cheese shop = new Cheese();
        List<String> cheeses = shop.getCheeses();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   List<String> cheeses = shop.getCheeses();");
        System.out.println("   cheeses.size() = " + cheeses.size());
        System.out.println("   (No null check needed - always returns a list)");
        System.out.println();
        
        System.out.println("4. OPTIMIZATION:");
        System.out.println("   Use Collections.emptyList() for empty case");
        System.out.println("   More efficient - reuses singleton");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Never return null from collection/array methods");
        System.out.println("2. Return empty collections/arrays instead");
        System.out.println("3. Use Collections.emptyList() for efficiency");
        System.out.println("4. Simplifies client code");
    }
}

