package com.effectivejava.item31.useboundedwildcards;

import java.util.Collection;
import java.util.EmptyStackException;

/**
 * Item 31: Use bounded wildcards to increase API flexibility.
 * 
 * PECS: producer-extends, consumer-super
 * - If a parameterized type represents a T producer, use <? extends T>
 * - If a parameterized type represents a T consumer, use <? super T>
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[16];
    }
    
    public void push(E e) {
        // Implementation
    }
    
    public E pop() {
        if (size == 0) throw new EmptyStackException();
        return elements[--size];
    }
    
    /**
     * BAD: Doesn't work with all types.
     * Can't pushAll from Collection<Integer> to Stack<Number>
     */
    public void pushAllBad(Iterable<E> src) {
        for (E e : src) {
            push(e);
        }
    }
    
    /**
     * GOOD: Uses bounded wildcard.
     * Can pushAll from Collection<Integer> to Stack<Number>
     * Producer-extends: src produces E instances
     */
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }
    
    /**
     * BAD: Doesn't work with all types.
     * Can't popAll from Stack<Number> to Collection<Object>
     */
    public void popAllBad(Collection<E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
    
    /**
     * GOOD: Uses bounded wildcard.
     * Can popAll from Stack<Number> to Collection<Object>
     * Consumer-super: dst consumes E instances
     */
    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) {
            dst.add(pop());
        }
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
}

