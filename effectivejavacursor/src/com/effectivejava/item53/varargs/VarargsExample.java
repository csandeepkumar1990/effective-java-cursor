package com.effectivejava.item53.varargs;

/**
 * Item 53: Use varargs judiciously.
 * 
 * Varargs are convenient but have performance implications.
 * 
 * Use varargs when:
 * - You truly need a method with a variable number of arguments
 * - The method is called infrequently
 * 
 * Don't use varargs when:
 * - Performance is critical
 * - Most calls have 0-3 arguments
 * - Use overloading for common cases
 */
public class VarargsExample {
    
    /**
     * BAD: Varargs for every call.
     * Creates array on every call, even with 0 arguments.
     */
    public static int sumBad(int... args) {
        int sum = 0;
        for (int arg : args) {
            sum += arg;
        }
        return sum;
    }
    
    /**
     * GOOD: Overload for common cases, varargs for rest.
     * Avoids array creation for common cases.
     */
    public static int sum() {
        return 0;
    }
    
    public static int sum(int a) {
        return a;
    }
    
    public static int sum(int a, int b) {
        return a + b;
    }
    
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }
    
    public static int sum(int a, int b, int c, int... rest) {
        int sum = a + b + c;
        for (int arg : rest) {
            sum += arg;
        }
        return sum;
    }
    
    /**
     * GOOD: Varargs when truly needed.
     */
    public static String format(String pattern, Object... args) {
        return String.format(pattern, args);
    }
}

