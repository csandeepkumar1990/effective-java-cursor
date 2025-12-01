package com.effectivejava.item19.designforinheritance;

import java.util.Collection;
import java.util.Iterator;

/**
 * Example demonstrating proper documentation for inheritance.
 * 
 * This shows how to document self-use patterns using @implSpec.
 */
public abstract class AbstractCollection<E> {
    
    /**
     * Returns an iterator over the elements in this collection.
     * 
     * @implSpec
     * This implementation returns an iterator that calls iterator()
     * on the backing collection. Subclasses should override this method
     * if they provide a more efficient implementation.
     * 
     * @return an iterator over the elements
     */
    public abstract Iterator<E> iterator();
    
    /**
     * Returns the number of elements in this collection.
     * 
     * @implSpec
     * This implementation iterates over the collection using iterator()
     * and counts the elements. Subclasses should override this method
     * if they can provide a more efficient implementation.
     * 
     * @return the number of elements
     */
    public int size() {
        int size = 0;
        for (Iterator<E> it = iterator(); it.hasNext(); it.next()) {
            size++;
        }
        return size;
    }
    
    /**
     * Returns true if this collection contains no elements.
     * 
     * @implSpec
     * This implementation returns size() == 0. Subclasses should be
     * aware that this method calls size(), which may call iterator().
     * 
     * @return true if this collection is empty
     */
    public boolean isEmpty() {
        return size() == 0;  // Self-use: calls size()
    }
}

