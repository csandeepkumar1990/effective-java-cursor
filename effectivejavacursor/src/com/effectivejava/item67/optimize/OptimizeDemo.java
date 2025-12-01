package com.effectivejava.item67.optimize;

/**
 * Demonstration of Item 67: Optimize judiciously.
 */
public class OptimizeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 67: Optimize Judiciously ===\n");
        
        System.out.println("1. RULES OF OPTIMIZATION:");
        System.out.println("   1. Don't do it");
        System.out.println("   2. (For experts only) Don't do it yet");
        System.out.println();
        
        System.out.println("2. PRINCIPLES:");
        System.out.println("   - Measure before optimizing");
        System.out.println("   - Strive for good algorithms and data structures");
        System.out.println("   - Don't sacrifice clarity for small performance gains");
        System.out.println("   - Profile to find bottlenecks");
        System.out.println();
        
        System.out.println("3. PROCESS:");
        Optimization.optimizationProcess();
        System.out.println();
        
        System.out.println("4. QUOTE:");
        System.out.println("   \"More computing sins are committed in the name");
        System.out.println("   of efficiency (without necessarily achieving it)");
        System.out.println("   than for any other single reason.\"");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't optimize prematurely");
        System.out.println("2. Measure first, optimize second");
        System.out.println("3. Good algorithms > micro-optimizations");
        System.out.println("4. Clarity is more important than small performance gains");
    }
}

