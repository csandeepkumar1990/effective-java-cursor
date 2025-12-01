package com.effectivejava.item2.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Builder pattern for class hierarchies.
 * 
 * This abstract class demonstrates how to use the Builder pattern with inheritance.
 * The key features:
 * 1. Abstract builder with recursive type parameter (self-type idiom)
 * 2. Abstract self() method for method chaining in subclasses
 * 3. Abstract build() method that subclasses must implement
 */
public abstract class Pizza {
    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    
    final Set<Topping> toppings;
    
    /**
     * Abstract builder with recursive type parameter.
     * The generic type parameter T extends Builder<T> allows method chaining
     * to work properly in subclasses without the need for casts.
     * This is known as the "simulated self-type idiom" (workaround for Java's lack of self type).
     */
    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        
        /**
         * Add a topping to the pizza.
         * Returns self() to enable method chaining.
         */
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        
        /**
         * Build the pizza. Subclasses must override to return their specific type.
         */
        abstract Pizza build();
        
        /**
         * Subclasses must override this method to return "this".
         * This enables method chaining in subclasses.
         */
        protected abstract T self();
    }
    
    /**
     * Constructor for Pizza. Takes a builder and copies its toppings.
     * Note: Using clone() as recommended in Item 50.
     */
    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone(); // See Item 50
    }
}

