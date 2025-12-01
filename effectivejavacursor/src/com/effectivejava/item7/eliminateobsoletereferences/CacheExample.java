package com.effectivejava.item7.eliminateobsoletereferences;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Examples of memory leaks in caches and how to fix them.
 * 
 * Common sources of memory leaks:
 * 1. Caches - objects remain in cache after becoming irrelevant
 * 2. Listeners/Callbacks - registered but never deregistered
 */
public class CacheExample {
    
    /**
     * Example 1: WeakHashMap for cache entries that are relevant
     * as long as there are external references to the key.
     * 
     * WeakHashMap automatically removes entries when the key is
     * no longer referenced elsewhere (becomes eligible for GC).
     */
    public static class WeakHashMapCache {
        private final Map<String, String> cache = new WeakHashMap<>();
        
        public void put(String key, String value) {
            cache.put(key, value);
        }
        
        public String get(String key) {
            return cache.get(key);
        }
        
        public int size() {
            return cache.size();
        }
    }
    
    /**
     * Example 2: LinkedHashMap with removeEldestEntry for LRU cache.
     * 
     * This automatically removes the least recently used entry
     * when the cache exceeds a certain size.
     */
    public static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;
        
        public LRUCache(int maxSize) {
            super(16, 0.75f, true); // accessOrder = true for LRU
            this.maxSize = maxSize;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > maxSize;
        }
    }
    
    /**
     * Example 3: Simple cache that can accumulate memory leaks
     * if entries are never removed.
     * 
     * This demonstrates the problem - entries accumulate forever.
     */
    public static class LeakyCache<K, V> {
        private final Map<K, V> cache = new java.util.HashMap<>();
        
        public void put(K key, V value) {
            cache.put(key, value);
        }
        
        public V get(K key) {
            return cache.get(key);
        }
        
        public int size() {
            return cache.size();
        }
        
        // No mechanism to remove old entries - memory leak!
    }
}

