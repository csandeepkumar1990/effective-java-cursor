package com.effectivejava.item32.combinegenericsvarargs;

/**
 * Demonstration of Item 32: Combine generics and varargs judiciously.
 */
public class CombineGenericsVarargsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 32: Combine Generics and Varargs Judiciously ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   Varargs and generics don't mix well");
        System.out.println("   - Varargs creates an array");
        System.out.println("   - Arrays and generics don't mix");
        System.out.println("   - Can cause heap pollution");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   - Use @SafeVarargs when method is actually safe");
        System.out.println("   - Method must not store anything in varargs array");
        System.out.println("   - Only read from varargs array");
        System.out.println();
        
        System.out.println("3. ALTERNATIVE:");
        System.out.println("   Use List instead of varargs");
        System.out.println("   This avoids the problem entirely");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Varargs and generics don't mix well");
        System.out.println("2. Use @SafeVarargs only when method is actually safe");
        System.out.println("3. Consider using List instead of varargs");
        System.out.println("4. @SafeVarargs can only be used on final or static methods");
    }
}

