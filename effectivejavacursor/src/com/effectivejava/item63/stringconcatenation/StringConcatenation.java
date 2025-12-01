package com.effectivejava.item63.stringconcatenation;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 63: Beware the performance of string concatenation.
 * 
 * PROBLEM: String concatenation with + creates many intermediate objects.
 * 
 * SOLUTION:
 * - Use StringBuilder for multiple concatenations
 * - Use + for single-line concatenations (compiler optimizes)
 * - Use String.join() or Collectors.joining() for collections
 */
public class StringConcatenation {
    
    /**
     * BAD: String concatenation in loop.
     * Creates O(n^2) intermediate strings!
     */
    public static String statementBad(List<String> items) {
        String result = "";
        for (String item : items) {
            result += item;  // Creates new String object each time!
        }
        return result;
    }
    
    /**
     * GOOD: Using StringBuilder.
     * Much more efficient - O(n) time.
     */
    public static String statementGood(List<String> items) {
        StringBuilder b = new StringBuilder();
        for (String item : items) {
            b.append(item);
        }
        return b.toString();
    }
    
    /**
     * BETTER: Using String.join() for collections.
     * Most concise and efficient.
     */
    public static String statementBest(List<String> items) {
        return String.join("", items);
    }
    
    /**
     * OK: Single-line concatenation.
     * Compiler optimizes this to StringBuilder.
     */
    public static String singleLine(String firstName, String lastName) {
        return firstName + " " + lastName;  // OK - compiler optimizes
    }
    
    /**
     * GOOD: Using StringBuilder with estimated capacity.
     * More efficient when you know approximate size.
     */
    public static String withCapacity(List<String> items) {
        StringBuilder b = new StringBuilder(items.size() * 16);  // Estimate
        for (String item : items) {
            b.append(item);
        }
        return b.toString();
    }
}

