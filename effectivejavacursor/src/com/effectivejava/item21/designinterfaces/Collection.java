package com.effectivejava.item21.designinterfaces;

/**
 * Item 21: Design interfaces for posterity.
 * 
 * This demonstrates the problem with adding methods to existing interfaces.
 * 
 * PROBLEM: If you add a method to an interface, all existing implementations
 * must be updated or they will break.
 * 
 * SOLUTION: Use default methods (Java 8+) or provide skeletal implementations.
 */
public interface Collection<E> {
    // Original methods
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    
    /**
     * Default method added in Java 8.
     * This allows adding methods to interfaces without breaking existing implementations.
     * 
     * @implSpec
     * The default implementation iterates over the collection and removes
     * elements that match the predicate.
     * 
     * @param filter the predicate to apply
     * @return true if any elements were removed
     */
    default boolean removeIf(java.util.function.Predicate<? super E> filter) {
        // Default implementation - can be overridden for efficiency
        boolean removed = false;
        java.util.Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (filter.test(it.next())) {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }
    
    java.util.Iterator<E> iterator();
}

