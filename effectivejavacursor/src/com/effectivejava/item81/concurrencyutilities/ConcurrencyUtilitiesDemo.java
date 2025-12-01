package com.effectivejava.item81.concurrencyutilities;

/**
 * Demonstration of Item 81: Prefer concurrency utilities to wait and notify.
 */
public class ConcurrencyUtilitiesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 81: Prefer Concurrency Utilities ===\n");
        
        System.out.println("1. MODERN CONCURRENCY UTILITIES:");
        System.out.println("   - CountDownLatch");
        System.out.println("   - CyclicBarrier");
        System.out.println("   - Semaphore");
        System.out.println("   - Exchanger");
        System.out.println("   - Concurrent collections");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Easier to use correctly");
        System.out.println("   - Less error-prone");
        System.out.println("   - Better performance");
        System.out.println("   - More features");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: wait() and notify() - error-prone");
        System.out.println("   GOOD: CountDownLatch - simple and safe");
        System.out.println();
        
        try {
            ConcurrencyUtilities.countDownLatchExample();
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer concurrency utilities to wait/notify");
        System.out.println("2. CountDownLatch for one-time coordination");
        System.out.println("3. Semaphore for resource limiting");
        System.out.println("4. Concurrent collections for thread-safe operations");
    }
}

