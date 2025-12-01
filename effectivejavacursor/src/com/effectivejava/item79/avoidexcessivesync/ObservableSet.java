package com.effectivejava.item79.avoidexcessivesync;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Item 79: Avoid excessive synchronization.
 * 
 * PROBLEMS with excessive synchronization:
 * - Deadlocks
 * - Performance degradation
 * - Alien method calls in synchronized blocks
 * 
 * SOLUTIONS:
 * - Minimize work in synchronized blocks
 * - Use concurrent collections
 * - Use CopyOnWriteArrayList for observers
 * - Move alien method calls outside synchronized blocks
 */
public class ObservableSet<E> extends ForwardingSet<E> {
    public ObservableSet(Set<E> set) {
        super(set);
    }
    
    private final List<SetObserver<E>> observers = new ArrayList<>();
    
    /**
     * BAD: Alien method call in synchronized block.
     * Can cause deadlock or performance issues.
     */
    public void addObserverBad(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }
    
    public boolean notifyElementAddedBad(E element) {
        synchronized (observers) {
            for (SetObserver<E> observer : observers) {
                observer.added(this, element);  // BAD: Alien method in sync block!
            }
        }
        return true;
    }
    
    /**
     * GOOD: Move alien method call outside synchronized block.
     */
    public void addObserver(SetObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }
    
    public boolean notifyElementAdded(E element) {
        List<SetObserver<E>> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);  // Snapshot
        }
        // Alien method call outside synchronized block
        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
        return true;
    }
    
    /**
     * BETTER: Use CopyOnWriteArrayList.
     * No synchronization needed for iteration.
     */
    private final List<SetObserver<E>> observersCopyOnWrite = 
        new CopyOnWriteArrayList<>();
    
    public void addObserverCopyOnWrite(SetObserver<E> observer) {
        observersCopyOnWrite.add(observer);  // Thread-safe, no sync needed
    }
    
    public boolean notifyElementAddedCopyOnWrite(E element) {
        for (SetObserver<E> observer : observersCopyOnWrite) {
            observer.added(this, element);  // Safe - CopyOnWriteArrayList
        }
        return true;
    }
    
    @FunctionalInterface
    public interface SetObserver<E> {
        void added(ObservableSet<E> set, E element);
    }
}

/**
 * Forwarding set for composition.
 */
class ForwardingSet<E> implements Set<E> {
    private final Set<E> s;
    
    public ForwardingSet(Set<E> s) {
        this.s = s;
    }
    
    public boolean add(E e) { return s.add(e); }
    public boolean remove(Object o) { return s.remove(o); }
    public int size() { return s.size(); }
    public boolean isEmpty() { return s.isEmpty(); }
    public boolean contains(Object o) { return s.contains(o); }
    public java.util.Iterator<E> iterator() { return s.iterator(); }
    public Object[] toArray() { return s.toArray(); }
    public <T> T[] toArray(T[] a) { return s.toArray(a); }
    public boolean addAll(java.util.Collection<? extends E> c) { return s.addAll(c); }
    public void clear() { s.clear(); }
    public boolean containsAll(java.util.Collection<?> c) { return s.containsAll(c); }
    public boolean removeAll(java.util.Collection<?> c) { return s.removeAll(c); }
    public boolean retainAll(java.util.Collection<?> c) { return s.retainAll(c); }
    public boolean equals(Object o) { return s.equals(o); }
    public int hashCode() { return s.hashCode(); }
    public String toString() { return s.toString(); }
}

