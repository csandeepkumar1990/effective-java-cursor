package com.effectivejava.item69.useexceptions;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 69: Use exceptions only for exceptional conditions.
 */
public class UseExceptionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 69: Use Exceptions Only for Exceptional Conditions ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   DON'T use exceptions for control flow!");
        System.out.println();
        
        System.out.println("2. BAD: Using exception for control flow");
        System.out.println("   - Exceptions are slow");
        System.out.println("   - Hard to understand");
        System.out.println("   - Not designed for this purpose");
        System.out.println();
        
        System.out.println("3. GOOD: Normal control flow");
        System.out.println("   - Check conditions before operations");
        System.out.println("   - Use hasNext() instead of catching NoSuchElementException");
        System.out.println("   - Use size() checks instead of catching IndexOutOfBoundsException");
        System.out.println();
        
        List<String> list = Arrays.asList("a", "b", "c");
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   BAD: while(true) { try { list.get(i++) } catch(...) {} }");
        System.out.println("   GOOD: for (int i = 0; i < list.size(); i++)");
        System.out.println("   BEST: for (String item : list)");
        System.out.println();
        
        LoopExample.bestLoop(list);
        System.out.println("   (Using enhanced for loop - clean and efficient)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Exceptions are for exceptional conditions only");
        System.out.println("2. Don't use exceptions for control flow");
        System.out.println("3. Check conditions before operations");
        System.out.println("4. Exceptions have performance overhead");
    }
}

