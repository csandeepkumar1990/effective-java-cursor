package com.effectivejava.item74.documentexceptions;

/**
 * Demonstration of Item 74: Document all exceptions thrown by each method.
 */
public class DocumentExceptionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 74: Document All Exceptions ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Document all exceptions thrown by each method");
        System.out.println();
        
        System.out.println("2. DOCUMENT:");
        System.out.println("   - Checked exceptions (in @throws tags)");
        System.out.println("   - Unchecked exceptions that are part of contract");
        System.out.println("   - All exceptions that callers might expect");
        System.out.println();
        
        System.out.println("3. FORMAT:");
        System.out.println("   /**");
        System.out.println("    * @throws IOException if the file cannot be read");
        System.out.println("    * @throws IllegalArgumentException if parameter is invalid");
        System.out.println("    */");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   See MethodDocumentation.readFile() for proper documentation");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Document all exceptions in @throws tags");
        System.out.println("2. Include both checked and important unchecked exceptions");
        System.out.println("3. Describe when each exception is thrown");
        System.out.println("4. Helps callers handle exceptions properly");
    }
}

