package com.effectivejava.item48.parallelstreams;

/**
 * Demonstration of Item 48: Use caution when making streams parallel.
 */
public class ParallelStreamsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 48: Use Caution When Making Streams Parallel ===\n");
        
        System.out.println("1. WHEN TO USE PARALLEL STREAMS:");
        System.out.println("   - Large datasets");
        System.out.println("   - CPU-intensive operations");
        System.out.println("   - Independent operations");
        System.out.println("   - No shared mutable state");
        System.out.println();
        
        System.out.println("2. WHEN NOT TO USE PARALLEL STREAMS:");
        System.out.println("   - Small datasets (overhead > benefit)");
        System.out.println("   - I/O-bound operations");
        System.out.println("   - Operations with dependencies");
        System.out.println("   - Shared mutable state");
        System.out.println();
        
        System.out.println("3. PROBLEMS:");
        System.out.println("   - Overhead can outweigh benefits");
        System.out.println("   - Thread safety issues");
        System.out.println("   - Unpredictable performance");
        System.out.println("   - Can be slower than sequential");
        System.out.println();
        
        System.out.println("4. BEST PRACTICE:");
        System.out.println("   - Start with sequential streams");
        System.out.println("   - Measure performance");
        System.out.println("   - Only parallelize if it helps");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use parallel streams with caution");
        System.out.println("2. Only use for large datasets and independent operations");
        System.out.println("3. Measure performance - parallel isn't always faster");
        System.out.println("4. Prefer sequential streams unless you have a good reason");
    }
}

