package com.effectivejava.item2.builder;

import static com.effectivejava.item2.builder.Pizza.Topping.*;

/**
 * Demonstration of Builder pattern for class hierarchies.
 * 
 * This shows how to use builders with inheritance:
 * 1. Abstract base class (Pizza) with abstract builder
 * 2. Concrete subclasses (NyPizza, Calzone) with concrete builders
 * 3. Recursive type parameter (self-type idiom) for method chaining
 * 4. Covariant return typing for type safety
 */
public class HierarchicalBuilderDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern for Class Hierarchies ===\n");
        
        System.out.println("KEY CONCEPTS:");
        System.out.println("1. Recursive Type Parameter (Self-Type Idiom)");
        System.out.println("   - Builder<T extends Builder<T>> allows method chaining");
        System.out.println("   - Workaround for Java's lack of self type");
        System.out.println();
        
        System.out.println("2. Covariant Return Typing");
        System.out.println("   - Subclass build() returns subclass type, not base type");
        System.out.println("   - Clients don't need casts");
        System.out.println();
        
        System.out.println("3. Parallel Builder Hierarchy");
        System.out.println("   - Abstract class has abstract builder");
        System.out.println("   - Concrete classes have concrete builders");
        System.out.println();
        
        // Example 1: NyPizza
        System.out.println("=== Example 1: New York Style Pizza ===");
        NyPizza nyPizza = new NyPizza.Builder(NyPizza.Size.SMALL)
            .addTopping(SAUSAGE)
            .addTopping(ONION)
            .build();
        
        System.out.println("Code:");
        System.out.println("NyPizza pizza = new NyPizza.Builder(SMALL)");
        System.out.println("    .addTopping(SAUSAGE)");
        System.out.println("    .addTopping(ONION)");
        System.out.println("    .build();");
        System.out.println();
        System.out.println("Result: " + nyPizza);
        System.out.println();
        
        // Example 2: Calzone
        System.out.println("=== Example 2: Calzone ===");
        Calzone calzone = new Calzone.Builder()
            .addTopping(HAM)
            .sauceInside()
            .build();
        
        System.out.println("Code:");
        System.out.println("Calzone calzone = new Calzone.Builder()");
        System.out.println("    .addTopping(HAM)");
        System.out.println("    .sauceInside()");
        System.out.println("    .build();");
        System.out.println();
        System.out.println("Result: " + calzone);
        System.out.println();
        
        // Example 3: More complex pizza
        System.out.println("=== Example 3: Complex Pizza ===");
        NyPizza largePizza = new NyPizza.Builder(NyPizza.Size.LARGE)
            .addTopping(HAM)
            .addTopping(MUSHROOM)
            .addTopping(ONION)
            .addTopping(PEPPER)
            .addTopping(SAUSAGE)
            .build();
        
        System.out.println("Code:");
        System.out.println("NyPizza largePizza = new NyPizza.Builder(LARGE)");
        System.out.println("    .addTopping(HAM)");
        System.out.println("    .addTopping(MUSHROOM)");
        System.out.println("    .addTopping(ONION)");
        System.out.println("    .addTopping(PEPPER)");
        System.out.println("    .addTopping(SAUSAGE)");
        System.out.println("    .build();");
        System.out.println();
        System.out.println("Result: " + largePizza);
        System.out.println();
        
        // Example 4: Calzone without sauce inside
        System.out.println("=== Example 4: Calzone (Default) ===");
        Calzone calzoneDefault = new Calzone.Builder()
            .addTopping(MUSHROOM)
            .addTopping(PEPPER)
            .build();
        
        System.out.println("Code:");
        System.out.println("Calzone calzone = new Calzone.Builder()");
        System.out.println("    .addTopping(MUSHROOM)");
        System.out.println("    .addTopping(PEPPER)");
        System.out.println("    .build();");
        System.out.println();
        System.out.println("Result: " + calzoneDefault);
        System.out.println("Note: sauceInside defaults to false");
        System.out.println();
        
        // Demonstrate method chaining works across hierarchy
        System.out.println("=== Method Chaining Across Hierarchy ===");
        System.out.println("The addTopping() method is defined in Pizza.Builder,");
        System.out.println("but works seamlessly with subclass builders:");
        System.out.println();
        
        NyPizza mediumPizza = new NyPizza.Builder(NyPizza.Size.MEDIUM)
            .addTopping(HAM)      // Method from Pizza.Builder
            .addTopping(ONION)    // Method from Pizza.Builder
            .build();              // Returns NyPizza (covariant return)
        
        System.out.println("NyPizza.Builder extends Pizza.Builder<Builder>");
        System.out.println("  -> Can call addTopping() (inherited)");
        System.out.println("  -> build() returns NyPizza (not Pizza)");
        System.out.println("Result: " + mediumPizza);
        System.out.println();
        
        System.out.println("=== Advantages of Hierarchical Builders ===");
        System.out.println("1. Type safety - no casts needed");
        System.out.println("2. Method chaining works in subclasses");
        System.out.println("3. Code reuse - common methods in base builder");
        System.out.println("4. Flexibility - each subclass can add its own methods");
        System.out.println("5. Immutability - all classes remain immutable");
    }
}

