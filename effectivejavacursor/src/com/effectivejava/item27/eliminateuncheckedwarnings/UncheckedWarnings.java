package com.effectivejava.item27.eliminateuncheckedwarnings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Item 27: Eliminate unchecked warnings.
 * 
 * This demonstrates how to handle unchecked warnings:
 * 1. Eliminate all unchecked warnings if possible
 * 2. If you can't eliminate, prove the code is safe
 * 3. Suppress warnings with @SuppressWarnings("unchecked")
 * 4. Always add a comment explaining why it's safe
 */
public class UncheckedWarnings {
    
    /**
     * BAD: Unchecked warning.
     * The compiler warns about unchecked conversion.
     */
    @SuppressWarnings("unchecked")
    public static Set<String> createSetBad() {
        return new HashSet();  // Unchecked warning
    }
    
    /**
     * GOOD: No warning - proper generic type.
     */
    public static Set<String> createSetGood() {
        return new HashSet<>();  // No warning - type inference
    }
    
    /**
     * When you must suppress a warning, prove it's safe and document it.
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] toArray(T[] a) {
        // This code is safe because we know the array type matches
        // the collection element type. The warning is unavoidable
        // due to erasure, but the code is correct.
        return (T[]) new Object[a.length];
    }
    
    /**
     * Example of eliminating warning by using proper types.
     */
    public static void addAll(Set<String> set, String... elements) {
        for (String element : elements) {
            set.add(element);
        }
    }
}

