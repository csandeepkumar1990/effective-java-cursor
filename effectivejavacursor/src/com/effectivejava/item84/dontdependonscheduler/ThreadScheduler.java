package com.effectivejava.item84.dontdependonscheduler;

/**
 * Item 84: Don't depend on the thread scheduler.
 * 
 * DON'T rely on thread scheduling behavior:
 * - Thread.yield()
 * - Thread priorities
 * - Thread.sleep() for correctness
 * 
 * SOLUTIONS:
 * - Use proper synchronization
 * - Use concurrent utilities
 * - Ensure threads have enough work
 * - Don't busy-wait
 */
public class ThreadScheduler {
    
    /**
     * BAD: Using Thread.yield().
     * Unreliable and non-portable.
     */
    public static void badYield() {
        while (!condition) {
            Thread.yield();  // BAD: Unreliable!
        }
    }
    
    /**
     * BAD: Relying on thread priorities.
     * Not portable across platforms.
     */
    public static void badPriority() {
        Thread thread = new Thread(() -> {
            // Work
        });
        thread.setPriority(Thread.MAX_PRIORITY);  // BAD: Not reliable!
        thread.start();
    }
    
    /**
     * BAD: Busy-waiting.
     * Wastes CPU cycles.
     */
    public static void badBusyWait() {
        while (!condition) {
            // Busy-wait - wastes CPU!
        }
    }
    
    /**
     * GOOD: Using proper synchronization.
     */
    private static boolean condition = false;
    private static final Object lock = new Object();
    
    public static void goodWait() throws InterruptedException {
        synchronized (lock) {
            while (!condition) {
                lock.wait();  // Proper wait/notify
            }
        }
    }
    
    public static void goodNotify() {
        synchronized (lock) {
            condition = true;
            lock.notifyAll();
        }
    }
    
    /**
     * GOOD: Using concurrent utilities.
     */
    public static void goodConcurrentUtility() {
        java.util.concurrent.CountDownLatch latch = new java.util.concurrent.CountDownLatch(1);
        // Use latch instead of busy-waiting
    }
}

