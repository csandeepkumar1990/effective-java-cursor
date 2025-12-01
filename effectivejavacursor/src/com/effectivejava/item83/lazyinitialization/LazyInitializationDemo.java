package com.effectivejava.item83.lazyinitialization;

/**
 * Demonstration of Item 83: Use lazy initialization judiciously.
 */
public class LazyInitializationDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 83: Use Lazy Initialization Judiciously ===\n");
        
        System.out.println("1. LAZY INITIALIZATION:");
        System.out.println("   Delaying initialization until field is needed");
        System.out.println();
        
        System.out.println("2. WHEN TO USE:");
        System.out.println("   - Field is expensive to initialize");
        System.out.println("   - Field is rarely used");
        System.out.println("   - Initialization has side effects");
        System.out.println();
        
        System.out.println("3. WHEN NOT TO USE:");
        System.out.println("   - Normal initialization is preferred");
        System.out.println("   - Field is used in most cases");
        System.out.println("   - Initialization is cheap");
        System.out.println();
        
        System.out.println("4. PATTERNS:");
        System.out.println("   - Synchronized: Simple but slower");
        System.out.println("   - Double-check: Faster after first init");
        System.out.println("   - Holder class: For static fields");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use lazy initialization only when needed");
        System.out.println("2. Prefer normal initialization in most cases");
        System.out.println("3. Use double-check idiom for performance");
        System.out.println("4. Use holder class idiom for static fields");
    }
}

