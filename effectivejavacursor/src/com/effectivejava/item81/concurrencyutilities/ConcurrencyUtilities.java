package com.effectivejava.item81.concurrencyutilities;

import java.util.concurrent.*;

/**
 * Item 81: Prefer concurrency utilities to wait and notify.
 * 
 * Modern Java provides better concurrency utilities:
 * - CountDownLatch
 * - CyclicBarrier
 * - Semaphore
 * - Exchanger
 * - Concurrent collections
 * 
 * Benefits:
 * - Easier to use correctly
 * - Less error-prone
 * - Better performance
 * - More features
 */
public class ConcurrencyUtilities {
    
    /**
     * BAD: Using wait and notify.
     * Error-prone and hard to use correctly.
     */
    public static class WaitNotifyExample {
        private boolean ready = false;
        
        public synchronized void waitForReady() throws InterruptedException {
            while (!ready) {
                wait();  // Easy to get wrong
            }
        }
        
        public synchronized void setReady() {
            ready = true;
            notifyAll();  // Must use notifyAll, not notify
        }
    }
    
    /**
     * GOOD: Using CountDownLatch.
     * Much simpler and safer.
     */
    public static void countDownLatchExample() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        
        // Thread 1: Wait for signal
        new Thread(() -> {
            try {
                latch.await();  // Wait for countdown
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
        
        // Thread 2: Signal
        Thread.sleep(100);
        latch.countDown();  // Signal waiting thread
    }
    
    /**
     * Example: Using Semaphore for resource limiting.
     */
    public static void semaphoreExample() {
        Semaphore semaphore = new Semaphore(3);  // Allow 3 concurrent
        
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Task " + taskId + " running");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
    
    /**
     * Example: Using ConcurrentHashMap.
     */
    public static void concurrentCollectionExample() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("key", "value");
        // Thread-safe operations without explicit synchronization
    }
}

