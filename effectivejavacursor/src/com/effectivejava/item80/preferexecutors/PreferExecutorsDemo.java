package com.effectivejava.item80.preferexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Demonstration of Item 80: Prefer executors, tasks, and streams to threads.
 */
public class PreferExecutorsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 80: Prefer Executors to Threads ===\n");
        
        System.out.println("1. MODERN ABSTRACTIONS:");
        System.out.println("   - ExecutorService: Manages thread pools");
        System.out.println("   - Tasks (Runnable, Callable): Units of work");
        System.out.println("   - Streams: Parallel processing");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Better resource management");
        System.out.println("   - Easier to use");
        System.out.println("   - More flexible");
        System.out.println("   - Better performance");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: new Thread(() -> {...}).start()");
        System.out.println("   GOOD: executor.execute(() -> {...})");
        System.out.println();
        
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(() -> System.out.println("   Task running in executor"));
        exec.shutdown();
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer ExecutorService to raw Thread");
        System.out.println("2. Use thread pools for efficiency");
        System.out.println("3. Use Callable for tasks that return values");
        System.out.println("4. Always shutdown executors when done");
    }
}

