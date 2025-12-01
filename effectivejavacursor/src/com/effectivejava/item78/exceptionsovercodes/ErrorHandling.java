package com.effectivejava.item78.exceptionsovercodes;

/**
 * Item 78: Prefer exceptions to returning error codes.
 * 
 * PROBLEMS with error codes:
 * - Easy to ignore
 * - Clutters code
 * - No way to force handling
 * - Can't provide context
 * 
 * BENEFITS of exceptions:
 * - Can't be ignored
 * - Cleaner code
 * - Provide context
 * - Separate error handling from normal flow
 */
public class ErrorHandling {
    
    /**
     * BAD: Using error codes.
     * Easy to ignore, clutters code.
     */
    public static int deleteFileBad(String filename) {
        // Returns error code: 0 = success, -1 = failure
        // Caller must check return value
        return -1;  // Error code
    }
    
    /**
     * GOOD: Using exceptions.
     * Can't be ignored, cleaner code.
     */
    public static void deleteFileGood(String filename) throws java.io.IOException {
        // Throws exception on failure
        // Caller must handle or propagate
        throw new java.io.IOException("File not found: " + filename);
    }
    
    /**
     * BAD: Error code forces checking.
     */
    public static void badUsage() {
        int result = deleteFileBad("file.txt");
        if (result != 0) {
            // Handle error - but easy to forget!
        }
    }
    
    /**
     * GOOD: Exception forces handling.
     */
    public static void goodUsage() {
        try {
            deleteFileGood("file.txt");
        } catch (java.io.IOException e) {
            // Must handle - can't ignore!
            System.err.println("Error: " + e.getMessage());
        }
    }
}

