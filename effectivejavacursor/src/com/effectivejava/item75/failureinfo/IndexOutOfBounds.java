package com.effectivejava.item75.failureinfo;

import java.util.List;

/**
 * Item 75: Include failure-capture information in detail messages.
 * 
 * Exception detail messages should contain:
 * - Values of all parameters
 * - Values of all fields that contributed to the exception
 * - Context information
 * 
 * This helps with debugging and troubleshooting.
 */
public class IndexOutOfBounds {
    
    /**
     * BAD: No failure information.
     * Hard to debug.
     */
    public static void badExample(List<String> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new java.lang.IndexOutOfBoundsException();  // No info!
        }
    }
    
    /**
     * GOOD: Includes failure information.
     * Easy to debug.
     */
    public static void goodExample(List<String> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new java.lang.IndexOutOfBoundsException(
                String.format("Index: %d, Size: %d", index, list.size()));
        }
    }
    
    /**
     * BETTER: Constructor that takes index and size.
     * Most informative.
     */
    public static void bestExample(List<String> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new java.lang.IndexOutOfBoundsException(
                String.format("Index %d out of bounds for length %d", index, list.size()));
        }
    }
    
    /**
     * Example with multiple parameters.
     */
    public static void multipleParams(int start, int end, int length) {
        if (start < 0 || end > length || start > end) {
            throw new IllegalArgumentException(
                String.format("Invalid range: start=%d, end=%d, length=%d", 
                    start, end, length));
        }
    }
}

