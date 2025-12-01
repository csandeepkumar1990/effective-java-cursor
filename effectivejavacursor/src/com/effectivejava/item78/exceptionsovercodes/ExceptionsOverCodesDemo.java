package com.effectivejava.item78.exceptionsovercodes;

/**
 * Demonstration of Item 78: Prefer exceptions to returning error codes.
 */
public class ExceptionsOverCodesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 78: Prefer Exceptions to Error Codes ===\n");
        
        System.out.println("1. PROBLEMS WITH ERROR CODES:");
        System.out.println("   - Easy to ignore");
        System.out.println("   - Clutters code");
        System.out.println("   - No way to force handling");
        System.out.println("   - Can't provide context");
        System.out.println();
        
        System.out.println("2. BENEFITS OF EXCEPTIONS:");
        System.out.println("   - Can't be ignored");
        System.out.println("   - Cleaner code");
        System.out.println("   - Provide context");
        System.out.println("   - Separate error handling from normal flow");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: int result = deleteFile(\"file.txt\");");
        System.out.println("        if (result != 0) { ... }  // Easy to forget!");
        System.out.println();
        System.out.println("   GOOD: try { deleteFile(\"file.txt\"); }");
        System.out.println("         catch (IOException e) { ... }  // Must handle!");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer exceptions to error codes");
        System.out.println("2. Exceptions can't be ignored");
        System.out.println("3. Exceptions provide better context");
        System.out.println("4. Cleaner separation of error handling");
    }
}

