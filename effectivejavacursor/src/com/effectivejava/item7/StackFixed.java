package com.effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack implementation with memory leak FIXED.
 * 
 * Solution: Null out references once they become obsolete.
 * In the pop() method, we null out the array element after retrieving it.
 * 
 * Benefits:
 * 1. Allows garbage collection of popped objects
 * 2. If obsolete reference is dereferenced by mistake, throws NullPointerException
 *    immediately rather than quietly doing the wrong thing
 */
public class StackFixed {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public StackFixed() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    /**
     * FIXED: Nulls out the reference after popping.
     * This eliminates the obsolete reference and allows garbage collection.
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }
    
    /**
     * Ensure space for at least one more element, roughly
     * doubling the capacity each time the array needs to grow.
     */
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

