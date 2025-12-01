package com.effectivejava.item22.interfacesonlyfortypes;

/**
 * Item 22: Use interfaces only to define types.
 * 
 * BAD: Constant interface anti-pattern.
 * 
 * This is an anti-pattern - interfaces should not be used just to export constants.
 * Problems:
 * - Pollutes the namespace of implementing classes
 * - Can cause confusion (are these part of the class's API?)
 * - No benefit (constants are implicitly public static final)
 * 
 * SOLUTION: Use a utility class or enum instead.
 */
public interface PhysicalConstants {
    // BAD: Interface used only for constants
    double AVOGADROS_NUMBER = 6.022_140_857e23;
    double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    double ELECTRON_MASS = 9.109_383_56e-31;
}

/**
 * GOOD: Utility class for constants.
 * This is the preferred approach.
 */
class PhysicalConstantsGood {
    private PhysicalConstantsGood() {
        // Prevents instantiation
    }
    
    public static final double AVOGADROS_NUMBER = 6.022_140_857e23;
    public static final double BOLTZMANN_CONSTANT = 1.380_648_52e-23;
    public static final double ELECTRON_MASS = 9.109_383_56e-31;
}

