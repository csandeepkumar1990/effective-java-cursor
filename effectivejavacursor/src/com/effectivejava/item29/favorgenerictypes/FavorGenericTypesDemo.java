package com.effectivejava.item29.favorgenerictypes;

/**
 * Demonstration of Item 29: Favor generic types.
 */
public class FavorGenericTypesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 29: Favor Generic Types ===\n");
        
        System.out.println("1. STEPS TO MAKE A CLASS GENERIC:");
        System.out.println("   1. Add type parameters to class declaration");
        System.out.println("   2. Replace Object with type parameter");
        System.out.println("   3. Fix any compilation errors");
        System.out.println();
        
        Stack<String> stack = new Stack<>();
        stack.push("first");
        stack.push("second");
        stack.push("third");
        
        System.out.println("2. EXAMPLE:");
        System.out.println("   Stack<String> stack = new Stack<>();");
        System.out.println("   stack.push(\"first\");");
        System.out.println("   String item = stack.pop();  // Type-safe!");
        System.out.println();
        
        while (!stack.isEmpty()) {
            System.out.println("   Popped: " + stack.pop());
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Make classes generic when they can be parameterized");
        System.out.println("2. Generic types are safer and easier to use");
        System.out.println("3. Use @SuppressWarnings when necessary casts are safe");
        System.out.println("4. Prefer generic types to raw types");
    }
}

