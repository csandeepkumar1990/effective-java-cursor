package com.effectivejava.item38.extensibleenums;

/**
 * Demonstration of Item 38: Emulate extensible enums with interfaces.
 */
public class ExtensibleEnumsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 38: Emulate Extensible Enums with Interfaces ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   Enums can't be extended");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   Use interfaces to emulate extensibility");
        System.out.println("   - Define an interface for the operations");
        System.out.println("   - Have enums implement the interface");
        System.out.println("   - Can add new enums implementing the interface");
        System.out.println();
        
        double x = 10;
        double y = 3;
        
        System.out.println("3. BASIC OPERATIONS:");
        for (BasicOperation op : BasicOperation.values()) {
            System.out.printf("   %f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
        System.out.println();
        
        System.out.println("4. EXTENDED OPERATIONS:");
        for (ExtendedOperation op : ExtendedOperation.values()) {
            System.out.printf("   %f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Enums can't be extended, but interfaces can");
        System.out.println("2. Use interfaces to emulate extensible enums");
        System.out.println("3. Multiple enums can implement the same interface");
        System.out.println("4. This allows adding new operations without modifying existing code");
    }
}

