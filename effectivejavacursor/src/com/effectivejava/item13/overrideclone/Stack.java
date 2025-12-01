package com.effectivejava.item13.overrideclone;

import java.util.Arrays;

/**
 * Item 13: Override clone judiciously.
 * 
 * This class demonstrates proper clone() implementation.
 * 
 * The Cloneable interface is problematic:
 * - It's a marker interface with no methods
 * - It changes the behavior of Object.clone()
 * - clone() is protected, so you can't call it without implementing Cloneable
 * - The contract is weak
 * 
 * Better alternatives:
 * - Copy constructor: new Stack(stack)
 * - Copy factory: Stack.newInstance(stack)
 * - Builder pattern
 * 
 * If you must implement clone():
 * 1. Implement Cloneable
 * 2. Override clone() with public access
 * 3. Call super.clone()
 * 4. Fix any fields that need fixing
 * 5. Handle CloneNotSupportedException
 */
public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }
    
    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }
    
    public Object pop() {
        if (size == 0) {
            throw new IllegalStateException("Stack is empty");
        }
        Object result = elements[--size];
        elements[size] = null;  // Eliminate obsolete reference
        return result;
    }
    
    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
    
    /**
     * GOOD: Proper clone() implementation.
     * Note: This is shown for illustration. Copy constructor is preferred.
     */
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            result.elements = elements.clone();  // Clone the array
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();  // Can't happen
        }
    }
    
    /**
     * PREFERRED: Copy constructor.
     * This is better than clone() because:
     * - No need to implement Cloneable
     * - No exception handling
     * - More flexible (can take interface type)
     */
    public Stack(Stack stack) {
        this.elements = stack.elements.clone();
        this.size = stack.size;
    }
    
    /**
     * PREFERRED: Copy factory.
     * Another good alternative to clone().
     */
    public static Stack newInstance(Stack stack) {
        return new Stack(stack);
    }
    
    @Override
    public String toString() {
        return "Stack[size=" + size + ", capacity=" + elements.length + "]";
    }
}

