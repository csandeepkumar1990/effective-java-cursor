package com.effectivejava.item65.preferinterfaces;

import java.lang.reflect.Constructor;
import java.util.Set;

/**
 * Item 65: Prefer interfaces to reflection.
 * 
 * Reflection has disadvantages:
 * - Loses compile-time type checking
 * - Verbose and error-prone
 * - Performance overhead
 * - Can't use language features
 * 
 * Use reflection only when:
 * - You truly need runtime class analysis
 * - Working with frameworks that require it
 * - Component-based applications
 * 
 * Prefer interfaces when possible.
 */
public class ReflectionExample {
    
    /**
     * BAD: Using reflection.
     * Loses compile-time safety.
     */
    @SuppressWarnings("unchecked")
    public static Set<String> createSetBad(String className) {
        try {
            Class<?> cl = Class.forName(className);
            Constructor<?> cons = cl.getDeclaredConstructor();
            return (Set<String>) cons.newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot instantiate " + className, e);
        }
    }
    
    /**
     * GOOD: Using interface and factory.
     * Type-safe and clear.
     */
    public static Set<String> createSetGood() {
        return new java.util.HashSet<>();  // Or use factory method
    }
    
    /**
     * BETTER: Using factory method with interface.
     */
    public static Set<String> createSet() {
        return java.util.Collections.emptySet();  // Factory method
    }
    
    /**
     * When reflection is appropriate: Framework code.
     */
    public static class Framework {
        /**
         * Framework might need reflection to instantiate classes
         * based on configuration. This is acceptable for frameworks.
         */
        @SuppressWarnings("unchecked")
        public static <T> T createInstance(String className, Class<T> type) {
            try {
                Class<?> cl = Class.forName(className);
                if (!type.isAssignableFrom(cl)) {
                    throw new IllegalArgumentException(className + " is not a " + type);
                }
                Constructor<?> cons = cl.getDeclaredConstructor();
                return (T) cons.newInstance();
            } catch (Exception e) {
                throw new IllegalArgumentException("Cannot instantiate " + className, e);
            }
        }
    }
}

