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
     * 
     * LIMITATION: All three sets (s1, s2, and return value) must have
     * exactly the same type parameter E. This means you cannot do:
     *   Set<Integer> ints = Set.of(1, 2, 3);
     *   Set<Double> doubles = Set.of(1.0, 2.0, 3.0);
     *   Set<Number> numbers = union(ints, doubles);  // Won't compile!
     * 
     * To make it more flexible, use bounded wildcard types (Item 31):
     *   public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2)
     */
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
    
    /**
     * MORE FLEXIBLE: Using bounded wildcards (Item 31).
     * This allows union of Set<Integer> and Set<Double> into Set<Number>.
     */
    public static <E> Set<E> unionFlexible(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }
    
    /**
     * GENERIC SINGLETON FACTORY PATTERN
     * 
     * Problem: You need an immutable object that works for many different types.
     * Because generics are implemented by erasure (Item 28), you can use a single
     * object for all required type parameterizations.
     * 
     * Solution: Create one instance and use a static factory method to return it
     * with the appropriate type parameterization.
     * 
     * This pattern is used for:
     * - Function objects: Collections.reverseOrder()
     * - Collections: Collections.emptySet(), Collections.emptyList()
     * - Comparators: Collections.reverseOrder()
     * 
     * Example from Java: Collections.reverseOrder() returns the same Comparator
     * instance, but typed as Comparator<T> for any T.
     */
    
    /**
     * Step 1: Create a single immutable instance.
     * This is the actual object that will be reused for all types.
     * It's typed as Function<Object, Object> because of erasure.
     */
    private static final java.util.function.Function<Object, Object> IDENTITY_FUNCTION = 
        new java.util.function.Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return o;  // Identity function: returns input unchanged
            }
        };
    
    /**
     * Step 2: Static factory method that returns the same instance,
     * but with the appropriate type parameterization.
     * 
     * This method casts the Function<Object, Object> to Function<T, T>
     * for any type T. This is safe because:
     * 1. The function doesn't depend on the type parameter
     * 2. Due to erasure, Function<String, String> and Function<Integer, Integer>
     *    are the same class at runtime
     * 3. The function is truly generic - it works the same for all types
     * 
     * @param <T> the type parameter
     * @return the same identity function, but typed as Function<T, T>
     */
    @SuppressWarnings("unchecked")
    public static <T> java.util.function.Function<T, T> identityFunction() {
        // Cast is safe because of erasure and the function's true genericity
        return (java.util.function.Function<T, T>) IDENTITY_FUNCTION;
    }
    
    /**
     * Another example: Empty set singleton.
     * Collections.emptySet() uses this pattern.
     */
    private static final Set<?> EMPTY_SET = new HashSet<>();
    
    @SuppressWarnings("unchecked")
    public static <T> Set<T> emptySet() {
        // Returns the same empty set, but typed as Set<T> for any T
        return (Set<T>) EMPTY_SET;
    }
    
    /**
     * Example: Reverse order comparator singleton.
     * Similar to Collections.reverseOrder().
     */
    @SuppressWarnings("unchecked")
    private static final java.util.Comparator<Object> REVERSE_ORDER = 
        (a, b) -> ((Comparable<Object>) b).compareTo(a);
    
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> java.util.Comparator<T> reverseOrder() {
        // Returns the same comparator, but typed as Comparator<T>
        return (java.util.Comparator<T>) REVERSE_ORDER;
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

