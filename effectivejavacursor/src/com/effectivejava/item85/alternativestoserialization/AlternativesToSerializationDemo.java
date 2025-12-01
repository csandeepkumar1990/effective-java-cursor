package com.effectivejava.item85.alternativestoserialization;

/**
 * Demonstration of Item 85: Prefer alternatives to Java serialization.
 */
public class AlternativesToSerializationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 85: Prefer Alternatives to Serialization ===\n");
        
        System.out.println("1. PROBLEMS WITH JAVA SERIALIZATION:");
        System.out.println("   - Security vulnerabilities");
        System.out.println("   - Performance overhead");
        System.out.println("   - Maintenance burden");
        System.out.println("   - Versioning issues");
        System.out.println();
        
        System.out.println("2. ALTERNATIVES:");
        System.out.println("   - JSON (Jackson, Gson)");
        System.out.println("   - Protocol Buffers");
        System.out.println("   - Avro");
        System.out.println("   - Custom binary formats");
        System.out.println();
        
        System.out.println("3. WHEN TO USE ALTERNATIVES:");
        System.out.println("   - New code: Use alternatives");
        System.out.println("   - Cross-language: Use JSON or Protocol Buffers");
        System.out.println("   - Performance: Use Protocol Buffers or custom format");
        System.out.println("   - Human-readable: Use JSON");
        System.out.println();
        
        System.out.println("4. WHEN JAVA SERIALIZATION IS OK:");
        System.out.println("   - Legacy code that already uses it");
        System.out.println("   - RMI (requires serialization)");
        System.out.println("   - Temporary storage");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer alternatives to Java serialization");
        System.out.println("2. JSON for human-readable, cross-language");
        System.out.println("3. Protocol Buffers for efficient binary");
        System.out.println("4. Avoid Java serialization in new code");
    }
}

