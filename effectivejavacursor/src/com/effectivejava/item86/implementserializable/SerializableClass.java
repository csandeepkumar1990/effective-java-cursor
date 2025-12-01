package com.effectivejava.item86.implementserializable;

import java.io.Serializable;

/**
 * Item 86: Implement Serializable with great caution.
 * 
 * PROBLEMS with Serializable:
 * - Decreases flexibility to change implementation
 * - Increases testing burden
 * - Security risks
 * - Versioning issues
 * - Performance overhead
 * 
 * DECISION FACTORS:
 * - Will this class be part of a framework?
 * - Will clients need to serialize instances?
 * - Is it a value class?
 * - Is it part of a stateful framework?
 */
public class SerializableClass implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int value;
    
    /**
     * Transient fields are not serialized.
     */
    private transient String cache;  // Not serialized
    
    /**
     * Static fields are not serialized.
     */
    private static int count = 0;  // Not serialized
    
    public SerializableClass(String name, int value) {
        this.name = name;
        this.value = value;
    }
    
    /**
     * Custom serialization (if needed).
     */
    private void writeObject(java.io.ObjectOutputStream out) 
            throws java.io.IOException {
        out.defaultWriteObject();
        // Custom serialization logic
    }
    
    /**
     * Custom deserialization (if needed).
     */
    private void readObject(java.io.ObjectInputStream in) 
            throws java.io.IOException, ClassNotFoundException {
        in.defaultReadObject();
        // Custom deserialization logic
        // Validate invariants
    }
}

