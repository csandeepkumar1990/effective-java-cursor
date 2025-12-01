package com.effectivejava.item19.designforinheritance;

import java.util.Collection;

/**
 * Item 19: Design and document for inheritance or else prohibit it.
 * 
 * This class demonstrates proper design for inheritance:
 * 1. Document self-use patterns
 * 2. Provide hook methods for subclasses
 * 3. Never invoke overridable methods from constructors
 * 4. Consider making the class final or providing factory methods
 */
public abstract class InstrumentedHashSetGood<E> {
    private int addCount = 0;
    
    public InstrumentedHashSetGood() {
    }
    
    /**
     * Adds an element to this collection.
     * 
     * This method may be overridden by subclasses. If overridden,
     * subclasses should call super.add(e) to maintain the addCount.
     * 
     * @implSpec
     * This implementation increments addCount and calls the abstract
     * doAdd method, which must be implemented by subclasses.
     * 
     * @param e element to be added
     * @return true if the element was added
     */
    public boolean add(E e) {
        addCount++;
        return doAdd(e);
    }
    
    /**
     * Hook method for subclasses to implement the actual add operation.
     * This separates the instrumentation from the actual implementation.
     */
    protected abstract boolean doAdd(E e);
    
    /**
     * Adds all elements from the specified collection.
     * 
     * @implSpec
     * This implementation iterates over the collection and calls add()
     * for each element. Subclasses should be aware that add() increments
     * addCount, so addCount will be correct.
     * 
     * @param c collection containing elements to be added
     * @return true if this collection changed as a result of the call
     */
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            if (add(e)) {  // Calls add(), which increments addCount
                modified = true;
            }
        }
        return modified;
    }
    
    public int getAddCount() {
        return addCount;
    }
}

