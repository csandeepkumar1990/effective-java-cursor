package com.effectivejava.item9.trywithresources;

import java.io.*;

/**
 * Item 9: Prefer try-with-resources to try-finally.
 * 
 * This class demonstrates the problems with try-finally and
 * the benefits of try-with-resources.
 * 
 * PROBLEMS WITH TRY-FINALLY:
 * 1. Verbose and ugly code
 * 2. Can suppress exceptions from try block
 * 3. Multiple resources require nested try-finally blocks
 * 4. Easy to forget to close resources
 * 
 * BENEFITS OF TRY-WITH-RESOURCES:
 * 1. Concise and readable
 * 2. Automatic resource management
 * 3. Suppressed exceptions are preserved
 * 4. Works with multiple resources
 * 5. Less error-prone
 */
public class CopyFile {
    
    private static final int BUFFER_SIZE = 8192;
    
    /**
     * BAD: Using try-finally for resource management.
     * Problems:
     * - Verbose
     * - Can suppress exceptions
     * - Easy to make mistakes
     */
    public static void copyBad(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte[] buf = new byte[BUFFER_SIZE];
                int n;
                while ((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();  // If this throws, it can suppress exception from try block
            }
        } finally {
            in.close();  // If this throws, it can suppress exception from try block
        }
    }
    
    /**
     * GOOD: Using try-with-resources.
     * Benefits:
     * - Concise
     * - Automatic resource management
     * - Suppressed exceptions are preserved
     * - Less error-prone
     */
    public static void copyGood(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
        // Resources are automatically closed, even if exceptions occur
    }
    
    /**
     * Example with custom resource that implements AutoCloseable.
     */
    public static class CustomResource implements AutoCloseable {
        private final String name;
        
        public CustomResource(String name) {
            this.name = name;
            System.out.println("Opening resource: " + name);
        }
        
        public void use() {
            System.out.println("Using resource: " + name);
        }
        
        @Override
        public void close() throws IOException {
            System.out.println("Closing resource: " + name);
        }
    }
    
    /**
     * Example showing multiple resources with try-with-resources.
     */
    public static void useMultipleResources() throws IOException {
        try (CustomResource res1 = new CustomResource("Resource1");
             CustomResource res2 = new CustomResource("Resource2")) {
            res1.use();
            res2.use();
        }
        // Both resources are automatically closed in reverse order
    }
}

