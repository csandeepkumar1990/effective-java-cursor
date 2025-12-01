package com.effectivejava.item42.preferlambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 42: Prefer lambdas to anonymous classes.
 */
public class PreferLambdasDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 42: Prefer Lambdas to Anonymous Classes ===\n");
        
        System.out.println("1. ADVANTAGES OF LAMBDAS:");
        System.out.println("   - More concise");
        System.out.println("   - More readable");
        System.out.println("   - Better performance (no class creation)");
        System.out.println();
        
        List<String> words = Arrays.asList("hello", "world", "java", "effective");
        
        System.out.println("2. EXAMPLE:");
        System.out.println("   Old way: Anonymous class (verbose)");
        System.out.println("   New way: Lambda (concise)");
        System.out.println("   Best way: Method reference (most concise)");
        System.out.println();
        
        System.out.println("3. WHEN TO USE LAMBDAS:");
        System.out.println("   - Functional interfaces (single abstract method)");
        System.out.println("   - Small functions");
        System.out.println();
        
        System.out.println("4. WHEN NOT TO USE LAMBDAS:");
        System.out.println("   - Multiple methods needed");
        System.out.println("   - Complex logic");
        System.out.println("   - When you need this, super, or instance fields");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer lambdas to anonymous classes");
        System.out.println("2. Lambdas are more concise and readable");
        System.out.println("3. Use method references when possible");
        System.out.println("4. Don't overuse - keep lambdas small and simple");
    }
}

