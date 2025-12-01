package com.effectivejava.item85.alternativestoserialization;

import java.io.*;

/**
 * Item 85: Prefer alternatives to Java serialization.
 * 
 * PROBLEMS with Java serialization:
 * - Security vulnerabilities
 * - Performance overhead
 * - Maintenance burden
 * - Versioning issues
 * 
 * ALTERNATIVES:
 * - JSON (Jackson, Gson)
 * - Protocol Buffers
 * - Avro
 * - Custom binary formats
 */
public class Alternatives {
    
    /**
     * BAD: Using Java serialization.
     * Security risks and maintenance burden.
     */
    public static void javaSerialization(Object obj) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("data.ser"))) {
            out.writeObject(obj);  // Security risk!
        }
    }
    
    /**
     * GOOD: Using JSON (example with Gson).
     * Safer and more portable.
     */
    public static String jsonSerialization(Object obj) {
        // Using JSON library (e.g., Gson, Jackson)
        // return gson.toJson(obj);
        return "{\"field\":\"value\"}";  // Simplified example
    }
    
    /**
     * GOOD: Using Protocol Buffers.
     * Efficient and type-safe.
     */
    public static void protocolBufferExample() {
        // Protocol Buffers provide:
        // - Efficient binary format
        // - Type safety
        // - Versioning support
        // - Cross-language support
    }
    
    /**
     * GOOD: Custom binary format.
     * Full control over format.
     */
    public static void customFormat(Object obj) throws IOException {
        try (DataOutputStream out = new DataOutputStream(
                new FileOutputStream("data.bin"))) {
            // Write fields explicitly
            // out.writeInt(value);
            // out.writeUTF(string);
        }
    }
}

