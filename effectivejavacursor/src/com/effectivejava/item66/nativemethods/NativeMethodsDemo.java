package com.effectivejava.item66.nativemethods;

/**
 * Demonstration of Item 66: Use native methods judiciously.
 */
public class NativeMethodsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 66: Use Native Methods Judiciously ===\n");
        
        System.out.println("1. NATIVE METHODS (JNI) DISADVANTAGES:");
        System.out.println("   - Not portable");
        System.out.println("   - Hard to debug");
        System.out.println("   - Performance overhead (JNI boundary crossing)");
        System.out.println("   - Security risks");
        System.out.println("   - Hard to maintain");
        System.out.println();
        
        System.out.println("2. WHEN TO USE:");
        System.out.println("   - Accessing platform-specific features");
        System.out.println("   - Accessing legacy code");
        System.out.println("   - Performance-critical code (but measure first!)");
        System.out.println();
        
        System.out.println("3. MODERN ALTERNATIVES:");
        System.out.println("   - Java API covers most use cases");
        System.out.println("   - Better performance in many cases");
        System.out.println("   - More portable and maintainable");
        System.out.println();
        
        System.out.println("4. BEST PRACTICE:");
        System.out.println("   Avoid native methods unless absolutely necessary");
        System.out.println("   Modern Java is fast enough for most cases");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Avoid native methods unless necessary");
        System.out.println("2. Modern Java has better alternatives");
        System.out.println("3. Native methods have many disadvantages");
        System.out.println("4. Use only for platform-specific or legacy code");
    }
}

