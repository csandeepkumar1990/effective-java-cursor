package com.effectivejava.item29.favorgenerictypes;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Item 29: Favor generic types.
 * 
 * This demonstrates converting a raw type to a generic type.
 * 
 * Steps:
 * 1. Add type parameters to the class declaration
 * 2. Replace Object with the type parameter
 * 3. Fix any compilation errors
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    /**
     * The elements array will contain only E instances from push(E).
     * This is sufficient to ensure type safety, but the runtime
     * type of the array won't be E[]; it will always be Object[]!
     */
    @SuppressWarnings("unchecked")
    public Stack() {
        // Can't create array of generic type, so cast is necessary
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E result = elements[--size];
        elements[size] = null;  // Eliminate obsolete reference
        return result;
    }
    
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

