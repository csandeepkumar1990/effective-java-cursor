package com.effectivejava.item79.avoidexcessivesync;

/**
 * Demonstration of Item 79: Avoid excessive synchronization.
 */
public class AvoidExcessiveSyncDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 79: Avoid Excessive Synchronization ===\n");
        
        System.out.println("1. PROBLEMS:");
        System.out.println("   - Deadlocks");
        System.out.println("   - Performance degradation");
        System.out.println("   - Alien method calls in synchronized blocks");
        System.out.println();
        
        System.out.println("2. SOLUTIONS:");
        System.out.println("   - Minimize work in synchronized blocks");
        System.out.println("   - Use concurrent collections");
        System.out.println("   - Use CopyOnWriteArrayList for observers");
        System.out.println("   - Move alien method calls outside synchronized blocks");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: Alien method call in synchronized block");
        System.out.println("   synchronized (observers) {");
        System.out.println("       observer.added(...);  // BAD!");
        System.out.println("   }");
        System.out.println();
        System.out.println("   GOOD: Snapshot and call outside");
        System.out.println("   List<Observer> snapshot;");
        System.out.println("   synchronized (observers) { snapshot = new ArrayList<>(observers); }");
        System.out.println("   for (Observer o : snapshot) { o.added(...); }  // Outside sync");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Minimize work in synchronized blocks");
        System.out.println("2. Don't call alien methods in synchronized blocks");
        System.out.println("3. Use concurrent collections when appropriate");
        System.out.println("4. Use CopyOnWriteArrayList for observer lists");
    }
}

