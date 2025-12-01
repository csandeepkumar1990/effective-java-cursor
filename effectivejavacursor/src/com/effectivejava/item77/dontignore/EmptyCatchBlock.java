package com.effectivejava.item77.dontignore;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 77: Don't ignore exceptions.
 * 
 * NEVER use an empty catch block!
 * 
 * If you can't handle an exception:
 * 1. At minimum, log it
 * 2. Document why it's safe to ignore
 * 3. Consider rethrowing
 * 4. Consider translating to appropriate exception
 */
public class EmptyCatchBlock {
    
    /**
     * BAD: Empty catch block.
     * Exception is silently ignored - very dangerous!
     */
    public static void badExample() {
        try {
            // Some operation that might throw
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // BAD: Ignoring exception!
        }
    }
    
    /**
     * GOOD: At minimum, log the exception.
     */
    public static void goodExample() {
        try {
            // Some operation
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Log the exception
            System.err.println("Arithmetic error: " + e.getMessage());
            // Or use proper logging framework
            // logger.error("Arithmetic error", e);
        }
    }
    
    /**
     * BETTER: Document why it's safe to ignore.
     */
    public static void betterExample() {
        List<String> list = new ArrayList<>();
        try {
            list.add("item");
        } catch (Exception e) {
            // Ignore - ArrayList.add() should never throw
            // but we catch to be defensive
            assert false : "ArrayList.add() should never throw";
        }
    }
    
    /**
     * BEST: Handle appropriately or rethrow.
     */
    public static void bestExample() throws Exception {
        try {
            // Operation that might throw
            processData();
        } catch (Exception e) {
            // Log for debugging
            System.err.println("Error processing data: " + e.getMessage());
            // Rethrow or translate to appropriate exception
            throw new ProcessingException("Failed to process data", e);
        }
    }
    
    private static void processData() throws Exception {
        // Implementation
    }
    
    private static class ProcessingException extends Exception {
        public ProcessingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

