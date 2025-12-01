package com.effectivejava.item68.namingconventions;

/**
 * Item 68: Adhere to generally accepted naming conventions.
 * 
 * Java naming conventions:
 * 
 * Packages:
 * - Lowercase, dot-separated
 * - Example: com.effectivejava.item1
 * 
 * Classes and Interfaces:
 * - PascalCase (one or more words)
 * - Example: Thread, FutureTask, HttpServlet
 * 
 * Methods and Fields:
 * - camelCase
 * - Example: remove, ensureCapacity
 * 
 * Constants:
 * - UPPER_SNAKE_CASE
 * - Example: MIN_VALUE, MAX_VALUE
 * 
 * Type Parameters:
 * - Single uppercase letter
 * - Example: T, E, K, V, X, R, U, V, T1, T2
 */
public class NamingConventions {
    
    // Constants: UPPER_SNAKE_CASE
    public static final int MAX_SIZE = 100;
    public static final String DEFAULT_NAME = "Unknown";
    
    // Fields: camelCase
    private int count;
    private String name;
    
    // Methods: camelCase
    public void addItem() {
        // Implementation
    }
    
    public int getCount() {
        return count;
    }
    
    // Type parameters: Single uppercase letter
    public static <T> T getFirst(java.util.List<T> list) {
        return list.isEmpty() ? null : list.get(0);
    }
    
    // Boolean methods: is/has/can prefix
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean hasItems() {
        return count > 0;
    }
    
    public boolean canAdd() {
        return count < MAX_SIZE;
    }
}

