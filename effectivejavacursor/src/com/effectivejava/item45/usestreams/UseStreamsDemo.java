package com.effectivejava.item45.usestreams;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 45: Use streams judiciously.
 */
public class UseStreamsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 45: Use Streams Judiciously ===\n");
        
        System.out.println("1. WHEN TO USE STREAMS:");
        System.out.println("   - Transforming a sequence of elements");
        System.out.println("   - Filtering elements");
        System.out.println("   - Combining elements");
        System.out.println("   - Accumulating into collections");
        System.out.println("   - Finding elements");
        System.out.println();
        
        System.out.println("2. WHEN NOT TO USE STREAMS:");
        System.out.println("   - You need to read or modify local variables");
        System.out.println("   - You need to return from enclosing method");
        System.out.println("   - You need to handle checked exceptions");
        System.out.println("   - Iterative code is clearer");
        System.out.println();
        
        List<String> words = Arrays.asList("stop", "pots", "tops", "opts", "cat", "act");
        
        System.out.println("3. STREAM PIPELINE EXAMPLE:");
        Anagrams.streamExample();
        System.out.println();
        
        System.out.println("4. ANAGRAMS EXAMPLE:");
        System.out.println("   Iterative approach:");
        Anagrams.printAnagramsIterative(words);
        System.out.println();
        System.out.println("   Stream approach:");
        Anagrams.printAnagramsStream(words);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use streams for transformations and filtering");
        System.out.println("2. Don't use streams when iterative code is clearer");
        System.out.println("3. Streams are functional - avoid side effects");
        System.out.println("4. Choose based on readability and maintainability");
    }
}

