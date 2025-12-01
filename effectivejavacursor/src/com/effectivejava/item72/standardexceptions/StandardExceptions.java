package com.effectivejava.item72.standardexceptions;

import java.util.Objects;

/**
 * Item 72: Favor the use of standard exceptions.
 * 
 * Standard exceptions to know:
 * - IllegalArgumentException: Parameter value is inappropriate
 * - IllegalStateException: Object state is inappropriate
 * - NullPointerException: Null value where non-null required
 * - IndexOutOfBoundsException: Index out of range
 * - ConcurrentModificationException: Concurrent modification detected
 * - UnsupportedOperationException: Operation not supported
 * 
 * Benefits:
 * - Familiar to API users
 * - Consistent with Java platform
 * - Less code to maintain
 */
public class StandardExceptions {
    
    /**
     * GOOD: Using standard IllegalArgumentException.
     */
    public static void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value cannot be negative: " + value);
        }
    }
    
    /**
     * GOOD: Using standard IllegalStateException.
     */
    private boolean initialized = false;
    
    public void use() {
        if (!initialized) {
            throw new IllegalStateException("Object not initialized");
        }
    }
    
    /**
     * GOOD: Using standard NullPointerException.
     */
    public static void process(String value) {
        Objects.requireNonNull(value, "Value cannot be null");
        // Process value
    }
    
    /**
     * GOOD: Using standard IndexOutOfBoundsException.
     */
    public static void getElement(java.util.List<String> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
    }
    
    /**
     * GOOD: Using standard UnsupportedOperationException.
     */
    public void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
    
    /**
     * BAD: Creating custom exception when standard would work.
     */
    // Don't do this:
    // public static class NegativeValueException extends Exception { }
    // Use IllegalArgumentException instead!
}

