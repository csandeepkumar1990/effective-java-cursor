package com.effectivejava.item83.lazyinitialization;

/**
 * Item 83: Use lazy initialization judiciously.
 * 
 * Lazy initialization: Delaying initialization of a field until it's needed.
 * 
 * Use lazy initialization only when:
 * - Field is expensive to initialize
 * - Field is rarely used
 * - Initialization has side effects
 * 
 * Otherwise, prefer normal initialization.
 */
public class LazyInit {
    
    /**
     * NORMAL INITIALIZATION: Preferred in most cases.
     */
    private final String normal = "initialized";
    
    /**
     * LAZY INITIALIZATION: For expensive fields.
     * 
     * Synchronized for thread-safety.
     */
    private String lazy;
    
    public synchronized String getLazy() {
        if (lazy == null) {
            lazy = expensiveInitialization();
        }
        return lazy;
    }
    
    /**
     * DOUBLE-CHECK IDIOM: For performance-critical code.
     * Reduces synchronization overhead after first initialization.
     */
    private volatile String doubleCheck;
    
    public String getDoubleCheck() {
        String result = doubleCheck;
        if (result == null) {
            synchronized (this) {
                result = doubleCheck;
                if (result == null) {
                    result = expensiveInitialization();
                    doubleCheck = result;
                }
            }
        }
        return result;
    }
    
    /**
     * LAZY INITIALIZATION HOLDER CLASS IDIOM: For static fields.
     * Thread-safe and efficient.
     */
    private static class FieldHolder {
        static final String field = expensiveStaticInitialization();
    }
    
    public static String getField() {
        return FieldHolder.field;  // Initialized on first access
    }
    
    private String expensiveInitialization() {
        // Expensive operation
        return "expensive";
    }
    
    private static String expensiveStaticInitialization() {
        // Expensive static operation
        return "expensive static";
    }
}

