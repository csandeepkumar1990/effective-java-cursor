package com.effectivejava.item9.trywithresources;

import java.io.*;

/**
 * Demonstration of Item 9: Prefer try-with-resources to try-finally.
 * 
 * This demo shows:
 * 1. Problems with try-finally
 * 2. Benefits of try-with-resources
 * 3. Multiple resources
 * 4. Suppressed exceptions
 */
public class TryWithResourcesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 9: Prefer try-with-resources ===\n");
        
        System.out.println("1. PROBLEMS WITH TRY-FINALLY:");
        System.out.println("   - Verbose and ugly code");
        System.out.println("   - Can suppress exceptions from try block");
        System.out.println("   - Multiple resources require nested try-finally");
        System.out.println("   - Easy to forget to close resources");
        System.out.println();
        
        System.out.println("   Example of try-finally:");
        System.out.println("   InputStream in = new FileInputStream(src);");
        System.out.println("   try {");
        System.out.println("       OutputStream out = new FileOutputStream(dst);");
        System.out.println("       try {");
        System.out.println("           // copy data");
        System.out.println("       } finally {");
        System.out.println("           out.close();  // Can suppress exception");
        System.out.println("       }");
        System.out.println("   } finally {");
        System.out.println("       in.close();  // Can suppress exception");
        System.out.println("   }");
        System.out.println();
        
        System.out.println("2. BENEFITS OF TRY-WITH-RESOURCES:");
        System.out.println("   - Concise and readable");
        System.out.println("   - Automatic resource management");
        System.out.println("   - Suppressed exceptions are preserved");
        System.out.println("   - Works with multiple resources");
        System.out.println("   - Less error-prone");
        System.out.println();
        
        System.out.println("   Example of try-with-resources:");
        System.out.println("   try (InputStream in = new FileInputStream(src);");
        System.out.println("        OutputStream out = new FileOutputStream(dst)) {");
        System.out.println("       // copy data");
        System.out.println("   }  // Resources automatically closed");
        System.out.println();
        
        // Multiple resources example
        System.out.println("3. MULTIPLE RESOURCES:");
        try {
            CopyFile.useMultipleResources();
        } catch (IOException e) {
            System.out.println("   Error: " + e.getMessage());
        }
        System.out.println();
        
        // Suppressed exceptions
        System.out.println("4. SUPPRESSED EXCEPTIONS:");
        System.out.println("   In try-finally, if both try and finally throw exceptions,");
        System.out.println("   the exception from finally suppresses the one from try.");
        System.out.println();
        System.out.println("   In try-with-resources, suppressed exceptions are preserved");
        System.out.println("   and can be accessed via getSuppressed().");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always use try-with-resources instead of try-finally");
        System.out.println("2. Resources must implement AutoCloseable");
        System.out.println("3. Resources are closed in reverse order of declaration");
        System.out.println("4. Suppressed exceptions are preserved");
        System.out.println("5. Much more concise and less error-prone");
        System.out.println("6. Works with multiple resources elegantly");
    }
}

