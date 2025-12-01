package com.effectivejava.item43.prefermethodreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstration of Item 43: Prefer method references to lambdas.
 */
public class PreferMethodReferencesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 43: Prefer Method References to Lambdas ===\n");
        
        System.out.println("1. TYPES OF METHOD REFERENCES:");
        System.out.println("   1. Static: Integer::parseInt");
        System.out.println("   2. Bound instance: Instant.now()::isAfter");
        System.out.println("   3. Unbound instance: String::toLowerCase");
        System.out.println("   4. Class constructor: TreeMap<K,V>::new");
        System.out.println("   5. Array constructor: int[]::new");
        System.out.println();
        
        Map<String, Integer> map = new HashMap<>();
        MethodReferences.methodRefWay(map, "key");
        System.out.println("2. EXAMPLE:");
        System.out.println("   Lambda: map.merge(key, 1, (count, incr) -> count + incr)");
        System.out.println("   Method ref: map.merge(key, 1, Integer::sum)");
        System.out.println("   (More concise and readable)");
        System.out.println();
        
        System.out.println("3. WHEN TO USE METHOD REFERENCES:");
        System.out.println("   - When method reference is more concise");
        System.out.println("   - When it improves readability");
        System.out.println();
        
        System.out.println("4. WHEN LAMBDA IS BETTER:");
        System.out.println("   - When lambda is more readable");
        System.out.println("   - When you need to pass additional parameters");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer method references to lambdas when more concise");
        System.out.println("2. Method references are often more readable");
        System.out.println("3. Use lambdas when they're clearer");
        System.out.println("4. Choose based on readability");
    }
}

