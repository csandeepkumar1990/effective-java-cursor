package com.effectivejava.item59.knowlibraries;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Item 59: Know and use the libraries.
 * 
 * Don't reinvent the wheel - use the standard library!
 * 
 * Benefits:
 * - Well-tested code
 * - Better performance
 * - Less code to maintain
 * - Leverages expertise of library authors
 * 
 * Key libraries to know:
 * - java.lang
 * - java.util
 * - java.io
 * - java.util.concurrent
 */
public class RandomExample {
    
    /**
     * BAD: Reinventing random number generation.
     * Don't do this - use the library!
     */
    public static int randomBad(int n) {
        // BAD: Poor quality random number
        return Math.abs(new Random().nextInt()) % n;
    }
    
    /**
     * GOOD: Using standard library.
     * Random.nextInt(n) is better quality and handles edge cases.
     */
    public static int randomGood(int n) {
        return new Random().nextInt(n);
    }
    
    /**
     * BETTER: Using ThreadLocalRandom for concurrent code.
     */
    public static int randomBest(int n) {
        return ThreadLocalRandom.current().nextInt(n);
    }
    
    /**
     * Example: Using Collections utilities.
     */
    public static void collectionsExample() {
        java.util.List<String> list = new java.util.ArrayList<>();
        list.add("b");
        list.add("a");
        list.add("c");
        
        // BAD: Writing your own sort
        // ... custom sort implementation ...
        
        // GOOD: Using Collections.sort()
        java.util.Collections.sort(list);
        
        // Or even better: list.sort(null) or list.sort(Comparator.naturalOrder())
        list.sort(java.util.Comparator.naturalOrder());
    }
}

