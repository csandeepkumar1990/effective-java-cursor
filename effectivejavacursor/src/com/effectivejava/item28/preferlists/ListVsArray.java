package com.effectivejava.item28.preferlists;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 28: Prefer lists to arrays.
 * 
 * Key differences:
 * - Arrays are covariant (String[] is a subtype of Object[])
 * - Generics are invariant (List<String> is NOT a subtype of List<Object>)
 * - Arrays are reified (know their type at runtime)
 * - Generics are erased (type information removed at runtime)
 * 
 * PROBLEM: Arrays and generics don't mix well.
 * SOLUTION: Use lists instead of arrays.
 */
public class ListVsArray {
    
    /**
     * BAD: This fails at runtime!
     * Arrays are covariant, so this compiles but throws ArrayStoreException.
     */
    public static void arrayProblem() {
        Object[] objectArray = new Long[1];
        objectArray[0] = "I don't fit in";  // Throws ArrayStoreException!
    }
    
    /**
     * GOOD: This won't compile - type safety!
     * Lists are invariant, so this is caught at compile time.
     */
    public static void listSolution() {
        // List<Object> objectList = new ArrayList<Long>();  // Won't compile!
        List<Long> longList = new ArrayList<>();
        // objectList.add("I don't fit in");  // Compile error - caught early!
    }
    
    /**
     * PROBLEM: You can't create arrays of generic types.
     * This won't compile: new List<String>[]
     */
    // public static void createGenericArray() {
    //     List<String>[] stringLists = new List<String>[1];  // Won't compile!
    // }
    
    /**
     * SOLUTION: Use lists instead of arrays.
     */
    public static void useList() {
        List<List<String>> listOfLists = new ArrayList<>();
        listOfLists.add(new ArrayList<>());
        // Type-safe and works!
    }
}

