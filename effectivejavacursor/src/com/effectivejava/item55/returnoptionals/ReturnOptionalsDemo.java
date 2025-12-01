package com.effectivejava.item55.returnoptionals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * Demonstration of Item 55: Return optionals judiciously.
 */
public class ReturnOptionalsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 55: Return Optionals Judiciously ===\n");
        
        System.out.println("1. OPTIONAL<T>:");
        System.out.println("   Represents a value that may or may not be present");
        System.out.println();
        
        System.out.println("2. WHEN TO USE:");
        System.out.println("   - Method might not return a value");
        System.out.println("   - Client must check for absence");
        System.out.println("   - More expressive than returning null");
        System.out.println();
        
        System.out.println("3. WHEN NOT TO USE:");
        System.out.println("   - Performance is critical (has overhead)");
        System.out.println("   - For collections (return empty instead)");
        System.out.println("   - For primitive types (use OptionalInt, etc.)");
        System.out.println();
        
        Collection<String> words = Arrays.asList("hello", "world", "java");
        Optional<String> max = Max.max(words);
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   Optional<String> max = Max.max(words);");
        max.ifPresent(word -> System.out.println("   Max word: " + word));
        System.out.println();
        
        System.out.println("5. USAGE PATTERNS:");
        System.out.println("   - ifPresent(Consumer)");
        System.out.println("   - orElse(T)");
        System.out.println("   - orElseGet(Supplier)");
        System.out.println("   - orElseThrow()");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use Optional when method might not return value");
        System.out.println("2. More expressive than null");
        System.out.println("3. Don't use for collections (return empty instead)");
        System.out.println("4. Consider performance implications");
    }
}

