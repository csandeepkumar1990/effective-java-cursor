package com.effectivejava.item74.documentexceptions;

import java.io.IOException;

/**
 * Item 74: Document all exceptions thrown by each method.
 * 
 * Always document:
 * - Checked exceptions (in @throws tags)
 * - Unchecked exceptions that are part of the method's contract
 * - All exceptions that callers might reasonably expect
 * 
 * Use @throws tag in JavaDoc for each exception.
 */
public class MethodDocumentation {
    
    /**
     * GOOD: Documents all exceptions.
     * 
     * @param filename the name of the file to read
     * @return the contents of the file as a string
     * @throws IOException if the file cannot be read
     * @throws IllegalArgumentException if filename is null or empty
     * @throws java.nio.file.NoSuchFileException if the file does not exist
     */
    public static String readFile(String filename) throws IOException {
        if (filename == null || filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be null or empty");
        }
        return new String(java.nio.file.Files.readAllBytes(
            java.nio.file.Paths.get(filename)));
    }
    
    /**
     * GOOD: Documents unchecked exceptions that are part of contract.
     * 
     * @param index the index to retrieve
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if index is out of range
     */
    public String getElement(int index) {
        // Implementation would throw IndexOutOfBoundsException
        return "";
    }
    
    /**
     * BAD: Doesn't document exceptions.
     * Callers don't know what to expect.
     */
    public static void undocumentedMethod(String input) {
        if (input == null) {
            throw new NullPointerException();  // Not documented!
        }
    }
}

