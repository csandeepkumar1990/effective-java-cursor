package com.effectivejava.item59.knowlibraries;

/**
 * Demonstration of Item 59: Know and use the libraries.
 */
public class KnowLibrariesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 59: Know and Use the Libraries ===\n");
        
        System.out.println("1. PRINCIPLE:");
        System.out.println("   Don't reinvent the wheel - use the standard library!");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Well-tested code");
        System.out.println("   - Better performance");
        System.out.println("   - Less code to maintain");
        System.out.println("   - Leverages expertise of library authors");
        System.out.println();
        
        System.out.println("3. KEY LIBRARIES TO KNOW:");
        System.out.println("   - java.lang (String, Math, etc.)");
        System.out.println("   - java.util (Collections, Arrays, etc.)");
        System.out.println("   - java.io (I/O operations)");
        System.out.println("   - java.util.concurrent (Concurrency)");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   BAD: Writing your own random number generator");
        System.out.println("   GOOD: Using Random.nextInt(n)");
        System.out.println("   BEST: Using ThreadLocalRandom for concurrent code");
        System.out.println();
        
        int random = RandomExample.randomBest(100);
        System.out.println("   Random number (0-99): " + random);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Know the standard libraries");
        System.out.println("2. Use library code instead of reinventing");
        System.out.println("3. Libraries are well-tested and optimized");
        System.out.println("4. Stay updated with new library features");
    }
}

