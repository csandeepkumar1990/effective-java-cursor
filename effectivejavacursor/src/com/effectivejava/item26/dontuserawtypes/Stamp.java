package com.effectivejava.item26.dontuserawtypes;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Item 26: Don't use raw types.
 * 
 * Raw types are generic types used without type parameters.
 * They exist for backward compatibility but should not be used in new code.
 * 
 * PROBLEMS:
 * - Lose type safety
 * - Can cause ClassCastException at runtime
 * - Defeats the purpose of generics
 */
public class Stamp {
    private final String name;
    
    public Stamp(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
    /**
     * BAD: Using raw type.
     * This loses type safety.
     */
    public static void addRawType(Collection stamps, Stamp stamp) {
        stamps.add(stamp);  // No type checking!
        // stamps.add(new Coin());  // Would compile but fail at runtime
    }
    
    /**
     * GOOD: Using parameterized type.
     * This provides type safety.
     */
    public static void addParameterized(Collection<Stamp> stamps, Stamp stamp) {
        stamps.add(stamp);  // Type-safe
        // stamps.add(new Coin());  // Compile error - caught at compile time!
    }
    
    /**
     * If you need to accept any collection, use unbounded wildcard.
     */
    public static int countElements(Collection<?> c) {
        return c.size();
    }
}

