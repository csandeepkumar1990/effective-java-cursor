package com.effectivejava.item2.builder;

import java.util.Objects;

/**
 * New York style pizza - a concrete subclass of Pizza.
 * 
 * This demonstrates:
 * 1. Concrete builder extending abstract builder
 * 2. Required parameter (size) in builder constructor
 * 3. Covariant return typing - build() returns NyPizza, not Pizza
 * 4. self() method returns Builder (not Pizza.Builder)
 */
public class NyPizza extends Pizza {
    public enum Size { SMALL, MEDIUM, LARGE }
    
    private final Size size;
    
    /**
     * Concrete builder for NyPizza.
     * Extends Pizza.Builder<Builder> to enable method chaining.
     */
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        
        /**
         * Constructor with required parameter.
         * Size is required for New York style pizza.
         */
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }
        
        /**
         * Build method with covariant return type.
         * Returns NyPizza (not Pizza), allowing clients to use the builder
         * without casting. This is known as "covariant return typing".
         */
        @Override
        public NyPizza build() {
            return new NyPizza(this);
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
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
    
    public Size getSize() {
        return size;
    }
    
    @Override
    public String toString() {
        return String.format("NyPizza[size=%s, toppings=%s]", size, toppings);
    }
}

