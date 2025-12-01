package com.effectivejava.item30.favorgenericmethods;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Item 30: Favor generic methods.
 * 
 * Generic methods are methods that declare their own type parameters.
 * They provide type safety and flexibility.
 */
public class GenericMethods {
    
    /**
     * BAD: Raw type method.
     * Loses type safety.
     */
    public static Set unionRaw(Set s1, Set s2) {
        Set result = new HashSet(s1);
        result.addAll(s2);
        return result;
    }
    
    /**
     * GOOD: Generic method.
     * Provides type safety and flexibility.
     */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
    
    /**
     * Generic singleton factory pattern.
     * Returns the same instance for any type, but with appropriate type.
     */
    private static final Object IDENTITY_FUNCTION = new java.util.function.Function<Object, Object>() {
        @Override
        public Object apply(Object o) {
            return o;
        }
    };
    
    @SuppressWarnings("unchecked")
    public static <T> java.util.function.Function<T, T> identityFunction() {
        return (java.util.function.Function<T, T>) IDENTITY_FUNCTION;
    }
    
    /**
     * Recursive type bound example.
     * Type parameter is bounded by a type that includes itself.
     */
    public static <T extends Comparable<T>> T max(Collection<T> c) {
        if (c.isEmpty()) {
            throw new IllegalArgumentException("Empty collection");
        }
        T result = null;
        for (T e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = e;
            }
        }
        return result;
    }
}

