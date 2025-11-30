package com.effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Stack implementation with a MEMORY LEAK.
 * 
 * Problem: When objects are popped, the stack maintains obsolete references
 * to them. These references prevent garbage collection even though the objects
 * are no longer accessible to the program.
 * 
 * The active portion of the array consists of elements with index < size.
 * Elements with index >= size are obsolete but still referenced.
 */
public class StackWithLeak {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public StackWithLeak() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    /**
     * MEMORY LEAK: Returns the object but doesn't null out the reference.
     * The array still holds a reference to the popped object, preventing
     * garbage collection.
     */
    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size]; // Leak: reference not nulled out
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

