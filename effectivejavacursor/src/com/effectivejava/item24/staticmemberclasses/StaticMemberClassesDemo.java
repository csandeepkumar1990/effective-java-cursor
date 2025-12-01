package com.effectivejava.item24.staticmemberclasses;

/**
 * Demonstration of Item 24: Favor static member classes over nonstatic.
 */
public class StaticMemberClassesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 24: Favor Static Member Classes ===\n");
        
        System.out.println("1. TYPES OF NESTED CLASSES:");
        System.out.println("   - Static member class (preferred)");
        System.out.println("   - Nonstatic member class");
        System.out.println("   - Anonymous class");
        System.out.println("   - Local class");
        System.out.println();
        
        System.out.println("2. STATIC MEMBER CLASS:");
        System.out.println("   Use when the nested class doesn't need access to enclosing instance");
        System.out.println("   Advantages:");
        System.out.println("   - More efficient (no reference to enclosing instance)");
        System.out.println("   - Can be instantiated without enclosing instance");
        System.out.println("   - Clearer intent");
        System.out.println();
        
        // Static member class example
        Calculator.Operation op = new Calculator.Operation("add", 10.0);
        System.out.println("   Example: new Calculator.Operation(\"add\", 10.0)");
        System.out.println("   Result: " + op.getName() + " = " + op.getResult());
        System.out.println();
        
        System.out.println("3. NONSTATIC MEMBER CLASS:");
        System.out.println("   Use when you need access to the enclosing instance");
        System.out.println("   Example: Iterator implementation");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer static member classes");
        System.out.println("2. Use nonstatic only when you need enclosing instance");
        System.out.println("3. Static classes are more efficient");
        System.out.println("4. Static classes can be instantiated independently");
    }
}

