package com.effectivejava.item20.preferinterfaces;

/**
 * Demonstration of Item 20: Prefer interfaces to abstract classes.
 */
public class PreferInterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 20: Prefer Interfaces to Abstract Classes ===\n");
        
        System.out.println("1. ADVANTAGES OF INTERFACES:");
        System.out.println("   - Classes can implement multiple interfaces");
        System.out.println("   - Existing classes can easily implement new interfaces");
        System.out.println("   - Interfaces are ideal for defining mixins");
        System.out.println("   - Interfaces enable nonhierarchical type frameworks");
        System.out.println("   - Interfaces enable safe, powerful functionality enhancements");
        System.out.println();
        
        System.out.println("2. MULTIPLE INTERFACE IMPLEMENTATION:");
        SingerSongwriter artist = new SingerSongwriter();
        System.out.println("   SingerSongwriter implements both Singer and Songwriter");
        artist.sing();
        artist.compose();
        System.out.println("   (Can't do this with abstract classes - single inheritance)");
        System.out.println();
        
        System.out.println("3. SKELETAL IMPLEMENTATIONS:");
        System.out.println("   When you want to provide default implementations,");
        System.out.println("   use an abstract class that implements the interface.");
        System.out.println("   This is called a 'skeletal implementation'.");
        System.out.println("   Example: AbstractMapEntry provides framework for Map.Entry");
        System.out.println();
        
        System.out.println("4. WHEN TO USE ABSTRACT CLASSES:");
        System.out.println("   - To provide skeletal implementations");
        System.out.println("   - To evolve interfaces over time (add default methods)");
        System.out.println("   - When you need to define non-public members");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer interfaces for defining types");
        System.out.println("2. Use abstract classes for skeletal implementations");
        System.out.println("3. Interfaces enable multiple inheritance of type");
        System.out.println("4. Existing classes can easily implement new interfaces");
        System.out.println("5. Consider providing skeletal implementations with interfaces");
    }
}

