package com.effectivejava.item20.preferinterfaces;

import java.util.Map;

/**
 * Skeletal implementation (Item 20).
 * 
 * Provides a framework for implementing the Map.Entry interface.
 * This is an abstract class that implements the interface and provides
 * a skeletal implementation that subclasses can extend.
 * 
 * Use skeletal implementations when:
 * - You want to provide default implementations
 * - You want to share code between implementations
 * - The interface has many methods but only a few need to be implemented
 */
public abstract class AbstractMapEntry<K, V> implements Map.Entry<K, V> {
    
    // Primitive methods - must be implemented by subclasses
    @Override
    public abstract K getKey();
    
    @Override
    public abstract V getValue();
    
    // Entries in modifiable maps must override this method
    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException();
    }
    
    // Implements the general contract of Map.Entry.equals
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Map.Entry)) return false;
        Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
        return Objects.equals(e.getKey(), getKey()) &&
               Objects.equals(e.getValue(), getValue());
    }
    
    // Implements the general contract of Map.Entry.hashCode
    @Override
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }
    
    @Override
    public String toString() {
        return getKey() + "=" + getValue();
    }
    
    // Helper class for Objects methods (simplified)
    private static class Objects {
        static boolean equals(Object a, Object b) {
            return (a == b) || (a != null && a.equals(b));
        }
        
        static int hashCode(Object o) {
            return o != null ? o.hashCode() : 0;
        }
    }
}

