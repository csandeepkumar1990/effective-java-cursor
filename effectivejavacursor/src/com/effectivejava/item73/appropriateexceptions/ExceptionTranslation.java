package com.effectivejava.item73.appropriateexceptions;

/**
 * Item 73: Throw exceptions appropriate to the abstraction.
 * 
 * Higher layers should catch lower-level exceptions and throw
 * exceptions that are appropriate to the higher-level abstraction.
 * 
 * This is called "exception translation".
 * 
 * Pattern:
 * try {
 *     // Lower-level operation
 * } catch (LowerLevelException e) {
 *     throw new HigherLevelException(e);
 * }
 */
public class ExceptionTranslation {
    
    /**
     * BAD: Propagating low-level exception.
     * Caller shouldn't know about implementation details.
     */
    public static void badExample() throws java.sql.SQLException {
        // Exposing SQLException - implementation detail!
        throw new java.sql.SQLException("Database error");
    }
    
    /**
     * GOOD: Exception translation.
     * Translate to exception appropriate to abstraction.
     */
    public static void goodExample() throws DataAccessException {
        try {
            // Lower-level database operation
            throw new java.sql.SQLException("Database error");
        } catch (java.sql.SQLException e) {
            // Translate to higher-level exception
            throw new DataAccessException("Failed to access data", e);
        }
    }
    
    /**
     * Exception chaining: Preserve cause.
     */
    public static class DataAccessException extends Exception {
        public DataAccessException(String message, Throwable cause) {
            super(message, cause);  // Preserve cause for debugging
        }
    }
    
    /**
     * Example: Abstracting file operations.
     */
    public static void readConfiguration(String filename) throws ConfigurationException {
        try {
            java.nio.file.Files.readAllLines(java.nio.file.Paths.get(filename));
        } catch (java.io.IOException e) {
            // Translate IOException to ConfigurationException
            throw new ConfigurationException("Failed to read configuration: " + filename, e);
        }
    }
    
    public static class ConfigurationException extends Exception {
        public ConfigurationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

