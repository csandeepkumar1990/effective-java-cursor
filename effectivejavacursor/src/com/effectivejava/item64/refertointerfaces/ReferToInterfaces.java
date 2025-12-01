package com.effectivejava.item64.refertointerfaces;

import java.util.*;

/**
 * Item 64: Refer to objects by their interfaces.
 * 
 * Use interface types for parameters, return values, variables, and fields.
 * 
 * Benefits:
 * - More flexible
 * - Better encapsulation
 * - Easier to change implementations
 * - Follows dependency inversion principle
 * 
 * Exception: Use concrete class when:
 * - You need class-specific methods
 * - The class is a value class (String, BigInteger, etc.)
 */
public class ReferToInterfaces {
    
    /**
     * BAD: Using concrete class.
     * Tightly coupled to ArrayList.
     */
    public static void badExample(ArrayList<String> list) {
        // Can only accept ArrayList, not LinkedList, etc.
    }
    
    /**
     * GOOD: Using interface.
     * Can accept any List implementation.
     */
    public static void goodExample(List<String> list) {
        // Can accept ArrayList, LinkedList, etc.
    }
    
    /**
     * BAD: Variable type is concrete class.
     */
    public static void badVariable() {
        HashSet<String> set = new HashSet<>();  // BAD
    }
    
    /**
     * GOOD: Variable type is interface.
     */
    public static void goodVariable() {
        Set<String> set = new HashSet<>();  // GOOD
    }
    
    /**
     * Exception: When you need class-specific methods.
     */
    public static void exceptionExample() {
        // Need LinkedHashMap-specific methods
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        // Can use LinkedHashMap-specific methods
    }
    
    /**
     * Value classes: Use the class itself.
     */
    public static void valueClassExample() {
        String s = "hello";  // OK - String is a value class
        BigInteger bi = BigInteger.valueOf(42);  // OK - value class
    }
}

