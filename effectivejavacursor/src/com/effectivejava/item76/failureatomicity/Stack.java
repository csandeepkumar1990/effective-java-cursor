package com.effectivejava.item76.failureatomicity;

import java.util.EmptyStackException;

/**
 * Item 76: Strive for failure atomicity.
 * 
 * Failure atomicity: After an object throws an exception,
 * it should still be in a valid state.
 * 
 * Ways to achieve failure atomicity:
 * 1. Make objects immutable
 * 2. Check parameters before modifying state
 * 3. Perform operations on temporary copies
 * 4. Write recovery code
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    /**
     * GOOD: Checks size before modifying state.
     * If exception is thrown, object is still in valid state.
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        // Check before modifying - failure atomicity
        Object result = elements[--size];
        elements[size] = null;  // Eliminate obsolete reference
        return result;
    }
    
    /**
     * BAD: Modifies state before checking.
     * If exception is thrown, object is in invalid state.
     */
    public Object popBad() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null;
        // If exception thrown here, size is wrong!
        return result;
    }
    
    /**
     * GOOD: Performs operation on temporary copy.
     * Original state unchanged if operation fails.
     */
    public void addAll(Object[] c) {
        Object[] temp = new Object[elements.length + c.length];
        System.arraycopy(elements, 0, temp, 0, size);
        System.arraycopy(c, 0, temp, size, c.length);
        // Only update if all operations succeed
        elements = temp;
    }
}

