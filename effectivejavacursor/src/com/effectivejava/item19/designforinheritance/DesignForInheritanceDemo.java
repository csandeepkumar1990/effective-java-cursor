package com.effectivejava.item19.designforinheritance;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Demonstration of Item 19: Design and document for inheritance or else prohibit it.
 */
public class DesignForInheritanceDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 19: Design and Document for Inheritance ===\n");
        
        System.out.println("1. RULES FOR DESIGNING FOR INHERITANCE:");
        System.out.println("   - Document all self-use patterns");
        System.out.println("   - Document which methods call overridable methods");
        System.out.println("   - Use @implSpec tag in JavaDoc");
        System.out.println("   - Provide hook methods for subclasses");
        System.out.println("   - Never invoke overridable methods from constructors");
        System.out.println("   - Consider making the class final");
        System.out.println();
        
        System.out.println("2. PROBLEM: Undocumented self-use");
        System.out.println("   If a class doesn't document self-use patterns,");
        System.out.println("   subclasses may break when the superclass changes.");
        System.out.println();
        
        System.out.println("3. SOLUTION: Document with @implSpec");
        System.out.println("   /**");
        System.out.println("    * @implSpec");
        System.out.println("    * This implementation calls add() for each element.");
        System.out.println("    */");
        System.out.println();
        
        System.out.println("4. HOOK METHODS:");
        System.out.println("   Provide protected hook methods that subclasses can override");
        System.out.println("   without affecting the main algorithm.");
        System.out.println();
        
        System.out.println("5. CONSTRUCTOR RULE:");
        System.out.println("   Never invoke overridable methods from constructors.");
        System.out.println("   The subclass's override will run before the subclass");
        System.out.println("   constructor completes, leading to bugs.");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Design for inheritance from the start, or prohibit it");
        System.out.println("2. Document all self-use patterns with @implSpec");
        System.out.println("3. Provide hook methods for extensibility");
        System.out.println("4. Never call overridable methods from constructors");
        System.out.println("5. Consider making classes final if not designed for inheritance");
        System.out.println("6. Test inheritance by writing subclasses");
    }
}

