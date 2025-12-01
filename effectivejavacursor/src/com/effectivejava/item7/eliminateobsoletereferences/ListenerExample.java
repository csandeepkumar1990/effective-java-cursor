package com.effectivejava.item7.eliminateobsoletereferences;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * Examples of memory leaks with listeners and callbacks.
 * 
 * Problem: If clients register callbacks but don't deregister them,
 * the callbacks accumulate and prevent garbage collection.
 */
public class ListenerExample {
    
    /**
     * Example 1: Listener registry that can leak memory.
     * 
     * Problem: Listeners are stored with strong references.
     * If clients don't explicitly remove listeners, they accumulate.
     */
    public static class LeakyListenerRegistry {
        private final List<Runnable> listeners = new ArrayList<>();
        
        public void addListener(Runnable listener) {
            listeners.add(listener);
        }
        
        public void removeListener(Runnable listener) {
            listeners.remove(listener);
        }
        
        public void notifyListeners() {
            for (Runnable listener : listeners) {
                listener.run();
            }
        }
        
        public int getListenerCount() {
            return listeners.size();
        }
    }
    
    /**
     * Example 2: Listener registry using WeakHashMap to prevent leaks.
     * 
     * Solution: Store listeners as keys in WeakHashMap.
     * When the listener object is no longer referenced elsewhere,
     * it becomes eligible for GC and is automatically removed.
     */
    public static class FixedListenerRegistry {
        private final WeakHashMap<Runnable, Boolean> listeners = new WeakHashMap<>();
        
        public void addListener(Runnable listener) {
            listeners.put(listener, Boolean.TRUE);
        }
        
        public void removeListener(Runnable listener) {
            listeners.remove(listener);
        }
        
        public void notifyListeners() {
            // Create a copy to avoid ConcurrentModificationException
            List<Runnable> toNotify = new ArrayList<>(listeners.keySet());
            for (Runnable listener : toNotify) {
                if (listener != null) {
                    listener.run();
                }
            }
        }
        
        public int getListenerCount() {
            return listeners.size();
        }
    }
    
    /**
     * Example 3: Better approach - explicit lifecycle management.
     * 
     * Clients must explicitly register and deregister.
     * This is the most common pattern in practice.
     */
    public static class ExplicitListenerRegistry {
        private final List<Runnable> listeners = new ArrayList<>();
        
        public void register(Runnable listener) {
            if (listener == null) {
                throw new NullPointerException("Listener cannot be null");
            }
            listeners.add(listener);
        }
        
        public void unregister(Runnable listener) {
            listeners.remove(listener);
        }
        
        public void notifyListeners() {
            for (Runnable listener : listeners) {
                listener.run();
            }
        }
        
        public void clear() {
            listeners.clear();
        }
        
        public int getListenerCount() {
            return listeners.size();
        }
    }
}

