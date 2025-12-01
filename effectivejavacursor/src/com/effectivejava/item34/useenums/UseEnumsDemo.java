package com.effectivejava.item34.useenums;

/**
 * Demonstration of Item 34: Use enums instead of int constants.
 */
public class UseEnumsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 34: Use Enums Instead of Int Constants ===\n");
        
        System.out.println("1. ADVANTAGES OF ENUMS:");
        System.out.println("   - Type-safe");
        System.out.println("   - Compile-time checking");
        System.out.println("   - Can have methods and fields");
        System.out.println("   - Can implement interfaces");
        System.out.println("   - Can be used in switch statements");
        System.out.println();
        
        System.out.println("2. ENUM WITH DATA:");
        double earthWeight = 175;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("   Weight on %s is %f%n", p, p.surfaceWeight(mass));
        }
        System.out.println();
        
        System.out.println("3. ENUM WITH BEHAVIOR:");
        double x = 10;
        double y = 5;
        for (Operation op : Operation.values()) {
            System.out.printf("   %f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use enums instead of int constants");
        System.out.println("2. Enums are type-safe and more powerful");
        System.out.println("3. Can add data and behavior to enums");
        System.out.println("4. Use constant-specific method implementations when needed");
    }
}

