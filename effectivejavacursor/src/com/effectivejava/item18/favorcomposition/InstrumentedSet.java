package com.effectivejava.item18.favorcomposition;

import java.util.Collection;
import java.util.Set;

/**
 * Item 18: Favor composition over inheritance.
 * 
 * This class demonstrates composition - the preferred alternative to inheritance.
 * 
 * PROBLEM WITH INHERITANCE:
 * - Fragile: breaks when superclass changes
 * - Tight coupling
 * - Can't change implementation at runtime
 * - Violates encapsulation
 * 
 * SOLUTION: COMPOSITION
 * - Wrapper class contains instance of wrapped class
 * - Forwards method calls to wrapped instance
 * - Can add functionality without breaking superclass
 * - More flexible
 */
public class InstrumentedSet<E> extends ForwardingSet<E> {
    private int addCount = 0;
    
    public InstrumentedSet(Set<E> s) {
        super(s);
    }
    
    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }
    
    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }
    
    public int getAddCount() {
        return addCount;
    }
}

/**
 * Reusable forwarding class.
 * This implements the Set interface and forwards all calls to the wrapped set.
 */
class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;
    
    public ForwardingSet(Set<E> s) {
        this.s = s;
    }
    
    // Forwarding methods
    public void clear() { s.clear(); }
    public boolean contains(Object o) { return s.contains(o); }
    public boolean isEmpty() { return s.isEmpty(); }
    public int size() { return s.size(); }
    public java.util.Iterator<E> iterator() { return s.iterator(); }
    public boolean add(E e) { return s.add(e); }
    public boolean remove(Object o) { return s.remove(o); }
    public boolean containsAll(Collection<?> c) { return s.containsAll(c); }
    public boolean addAll(Collection<? extends E> c) { return s.addAll(c); }
    public boolean removeAll(Collection<?> c) { return s.removeAll(c); }
    public boolean retainAll(Collection<?> c) { return s.retainAll(c); }
    public Object[] toArray() { return s.toArray(); }
    public <T> T[] toArray(T[] a) { return s.toArray(a); }
    @Override
    public boolean equals(Object o) { return s.equals(o); }
    @Override
    public int hashCode() { return s.hashCode(); }
    @Override
    public String toString() { return s.toString(); }
}

