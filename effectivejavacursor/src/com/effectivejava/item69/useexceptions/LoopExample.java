package com.effectivejava.item69.useexceptions;

import java.util.Iterator;

/**
 * Item 69: Use exceptions only for exceptional conditions.
 * 
 * DON'T use exceptions for control flow!
 * 
 * BAD: Using exceptions for normal control flow
 * GOOD: Check conditions before operations
 * 
 * Exceptions are for exceptional conditions, not for:
 * - Normal control flow
 * - Expected conditions
 * - Performance optimization
 */
public class LoopExample {
    
    /**
     * BAD: Using exception for control flow.
     * This is wrong - exceptions are slow!
     */
    public static void badLoop(java.util.List<String> list) {
        int i = 0;
        try {
            while (true) {
                String item = list.get(i++);
                // Process item
            }
        } catch (IndexOutOfBoundsException e) {
            // End of loop - BAD!
        }
    }
    
    /**
     * GOOD: Normal control flow.
     * Check condition before accessing.
     */
    public static void goodLoop(java.util.List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            // Process item
        }
    }
    
    /**
     * BETTER: Enhanced for loop.
     */
    public static void bestLoop(java.util.List<String> list) {
        for (String item : list) {
            // Process item
        }
    }
    
    /**
     * BAD: Using exception for state checking.
     */
    public static void badStateCheck(java.util.List<String> list) {
        try {
            Iterator<String> i = list.iterator();
            while (true) {
                String item = i.next();  // Throws NoSuchElementException
                // Process item
            }
        } catch (java.util.NoSuchElementException e) {
            // End of iteration - BAD!
        }
    }
    
    /**
     * GOOD: Using hasNext() for state checking.
     */
    public static void goodStateCheck(java.util.List<String> list) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            String item = i.next();
            // Process item
        }
    }
}

