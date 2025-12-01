package com.effectivejava.item63.stringconcatenation;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 63: Beware the performance of string concatenation.
 */
public class StringConcatenationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 63: Beware String Concatenation Performance ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   String concatenation with + creates many intermediate objects");
        System.out.println("   In a loop, this is O(n^2) time complexity!");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   - Use StringBuilder for multiple concatenations");
        System.out.println("   - Use + for single-line concatenations (compiler optimizes)");
        System.out.println("   - Use String.join() or Collectors.joining() for collections");
        System.out.println();
        
        List<String> items = Arrays.asList("a", "b", "c", "d", "e");
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: result += item (in loop)");
        System.out.println("   GOOD: StringBuilder.append()");
        System.out.println("   BEST: String.join()");
        System.out.println();
        
        String result = StringConcatenation.statementBest(items);
        System.out.println("   Result: " + result);
        System.out.println();
        
        System.out.println("4. PERFORMANCE:");
        System.out.println("   + in loop: O(n^2) time, O(n^2) space");
        System.out.println("   StringBuilder: O(n) time, O(n) space");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't use + for concatenation in loops");
        System.out.println("2. Use StringBuilder for multiple concatenations");
        System.out.println("3. Use String.join() for collections");
        System.out.println("4. Single-line + is fine (compiler optimizes)");
    }
}

