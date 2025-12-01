package com.effectivejava.item42.preferlambdas;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Item 42: Prefer lambdas to anonymous classes.
 * 
 * Lambdas are more concise and readable than anonymous classes.
 * 
 * Use lambdas for:
 * - Functional interfaces (single abstract method)
 * - Small functions
 * 
 * Don't use lambdas for:
 * - Multiple methods needed
 * - Complex logic
 * - When you need this, super, or instance fields
 */
public class AnonymousVsLambda {
    
    /**
     * OLD WAY: Anonymous class.
     * Verbose and hard to read.
     */
    public static void sortOldWay(List<String> words) {
        Collections.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return Integer.compare(s1.length(), s2.length());
            }
        });
    }
    
    /**
     * NEW WAY: Lambda expression.
     * Concise and readable.
     */
    public static void sortNewWay(List<String> words) {
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
    }
    
    /**
     * EVEN BETTER: Method reference.
     * Most concise when applicable.
     */
    public static void sortBestWay(List<String> words) {
        Collections.sort(words, Comparator.comparingInt(String::length));
    }
}

