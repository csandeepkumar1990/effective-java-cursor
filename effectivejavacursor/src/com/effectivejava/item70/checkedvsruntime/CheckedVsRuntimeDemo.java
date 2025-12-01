package com.effectivejava.item70.checkedvsruntime;

/**
 * Demonstration of Item 70: Use checked exceptions for recoverable conditions.
 */
public class CheckedVsRuntimeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 70: Checked vs Runtime Exceptions ===\n");
        
        System.out.println("1. CHECKED EXCEPTIONS:");
        System.out.println("   - Must be declared in method signature");
        System.out.println("   - Caller must handle or propagate");
        System.out.println("   - Use for recoverable conditions");
        System.out.println("   - Example: IOException, SQLException");
        System.out.println();
        
        System.out.println("2. RUNTIME EXCEPTIONS:");
        System.out.println("   - Don't need to be declared");
        System.out.println("   - Indicate programming errors");
        System.out.println("   - Use for unrecoverable conditions");
        System.out.println("   - Example: NullPointerException, IllegalArgumentException");
        System.out.println();
        
        System.out.println("3. ERRORS:");
        System.out.println("   - Reserved for JVM use");
        System.out.println("   - Don't catch or throw");
        System.out.println("   - Example: OutOfMemoryError, StackOverflowError");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        try {
            ExceptionTypes.divide(10, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught: " + e.getMessage());
            System.out.println("   (Runtime exception - programming error)");
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use checked exceptions for recoverable conditions");
        System.out.println("2. Use runtime exceptions for programming errors");
        System.out.println("3. Don't declare runtime exceptions in throws clause");
        System.out.println("4. Errors are for JVM use only");
    }
}

