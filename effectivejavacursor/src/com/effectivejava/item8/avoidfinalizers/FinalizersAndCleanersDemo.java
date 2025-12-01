package com.effectivejava.item8.avoidfinalizers;

/**
 * Demonstration of Item 8: Avoid finalizers and cleaners.
 * 
 * This demo shows:
 * 1. Problems with finalizers
 * 2. Problems with cleaners
 * 3. Preferred approach: explicit cleanup with AutoCloseable
 * 4. Finalizer attacks
 */
public class FinalizersAndCleanersDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 8: Avoid Finalizers and Cleaners ===\n");
        
        System.out.println("1. PROBLEMS WITH FINALIZERS:");
        System.out.println("   - Unpredictable timing (may never run)");
        System.out.println("   - Significant performance overhead");
        System.out.println("   - No guarantee of execution order");
        System.out.println("   - Can hide exceptions");
        System.out.println("   - Security issues (finalizer attacks)");
        System.out.println("   - Deprecated in Java 9");
        System.out.println();
        
        System.out.println("2. PROBLEMS WITH CLEANERS:");
        System.out.println("   - Still unpredictable timing");
        System.out.println("   - Still performance overhead");
        System.out.println("   - Still no guarantee of execution");
        System.out.println("   - Better than finalizers, but still not recommended");
        System.out.println();
        
        // Explicit cleanup - preferred approach
        System.out.println("3. PREFERRED APPROACH: Explicit Cleanup");
        System.out.println("   Use AutoCloseable and try-with-resources");
        System.out.println();
        
        try (Room room1 = new Room(101)) {
            System.out.println("   Using room: " + room1.getRoomNumber());
            // Room will be automatically closed when leaving try block
        }
        System.out.println("   Room closed automatically via try-with-resources");
        System.out.println();
        
        // Cleaner example (not recommended, but shown for illustration)
        System.out.println("4. CLEANER EXAMPLE (Not Recommended):");
        try (Room room2 = new Room(202)) {
            System.out.println("   Using room: " + room2.getRoomNumber());
        }
        System.out.println("   Room closed via try-with-resources (preferred)");
        System.out.println("   Note: Cleaner may run eventually if not explicitly closed,");
        System.out.println("   but we can't predict when");
        System.out.println();
        
        // Finalizer attack
        System.out.println("5. FINALIZER ATTACKS:");
        System.out.println("   Finalizers can be exploited for security attacks");
        System.out.println("   Solution: Make finalize() final and throw exception");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. NEVER use finalizers - they are deprecated");
        System.out.println("2. Avoid cleaners - they are unpredictable");
        System.out.println("3. Use AutoCloseable for cleanup");
        System.out.println("4. Use try-with-resources for automatic cleanup");
        System.out.println("5. Explicit cleanup is better than implicit");
        System.out.println("6. If you must use finalizer, make it final and throw exception");
        System.out.println("7. Cleaners are acceptable for safety nets, but not primary cleanup");
    }
}

