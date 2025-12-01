package com.effectivejava.item61.preferprimitives;

import java.util.Comparator;

/**
 * Item 61: Prefer primitive types to boxed primitives.
 * 
 * PROBLEMS with boxed primitives:
 * - Performance overhead
 * - NullPointerException risk
 * - Identity vs equality confusion
 * - Autoboxing can hide performance problems
 * 
 * Use primitives when:
 * - Performance matters
 * - Null values don't make sense
 * - Default values are acceptable
 * 
 * Use boxed primitives when:
 * - Must be used in collections (generics require objects)
 * - Null values are meaningful
 * - As type parameters
 */
public class Unbelievable {
    
    /**
     * BAD: Using boxed primitive.
     * This will throw NullPointerException!
     */
    static Integer i;
    
    public static void badExample() {
        if (i == 42) {  // NullPointerException! i is null
            System.out.println("Unbelievable");
        }
    }
    
    /**
     * GOOD: Using primitive.
     * No null risk.
     */
    static int j;
    
    public static void goodExample() {
        if (j == 42) {  // Works fine, j is 0 (default value)
            System.out.println("Works");
        }
    }
    
    /**
     * BAD: Performance problem with autoboxing.
     */
    public static long sumBad() {
        Long sum = 0L;  // Boxed primitive
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // Autoboxing on every iteration!
        }
        return sum;
    }
    
    /**
     * GOOD: Using primitive.
     * Much faster!
     */
    public static long sumGood() {
        long sum = 0L;  // Primitive
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // No autoboxing
        }
        return sum;
    }
    
    /**
     * When you must use boxed primitives (e.g., in collections).
     */
    public static void useBoxedPrimitives() {
        java.util.List<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(1);  // Autoboxing: int -> Integer
        numbers.add(2);
        numbers.add(3);
        
        int first = numbers.get(0);  // Unboxing: Integer -> int
    }
    
    /**
     * BAD: Identity comparison with boxed primitives.
     */
    public static void identityProblem() {
        Comparator<Integer> naturalOrder = (i, j) -> (i < j) ? -1 : (i == j ? 0 : 1);
        // BUG: == compares identity, not value!
        // Should use i.compareTo(j) or Integer.compare(i, j)
    }
    
    /**
     * GOOD: Value comparison.
     */
    public static void valueComparison() {
        Comparator<Integer> naturalOrder = (iBoxed, jBoxed) -> {
            int i = iBoxed;  // Unbox
            int j = jBoxed;  // Unbox
            return (i < j) ? -1 : (i == j ? 0 : 1);
        };
        // Or better: Comparator.naturalOrder()
    }
}

