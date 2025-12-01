package com.effectivejava.item40.useoverride;

/**
 * Demonstration of Item 40: Consistently use the Override annotation.
 */
public class UseOverrideDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 40: Consistently Use the Override Annotation ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Use @Override annotation on every method");
        System.out.println("   that you believe to override a supertype declaration.");
        System.out.println();
        
        System.out.println("2. PROBLEM WITHOUT @Override:");
        System.out.println("   Typos in method names aren't caught");
        System.out.println("   Example: equals(Bigram) instead of equals(Object)");
        System.out.println("   This creates a new method instead of overriding!");
        System.out.println();
        
        System.out.println("3. SOLUTION:");
        System.out.println("   Always use @Override when overriding methods");
        System.out.println("   Compiler will catch errors if method doesn't override");
        System.out.println();
        
        Bigram.demonstrate();
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use @Override on every overriding method");
        System.out.println("2. Compiler will catch errors if method doesn't override");
        System.out.println("3. Prevents typos and mistakes");
        System.out.println("4. Exception: Don't use on methods implementing interfaces (Java 8+)");
    }
}

