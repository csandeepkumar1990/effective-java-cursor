package com.effectivejava.item46.sideeffectfree;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Demonstration of Item 46: Prefer side-effect-free functions in streams.
 */
public class SideEffectFreeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 46: Prefer Side-Effect-Free Functions ===\n");
        
        System.out.println("1. PRINCIPLE:");
        System.out.println("   Streams should be functional - avoid side effects");
        System.out.println();
        
        System.out.println("2. BAD: Using forEach with side effects");
        System.out.println("   words.forEach(word -> freq.merge(...));");
        System.out.println("   Problem: Modifies external state");
        System.out.println();
        
        System.out.println("3. GOOD: Using collectors");
        System.out.println("   words.collect(groupingBy(...));");
        System.out.println("   Benefit: Side-effect-free, functional");
        System.out.println();
        
        List<String> words = Arrays.asList("hello", "world", "hello", "java", "world", "hello");
        
        System.out.println("4. EXAMPLE:");
        Map<String, Long> freq = Freq.goodWay(words.stream());
        System.out.println("   Word frequencies: " + freq);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Avoid side effects in streams");
        System.out.println("2. Use collectors to accumulate results");
        System.out.println("3. forEach should be used only for reporting");
        System.out.println("4. Functional programming is easier to reason about");
    }
}

