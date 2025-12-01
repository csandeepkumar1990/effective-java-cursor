package com.effectivejava.item87.customserializedform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Item 87: Consider using a custom serialized form.
 * 
 * Default serialization:
 * - Serializes all non-transient fields
 * - Includes class name and field names
 * - Can be inefficient
 * - Ties you to implementation
 * 
 * Custom serialized form:
 * - More control
 * - Can be more efficient
 * - Better encapsulation
 * - Easier to evolve
 */
public class StringList implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // Transient: Not part of default serialized form
    private transient int size = 0;
    private transient Entry head = null;
    
    /**
     * BAD: Using default serialization.
     * Ties you to implementation.
     */
    // Default serialization would serialize all fields
    
    /**
     * GOOD: Custom serialized form.
     * More control and better encapsulation.
     */
    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(size);
        // Write entries
        for (Entry e = head; e != null; e = e.next) {
            s.writeObject(e.data);
        }
    }
    
    private void readObject(ObjectInputStream s) 
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int numElements = s.readInt();
        // Read entries
        for (int i = 0; i < numElements; i++) {
            add((String) s.readObject());
        }
    }
    
    public void add(String s) {
        // Implementation
    }
    
    private static class Entry {
        String data;
        Entry next;
    }
}

