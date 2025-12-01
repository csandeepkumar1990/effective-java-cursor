package com.effectivejava.item70.checkedvsruntime;

import java.io.IOException;

/**
 * Item 70: Use checked exceptions for recoverable conditions and
 *          runtime exceptions for programming errors.
 * 
 * Checked Exceptions:
 * - Must be declared in method signature
 * - Caller must handle or propagate
 * - Use for recoverable conditions
 * - Example: IOException, SQLException
 * 
 * Runtime Exceptions:
 * - Don't need to be declared
 * - Indicate programming errors
 * - Use for unrecoverable conditions
 * - Example: NullPointerException, IllegalArgumentException
 * 
 * Errors:
 * - Reserved for JVM use
 * - Don't catch or throw
 * - Example: OutOfMemoryError, StackOverflowError
 */
public class ExceptionTypes {
    
    /**
     * Checked exception - recoverable condition.
     * Caller can handle and recover.
     */
    public static void readFile(String filename) throws IOException {
        // IOException is checked - caller must handle
        java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filename));
    }
    
    /**
     * Runtime exception - programming error.
     * Indicates a bug in the code.
     */
    public static void divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisor cannot be zero");
        }
        // ArithmeticException would be thrown anyway, but we provide better message
    }
    
    /**
     * BAD: Using checked exception for programming error.
     */
    public static void badExample(int index) throws IndexOutOfBoundsException {
        // IndexOutOfBoundsException is unchecked - shouldn't declare it
        // This is a programming error, not a recoverable condition
    }
    
    /**
     * GOOD: Runtime exception for programming error.
     */
    public static void goodExample(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Index cannot be negative: " + index);
        }
    }
    
    /**
     * Checked exception for recoverable condition.
     */
    public static void recoverableOperation() throws IOException {
        // This might fail, but caller can retry or handle gracefully
        throw new IOException("Network error - can retry");
    }
}

