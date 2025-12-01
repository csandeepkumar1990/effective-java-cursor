package com.effectivejava.item41.markerinterfaces;

/**
 * Item 41: Use marker interfaces to define types.
 * 
 * Marker interfaces are interfaces with no methods.
 * They define a type that is implemented by instances of the class.
 * 
 * Examples: Serializable, Cloneable, EventListener
 * 
 * When to use marker interfaces vs marker annotations:
 * - Marker interfaces: When you want to define a type
 * - Marker annotations: When you don't need a type, just metadata
 */
public interface Serializable {
    // Marker interface - no methods
    // Defines a type: "instances of this class can be serialized"
}

/**
 * Example class implementing marker interface.
 */
class MyClass implements Serializable {
    private String data;
    
    public MyClass(String data) {
        this.data = data;
    }
    
    // Can be serialized because it implements Serializable
}

/**
 * Marker annotation alternative.
 * Use when you don't need a type, just metadata.
 */
@interface MarkerAnnotation {
    // Marker annotation - no elements
    // Just metadata, doesn't define a type
}

