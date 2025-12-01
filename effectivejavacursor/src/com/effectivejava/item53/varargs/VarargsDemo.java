package com.effectivejava.item53.varargs;

/**
 * Demonstration of Item 53: Use varargs judiciously.
 */
public class VarargsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 53: Use Varargs Judiciously ===\n");
        
        System.out.println("1. VARARGS:");
        System.out.println("   Convenient but have performance implications");
        System.out.println("   Creates an array on every call");
        System.out.println();
        
        System.out.println("2. WHEN TO USE:");
        System.out.println("   - You truly need variable number of arguments");
        System.out.println("   - Method is called infrequently");
        System.out.println();
        
        System.out.println("3. WHEN NOT TO USE:");
        System.out.println("   - Performance is critical");
        System.out.println("   - Most calls have 0-3 arguments");
        System.out.println("   - Use overloading for common cases");
        System.out.println();
        
        System.out.println("4. BEST PRACTICE:");
        System.out.println("   Overload for common cases (0-3 args)");
        System.out.println("   Use varargs only for 4+ arguments");
        System.out.println();
        
        System.out.println("   sum() = " + VarargsExample.sum());
        System.out.println("   sum(1) = " + VarargsExample.sum(1));
        System.out.println("   sum(1, 2) = " + VarargsExample.sum(1, 2));
        System.out.println("   sum(1, 2, 3, 4, 5) = " + VarargsExample.sum(1, 2, 3, 4, 5));
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use varargs judiciously");
        System.out.println("2. Overload for common cases");
        System.out.println("3. Varargs create arrays - consider performance");
        System.out.println("4. Use when truly needed for flexibility");
    }
}

