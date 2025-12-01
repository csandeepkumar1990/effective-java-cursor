package com.effectivejava.item4.noninstantiability;

/**
 * Item 4: Enforce noninstantiability with a private constructor.
 * 
 * This class demonstrates how to create a utility class that cannot be instantiated.
 * Utility classes are collections of static methods and static fields.
 * They are not meant to be instantiated - they are just containers for static members.
 * 
 * Examples of utility classes in Java:
 * - java.util.Collections
 * - java.util.Arrays
 * - java.lang.Math
 * 
 * Attempting to instantiate this class will result in a compile-time error
 * (if constructor is private) or a runtime exception (if constructor throws).
 */
public class UtilityClass {
    
    // Suppress default constructor for noninstantiability
    // This prevents the compiler from generating a default public constructor
    private UtilityClass() {
        // This exception is thrown if someone tries to instantiate via reflection
        throw new AssertionError("Cannot instantiate utility class");
    }
    
    // Static utility methods
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static int multiply(int a, int b) {
        return a * b;
    }
    
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    // Static constants
    public static final double PI = Math.PI;
    public static final double E = Math.E;
}

