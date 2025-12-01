package com.effectivejava.item15.minimizeaccessibility;

import java.util.Collection;
import java.util.HashSet;

/**
 * Item 15: Minimize the accessibility of classes and members.
 * 
 * This example demonstrates the problem with inheritance and composition.
 * 
 * PROBLEM: This class tries to count elements added to a HashSet by extending it.
 * However, it's broken because HashSet.addAll() calls add() internally,
 * so elements are counted twice.
 * 
 * SOLUTION: Use composition instead of inheritance (Item 18).
 * 
 * This also demonstrates why making classes final or using composition
 * is important for encapsulation.
 */
public class InstrumentedHashSet<E> extends HashSet<E> {
    private int addCount = 0;
    
    public InstrumentedHashSet() {
    }
    
    public InstrumentedHashSet(int initCap, float loadFactor) {
        super(initCap, loadFactor);
    }
    
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();  // BUG: This counts elements twice!
        return super.addAll(c);  // addAll() calls add() for each element
    }
    
    public int getAddCount() {
        return addCount;
    }
}

