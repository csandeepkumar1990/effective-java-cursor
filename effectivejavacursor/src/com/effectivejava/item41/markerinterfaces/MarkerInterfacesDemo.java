package com.effectivejava.item41.markerinterfaces;

/**
 * Demonstration of Item 41: Use marker interfaces to define types.
 */
public class MarkerInterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 41: Use Marker Interfaces to Define Types ===\n");
        
        System.out.println("1. MARKER INTERFACES:");
        System.out.println("   Interfaces with no methods");
        System.out.println("   Define a type that is implemented by instances");
        System.out.println("   Examples: Serializable, Cloneable, EventListener");
        System.out.println();
        
        System.out.println("2. WHEN TO USE MARKER INTERFACES:");
        System.out.println("   - When you want to define a type");
        System.out.println("   - When you want to catch errors at compile time");
        System.out.println("   - When the marker applies only to classes");
        System.out.println();
        
        System.out.println("3. WHEN TO USE MARKER ANNOTATIONS:");
        System.out.println("   - When you don't need a type, just metadata");
        System.out.println("   - When the marker applies to elements other than classes");
        System.out.println("   - When using annotation-based frameworks");
        System.out.println();
        
        MyClass obj = new MyClass("test");
        System.out.println("4. EXAMPLE:");
        System.out.println("   MyClass implements Serializable");
        System.out.println("   Can check: obj instanceof Serializable");
        System.out.println("   (Type-safe check at compile time)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use marker interfaces to define types");
        System.out.println("2. Use marker annotations for metadata");
        System.out.println("3. Marker interfaces provide compile-time type checking");
        System.out.println("4. Choose based on whether you need a type or just metadata");
    }
}

