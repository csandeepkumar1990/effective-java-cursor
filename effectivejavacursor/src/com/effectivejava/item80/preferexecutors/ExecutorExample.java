package com.effectivejava.item80.preferexecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Item 80: Prefer executors, tasks, and streams to threads.
 * 
 * Modern Java provides better abstractions than raw Thread:
 * - ExecutorService: Manages thread pools
 * - Tasks (Runnable, Callable): Units of work
 * - Streams: Parallel processing
 * 
 * Benefits:
 * - Better resource management
 * - Easier to use
 * - More flexible
 * - Better performance
 */
public class ExecutorExample {
    
    /**
     * BAD: Using raw Thread.
     * Hard to manage, no thread pool.
     */
    public static void badExample() {
        Thread thread = new Thread(() -> {
            System.out.println("Running in thread");
        });
        thread.start();
        // Must manage thread lifecycle manually
    }
    
    /**
     * GOOD: Using ExecutorService.
     * Better resource management.
     */
    public static void goodExample() {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.execute(() -> {
            System.out.println("Running in executor");
        });
        exec.shutdown();  // Important: shutdown when done
    }
    
    /**
     * BETTER: Using thread pool.
     * Reuses threads efficiently.
     */
    public static void betterExample() {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            final int taskId = i;
            exec.execute(() -> {
                System.out.println("Task " + taskId + " running");
            });
        }
        exec.shutdown();
    }
    
    /**
     * BEST: Using Callable and Future for results.
     */
    public static Future<String> bestExample() {
        ExecutorService exec = Executors.newCachedThreadPool();
        return exec.submit(() -> {
            return "Result";
        });
    }
}

