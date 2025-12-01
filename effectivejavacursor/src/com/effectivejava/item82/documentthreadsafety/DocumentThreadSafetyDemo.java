package com.effectivejava.item82.documentthreadsafety;

/**
 * Demonstration of Item 82: Document thread-safety.
 */
public class DocumentThreadSafetyDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 82: Document Thread-Safety ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Always document the thread-safety guarantees of a class");
        System.out.println();
        
        System.out.println("2. THREAD-SAFETY LEVELS:");
        System.out.println("   - Immutable: No synchronization needed");
        System.out.println("   - Thread-safe: Safe for concurrent use");
        System.out.println("   - Conditionally thread-safe: Safe with external sync");
        System.out.println("   - Not thread-safe: Must synchronize externally");
        System.out.println("   - Thread-hostile: Not safe even with synchronization");
        System.out.println();
        
        System.out.println("3. DOCUMENTATION:");
        System.out.println("   - State the thread-safety level in class JavaDoc");
        System.out.println("   - Document any required synchronization");
        System.out.println("   - Document any thread-safety violations");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   /**");
        System.out.println("    * This class is thread-safe. All methods are synchronized.");
        System.out.println("    */");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always document thread-safety guarantees");
        System.out.println("2. Use standard terminology");
        System.out.println("3. Document synchronization requirements");
        System.out.println("4. Helps users use the class correctly");
    }
}

