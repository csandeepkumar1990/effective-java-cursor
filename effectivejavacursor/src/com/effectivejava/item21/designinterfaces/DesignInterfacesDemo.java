package com.effectivejava.item21.designinterfaces;

/**
 * Demonstration of Item 21: Design interfaces for posterity.
 */
public class DesignInterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 21: Design Interfaces for Posterity ===\n");
        
        System.out.println("1. PROBLEM: Adding methods to existing interfaces");
        System.out.println("   If you add a method to an interface, all existing");
        System.out.println("   implementations must be updated or they will break.");
        System.out.println();
        
        System.out.println("2. SOLUTION: Default methods (Java 8+)");
        System.out.println("   Default methods allow adding methods to interfaces");
        System.out.println("   without breaking existing implementations.");
        System.out.println();
        
        System.out.println("3. BEST PRACTICES:");
        System.out.println("   - Design interfaces carefully from the start");
        System.out.println("   - Use default methods sparingly");
        System.out.println("   - Document default method implementations with @implSpec");
        System.out.println("   - Consider providing skeletal implementations");
        System.out.println();
        
        System.out.println("4. WHEN TO USE DEFAULT METHODS:");
        System.out.println("   - To add convenience methods");
        System.out.println("   - To evolve interfaces over time");
        System.out.println("   - When the default implementation is reasonable for most cases");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Design interfaces carefully - they are hard to change");
        System.out.println("2. Use default methods to evolve interfaces");
        System.out.println("3. Document default implementations with @implSpec");
        System.out.println("4. Consider providing skeletal implementations");
        System.out.println("5. Test interfaces by writing multiple implementations");
    }
}

