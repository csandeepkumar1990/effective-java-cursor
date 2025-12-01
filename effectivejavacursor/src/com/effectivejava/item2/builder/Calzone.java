package com.effectivejava.item2.builder;

/**
 * Calzone - a concrete subclass of Pizza.
 * 
 * This demonstrates:
 * 1. Concrete builder extending abstract builder
 * 2. Optional parameter (sauceInside) with default value
 * 3. Fluent method name (sauceInside()) instead of setter
 * 4. Covariant return typing - build() returns Calzone, not Pizza
 */
public class Calzone extends Pizza {
    private final boolean sauceInside;
    
    /**
     * Concrete builder for Calzone.
     * Extends Pizza.Builder<Builder> to enable method chaining.
     */
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauceInside = false; // Default
        
        /**
         * Set sauce to be inside the calzone.
         * Returns self() for method chaining.
         * Note: Using a fluent method name instead of setSauceInside(boolean).
         */
        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }
        
        /**
         * Build method with covariant return type.
         * Returns Calzone (not Pizza), allowing clients to use the builder
         * without casting.
         */
        @Override
        public Calzone build() {
            return new Calzone(this);
        }
        
        /**
         * Return self for method chaining.
         * This is required for the self-type idiom to work.
         */
        @Override
        protected Builder self() {
            return this;
        }
    }
    
    /**
     * Private constructor. Only the builder can create instances.
     */
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }
    
    public boolean isSauceInside() {
        return sauceInside;
    }
    
    @Override
    public String toString() {
        return String.format("Calzone[sauceInside=%s, toppings=%s]", sauceInside, toppings);
    }
}

