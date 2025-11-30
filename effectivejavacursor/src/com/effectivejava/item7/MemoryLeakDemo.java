package com.effectivejava.item7;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration of memory leaks and how to eliminate obsolete object references.
 */
public class MemoryLeakDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 7: Eliminate Obsolete Object References ===\n");
        
        // 1. Stack Memory Leak
        demonstrateStackLeak();
        System.out.println();
        
        // 2. Cache Memory Leaks
        demonstrateCacheLeaks();
        System.out.println();
        
        // 3. Listener Memory Leaks
        demonstrateListenerLeaks();
        System.out.println();
        
        // Summary
        System.out.println("=== Summary ===");
        System.out.println("When to null out references:");
        System.out.println("1. Classes that manage their own memory (like Stack)");
        System.out.println("2. When references become obsolete and won't fall out of scope");
        System.out.println();
        System.out.println("Common sources of memory leaks:");
        System.out.println("1. Caches - use WeakHashMap or periodic cleanup");
        System.out.println("2. Listeners/Callbacks - use weak references or explicit deregistration");
        System.out.println("3. Classes managing their own memory - null out obsolete references");
        System.out.println();
        System.out.println("Remember: Nulling out should be the exception, not the norm.");
        System.out.println("Let variables fall out of scope naturally when possible.");
    }
    
    private static void demonstrateStackLeak() {
        System.out.println("1. STACK MEMORY LEAK:");
        System.out.println("   Problem: Stack maintains references to popped objects");
        System.out.println();
        
        // Create stack with leak
        StackWithLeak leakyStack = new StackWithLeak();
        List<Object> references = new ArrayList<>();
        
        // Push some objects
        for (int i = 0; i < 10; i++) {
            Object obj = new Object();
            leakyStack.push(obj);
            references.add(obj); // Keep reference to prevent immediate GC
        }
        
        System.out.println("   Pushed 10 objects, stack size: " + leakyStack.size());
        
        // Pop all objects
        while (!leakyStack.isEmpty()) {
            leakyStack.pop();
        }
        
        System.out.println("   Popped all objects, stack size: " + leakyStack.size());
        System.out.println("   Problem: Stack still holds references to popped objects");
        System.out.println("   These references prevent garbage collection");
        System.out.println();
        
        // Fixed version
        System.out.println("2. FIXED STACK:");
        System.out.println("   Solution: Null out references in pop() method");
        System.out.println();
        
        StackFixed fixedStack = new StackFixed();
        for (int i = 0; i < 10; i++) {
            fixedStack.push(new Object());
        }
        
        System.out.println("   Pushed 10 objects, stack size: " + fixedStack.size());
        
        while (!fixedStack.isEmpty()) {
            fixedStack.pop();
        }
        
        System.out.println("   Popped all objects, stack size: " + fixedStack.size());
        System.out.println("   Fixed: References are nulled out, allowing GC");
    }
    
    private static void demonstrateCacheLeaks() {
        System.out.println("3. CACHE MEMORY LEAKS:");
        System.out.println();
        
        // WeakHashMap example
        System.out.println("   a) WeakHashMap Cache (automatic cleanup):");
        CacheExample.WeakHashMapCache weakCache = new CacheExample.WeakHashMapCache();
        String key1 = new String("key1"); // Don't use string literal
        weakCache.put(key1, "value1");
        System.out.println("      Cache size: " + weakCache.size());
        key1 = null; // Clear reference
        System.gc(); // Suggest GC (not guaranteed)
        System.out.println("      After clearing key reference and GC: " + weakCache.size());
        System.out.println("      WeakHashMap automatically removes entries when key is GC'd");
        System.out.println();
        
        // LRU Cache example
        System.out.println("   b) LRU Cache (size-limited):");
        CacheExample.LRUCache<String, String> lruCache = new CacheExample.LRUCache<>(3);
        lruCache.put("1", "one");
        lruCache.put("2", "two");
        lruCache.put("3", "three");
        System.out.println("      Added 3 entries, cache size: " + lruCache.size());
        lruCache.put("4", "four"); // Should remove oldest
        System.out.println("      Added 4th entry, cache size: " + lruCache.size());
        System.out.println("      LRU cache automatically removes oldest entry");
        System.out.println();
        
        // Leaky cache
        System.out.println("   c) Leaky Cache (problem):");
        CacheExample.LeakyCache<String, String> leakyCache = new CacheExample.LeakyCache<>();
        for (int i = 0; i < 1000; i++) {
            leakyCache.put("key" + i, "value" + i);
        }
        System.out.println("      Added 1000 entries, cache size: " + leakyCache.size());
        System.out.println("      Problem: No mechanism to remove old entries");
        System.out.println("      Entries accumulate forever, causing memory leak");
    }
    
    private static void demonstrateListenerLeaks() {
        System.out.println("4. LISTENER MEMORY LEAKS:");
        System.out.println();
        
        // Leaky listener registry
        System.out.println("   a) Leaky Listener Registry (problem):");
        ListenerExample.LeakyListenerRegistry leakyRegistry = new ListenerExample.LeakyListenerRegistry();
        for (int i = 0; i < 10; i++) {
            final int id = i;
            leakyRegistry.addListener(() -> System.out.println("      Listener " + id + " called"));
        }
        System.out.println("      Registered 10 listeners, count: " + leakyRegistry.getListenerCount());
        System.out.println("      Problem: If listeners aren't removed, they accumulate");
        System.out.println();
        
        // Fixed with WeakHashMap
        System.out.println("   b) Fixed with WeakHashMap:");
        ListenerExample.FixedListenerRegistry weakRegistry = new ListenerExample.FixedListenerRegistry();
        Runnable listener1 = () -> System.out.println("      Weak listener called");
        weakRegistry.addListener(listener1);
        System.out.println("      Registered listener, count: " + weakRegistry.getListenerCount());
        listener1 = null; // Clear reference
        System.gc(); // Suggest GC
        System.out.println("      After clearing reference and GC: " + weakRegistry.getListenerCount());
        System.out.println("      WeakHashMap automatically removes listeners when GC'd");
        System.out.println();
        
        // Explicit management
        System.out.println("   c) Explicit Lifecycle Management (recommended):");
        ListenerExample.ExplicitListenerRegistry explicitRegistry = new ListenerExample.ExplicitListenerRegistry();
        Runnable listener2 = () -> System.out.println("      Explicit listener called");
        explicitRegistry.register(listener2);
        System.out.println("      Registered listener, count: " + explicitRegistry.getListenerCount());
        explicitRegistry.unregister(listener2);
        System.out.println("      Unregistered listener, count: " + explicitRegistry.getListenerCount());
        System.out.println("      Clients must explicitly register/unregister");
        System.out.println("      Most common pattern in practice");
    }
}

