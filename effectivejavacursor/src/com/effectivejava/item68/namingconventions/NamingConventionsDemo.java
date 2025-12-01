package com.effectivejava.item68.namingconventions;

/**
 * Demonstration of Item 68: Adhere to generally accepted naming conventions.
 */
public class NamingConventionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 68: Adhere to Naming Conventions ===\n");
        
        System.out.println("1. PACKAGES:");
        System.out.println("   - Lowercase, dot-separated");
        System.out.println("   - Example: com.effectivejava.item1");
        System.out.println();
        
        System.out.println("2. CLASSES AND INTERFACES:");
        System.out.println("   - PascalCase (one or more words)");
        System.out.println("   - Example: Thread, FutureTask, HttpServlet");
        System.out.println();
        
        System.out.println("3. METHODS AND FIELDS:");
        System.out.println("   - camelCase");
        System.out.println("   - Example: remove, ensureCapacity");
        System.out.println();
        
        System.out.println("4. CONSTANTS:");
        System.out.println("   - UPPER_SNAKE_CASE");
        System.out.println("   - Example: MIN_VALUE, MAX_VALUE");
        System.out.println();
        
        System.out.println("5. TYPE PARAMETERS:");
        System.out.println("   - Single uppercase letter");
        System.out.println("   - Example: T, E, K, V, X, R");
        System.out.println();
        
        System.out.println("6. BOOLEAN METHODS:");
        System.out.println("   - Use is/has/can prefix");
        System.out.println("   - Example: isEmpty(), hasItems(), canAdd()");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Follow Java naming conventions");
        System.out.println("2. Makes code more readable");
        System.out.println("3. Easier for others to understand");
        System.out.println("4. Consistency is important");
    }
}

