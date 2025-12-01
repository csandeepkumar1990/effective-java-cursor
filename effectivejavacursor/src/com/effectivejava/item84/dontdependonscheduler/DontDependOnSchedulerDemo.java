package com.effectivejava.item84.dontdependonscheduler;

/**
 * Demonstration of Item 84: Don't depend on the thread scheduler.
 */
public class DontDependOnSchedulerDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 84: Don't Depend on Thread Scheduler ===\n");
        
        System.out.println("1. DON'T RELY ON:");
        System.out.println("   - Thread.yield()");
        System.out.println("   - Thread priorities");
        System.out.println("   - Thread.sleep() for correctness");
        System.out.println();
        
        System.out.println("2. PROBLEMS:");
        System.out.println("   - Unreliable behavior");
        System.out.println("   - Not portable");
        System.out.println("   - Wastes CPU (busy-waiting)");
        System.out.println();
        
        System.out.println("3. SOLUTIONS:");
        System.out.println("   - Use proper synchronization");
        System.out.println("   - Use concurrent utilities");
        System.out.println("   - Ensure threads have enough work");
        System.out.println("   - Don't busy-wait");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   BAD: while (!condition) { Thread.yield(); }");
        System.out.println("   GOOD: synchronized (lock) { while (!condition) lock.wait(); }");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't depend on thread scheduling");
        System.out.println("2. Use proper synchronization");
        System.out.println("3. Use concurrent utilities");
        System.out.println("4. Write correct, portable code");
    }
}

