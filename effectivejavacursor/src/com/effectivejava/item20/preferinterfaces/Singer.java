package com.effectivejava.item20.preferinterfaces;

/**
 * Item 20: Prefer interfaces to abstract classes.
 * 
 * This demonstrates an interface - the preferred approach for defining types.
 * 
 * Advantages of interfaces:
 * - Classes can implement multiple interfaces
 * - Existing classes can easily implement new interfaces
 * - Interfaces are ideal for defining mixins
 * - Interfaces enable nonhierarchical type frameworks
 * - Interfaces enable safe, powerful functionality enhancements
 */
public interface Singer {
    void sing();
}

