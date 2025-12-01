package com.effectivejava.item24.staticmemberclasses;

import java.util.AbstractSet;
import java.util.Iterator;

/**
 * Item 24: Favor static member classes over nonstatic.
 * 
 * This demonstrates the different types of nested classes:
 * 1. Static member class - preferred
 * 2. Nonstatic member class - use when you need access to enclosing instance
 * 3. Anonymous class - use for small functions
 * 4. Local class - use when you need a named class in a method
 */
public class Calculator {
    
    /**
     * Static member class - PREFERRED.
     * 
     * Use when:
     * - The nested class doesn't need access to the enclosing instance
     * - You want to associate the class with its enclosing class
     * 
     * Advantages:
     * - More efficient (no reference to enclosing instance)
     * - Can be instantiated without enclosing instance
     * - Clearer intent
     */
    public static class Operation {
        private final String name;
        private final double result;
        
        public Operation(String name, double result) {
            this.name = name;
            this.result = result;
        }
        
        public String getName() {
            return name;
        }
        
        public double getResult() {
            return result;
        }
    }
    
    /**
     * Nonstatic member class - use when you need access to enclosing instance.
     * 
     * Use when:
     * - The nested class needs access to the enclosing instance
     * - You're implementing an Adapter pattern
     * 
     * Example: Iterator implementation that needs access to the collection
     */
    public class OperationIterator implements Iterator<Operation> {
        private int index = 0;
        private final Operation[] operations;
        
        public OperationIterator(Operation[] operations) {
            this.operations = operations;
        }
        
        @Override
        public boolean hasNext() {
            return index < operations.length;
        }
        
        @Override
        public Operation next() {
            return operations[index++];
        }
        
        // Can access Calculator.this if needed
        public Calculator getCalculator() {
            return Calculator.this;
        }
    }
    
    /**
     * Anonymous class example.
     * Use for small, one-off implementations.
     */
    public static Operation createOperation(String name, double result) {
        return new Operation(name, result) {
            @Override
            public String toString() {
                return getName() + " = " + getResult();
            }
        };
    }
}

