package com.effectivejava.item8.avoidfinalizers;

/**
 * Example demonstrating finalizer attacks.
 * 
 * This shows how finalizers can be exploited for security attacks.
 * The attack works by:
 * 1. Creating an exception in finalizer
 * 2. Catching it in a try-catch
 * 3. Re-referencing the object
 * 4. Object is resurrected and can be used
 * 
 * SOLUTION: Make finalize() final and throw exception
 */
public class FinalizerAttack {
    
    /**
     * Vulnerable class - can be attacked via finalizer.
     */
    public static class Vulnerable {
        private String sensitiveData;
        
        public Vulnerable(String data) {
            this.sensitiveData = data;
        }
        
        public void doSomething() {
            if (sensitiveData == null) {
                throw new IllegalStateException("Object was finalized!");
            }
            System.out.println("Processing: " + sensitiveData);
        }
        
        // BAD: Non-final finalizer can be overridden
        // NOTE: finalize() is deprecated, shown for illustration only
        // @Override
        // @SuppressWarnings("deprecation")
        // protected void finalize() throws Throwable {
        //     System.out.println("Finalizing Vulnerable");
        //     // Attacker could resurrect object here
        //     super.finalize();
        // }
    }
    
    /**
     * Secure class - immune to finalizer attacks.
     */
    public static class Secure {
        private String sensitiveData;
        
        public Secure(String data) {
            this.sensitiveData = data;
        }
        
        public void doSomething() {
            if (sensitiveData == null) {
                throw new IllegalStateException("Object was finalized!");
            }
            System.out.println("Processing: " + sensitiveData);
        }
        
        // GOOD: Final finalizer that throws exception
        @Override
        protected final void finalize() throws Throwable {
            throw new AssertionError("Finalizer should never be called");
        }
    }
}

