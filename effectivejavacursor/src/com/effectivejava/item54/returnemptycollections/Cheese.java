package com.effectivejava.item54.returnemptycollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Item 54: Return empty collections or arrays, not nulls.
 * 
 * Never return null from a method that returns a collection or array.
 * Return an empty collection/array instead.
 * 
 * Benefits:
 * - No need for null checks
 * - Simpler client code
 * - No NullPointerException risk
 */
public class Cheese {
    private final List<String> cheesesInStock = new ArrayList<>();
    
    /**
     * BAD: Returns null.
     * Forces clients to check for null.
     */
    public List<String> getCheesesBad() {
        return cheesesInStock.isEmpty() ? null : new ArrayList<>(cheesesInStock);
    }
    
    /**
     * GOOD: Returns empty collection.
     * No null check needed.
     */
    public List<String> getCheeses() {
        return new ArrayList<>(cheesesInStock);
    }
    
    /**
     * BETTER: Returns immutable empty collection for empty case.
     * More efficient - reuses singleton.
     */
    public List<String> getCheesesOptimized() {
        return cheesesInStock.isEmpty() 
            ? Collections.emptyList() 
            : new ArrayList<>(cheesesInStock);
    }
    
    /**
     * For arrays, return zero-length array.
     */
    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];
    
    public Cheese[] getCheesesArray() {
        return cheesesInStock.isEmpty() 
            ? EMPTY_CHEESE_ARRAY 
            : cheesesInStock.toArray(new Cheese[0]);
    }
}

