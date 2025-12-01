package com.effectivejava.item67.optimize;

/**
 * Item 67: Optimize judiciously.
 * 
 * Rules of optimization:
 * 1. Don't do it
 * 2. (For experts only) Don't do it yet
 * 
 * More computing sins are committed in the name of efficiency
 * (without necessarily achieving it) than for any other single reason.
 * 
 * Principles:
 * - Measure before optimizing
 * - Strive for good algorithms and data structures
 * - Don't sacrifice clarity for small performance gains
 * - Profile to find bottlenecks
 */
public class Optimization {
    
    /**
     * BAD: Premature optimization.
     * Optimizing without measuring.
     */
    public static int sumBad(int[] array) {
        // Trying to optimize without knowing if it's needed
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    
    /**
     * GOOD: Clear code first.
     * Optimize only if profiling shows it's needed.
     */
    public static int sumGood(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }
    
    /**
     * When optimization is appropriate:
     * - After profiling shows a bottleneck
     * - When you have a better algorithm
     * - When performance requirements are not met
     */
    public static void optimizationProcess() {
        System.out.println("1. Write clear, correct code");
        System.out.println("2. Measure performance");
        System.out.println("3. Identify bottlenecks");
        System.out.println("4. Optimize only if needed");
        System.out.println("5. Measure again to verify improvement");
    }
}

