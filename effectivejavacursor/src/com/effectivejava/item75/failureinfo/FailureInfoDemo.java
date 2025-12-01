package com.effectivejava.item75.failureinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 75: Include failure-capture information.
 */
public class FailureInfoDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 75: Include Failure-Capture Information ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Exception detail messages should contain:");
        System.out.println("   - Values of all parameters");
        System.out.println("   - Values of all fields that contributed");
        System.out.println("   - Context information");
        System.out.println();
        
        System.out.println("2. EXAMPLE:");
        List<String> list = Arrays.asList("a", "b", "c");
        
        try {
            IndexOutOfBounds.goodExample(list, 5);
        } catch (java.lang.IndexOutOfBoundsException e) {
            System.out.println("   Exception: " + e.getMessage());
            System.out.println("   (Contains index and size - easy to debug!)");
        }
        System.out.println();
        
        System.out.println("3. BAD:");
        System.out.println("   throw new IndexOutOfBoundsException();");
        System.out.println("   (No information - hard to debug)");
        System.out.println();
        
        System.out.println("4. GOOD:");
        System.out.println("   throw new IndexOutOfBoundsException(");
        System.out.println("       String.format(\"Index: %d, Size: %d\", index, size));");
        System.out.println("   (Contains all relevant information)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Include failure information in exception messages");
        System.out.println("2. Include parameter values");
        System.out.println("3. Include field values that contributed");
        System.out.println("4. Makes debugging much easier");
    }
}

