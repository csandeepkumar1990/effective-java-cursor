package com.effectivejava.item89.enumreadresolve;

import java.io.Serializable;

/**
 * Item 89: For instance control, prefer enum types to readResolve.
 * 
 * PROBLEM: readResolve can be attacked.
 * SOLUTION: Use enum singleton instead.
 * 
 * Enum singletons are:
 * - Immune to serialization attacks
 * - Immune to reflection attacks
 * - More concise
 * - Automatically handle serialization
 */
public class Elvis {
    
    /**
     * BAD: Using readResolve for singleton.
     * Can be attacked via serialization.
     */
    public static class ElvisReadResolve implements Serializable {
        private static final long serialVersionUID = 1L;
        public static final ElvisReadResolve INSTANCE = new ElvisReadResolve();
        
        private ElvisReadResolve() {
        }
        
        /**
         * readResolve can be attacked.
         * Attacker can create instance before readResolve runs.
         */
        private Object readResolve() {
            return INSTANCE;
        }
    }
    
    /**
     * GOOD: Using enum singleton.
     * Immune to all attacks.
     */
    public enum ElvisEnum implements Serializable {
        INSTANCE;
        
        public void leaveTheBuilding() {
            System.out.println("Elvis has left the building");
        }
        
        // Serialization handled automatically
        // No readResolve needed
    }
}

