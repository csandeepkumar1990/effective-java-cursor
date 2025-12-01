package com.effectivejava.item58.preferforeach;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 58: Prefer for-each loops to traditional for loops.
 */
public class PreferForEachDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 58: Prefer For-Each Loops ===\n");
        
        System.out.println("1. ADVANTAGES:");
        System.out.println("   - More concise");
        System.out.println("   - Less error-prone");
        System.out.println("   - No performance penalty");
        System.out.println();
        
        System.out.println("2. WHEN TO USE TRADITIONAL FOR LOOPS:");
        System.out.println("   - You need to remove elements");
        System.out.println("   - You need to replace elements");
        System.out.println("   - You need parallel iteration");
        System.out.println("   - You need the index");
        System.out.println();
        
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   Enhanced for loop:");
        for (String fruit : list) {
            System.out.println("     " + fruit);
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer for-each loops to traditional for loops");
        System.out.println("2. More concise and less error-prone");
        System.out.println("3. No performance penalty");
        System.out.println("4. Use traditional loops only when necessary");
    }
}

