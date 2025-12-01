package com.effectivejava.item82.documentthreadsafety;

import java.util.Collections;
import java.util.List;

/**
 * Item 82: Document thread-safety.
 * 
 * Always document the thread-safety guarantees of a class.
 * 
 * Thread-safety levels:
 * - Immutable: No synchronization needed
 * - Thread-safe: Safe for concurrent use
 * - Conditionally thread-safe: Safe with external synchronization
 * - Not thread-safe: Must synchronize externally
 * - Thread-hostile: Not safe even with synchronization
 */
public class ThreadSafety {
    
    /**
     * IMMUTABLE: No synchronization needed.
     * 
     * This class is immutable and therefore thread-safe.
     */
    public static final class ImmutablePoint {
        private final int x, y;
        
        public ImmutablePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int getX() { return x; }
        public int getY() { return y; }
    }
    
    /**
     * THREAD-SAFE: Safe for concurrent use.
     * 
     * This class is thread-safe. All methods are synchronized.
     */
    public static class SynchronizedList {
        private final List<String> list = Collections.synchronizedList(
            new java.util.ArrayList<>());
        
        public void add(String item) {
            list.add(item);  // Thread-safe
        }
        
        public int size() {
            return list.size();  // Thread-safe
        }
    }
    
    /**
     * NOT THREAD-SAFE: Must synchronize externally.
     * 
     * This class is not thread-safe. External synchronization
     * is required for concurrent access.
     */
    public static class NotThreadSafe {
        private int count = 0;
        
        public void increment() {
            count++;  // Not thread-safe!
        }
        
        public int getCount() {
            return count;  // Not thread-safe!
        }
    }
    
    /**
     * CONDITIONALLY THREAD-SAFE: Safe with external synchronization.
     * 
     * This class is conditionally thread-safe. It is safe for concurrent
     * use only when synchronized externally, for example:
     * 
     * List<String> list = new ArrayList<>();
     * synchronized (list) {
     *     list.add("item");
     * }
     */
    public static class ConditionallyThreadSafe {
        // Implementation
    }
}

