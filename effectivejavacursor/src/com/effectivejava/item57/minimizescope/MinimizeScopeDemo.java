package com.effectivejava.item57.minimizescope;

import java.util.Arrays;
import java.util.List;

/**
 * Demonstration of Item 57: Minimize the scope of local variables.
 */
public class MinimizeScopeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 57: Minimize the Scope of Local Variables ===\n");
        
        System.out.println("1. BEST PRACTICES:");
        System.out.println("   - Declare variables where they're first used");
        System.out.println("   - Initialize variables when declared");
        System.out.println("   - Prefer for loops to while loops");
        System.out.println("   - Keep methods small and focused");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Reduces bugs");
        System.out.println("   - Improves readability");
        System.out.println("   - Makes code easier to maintain");
        System.out.println();
        
        List<String> list = Arrays.asList("a", "b", "c");
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: Iterator declared too early");
        System.out.println("   GOOD: Declared in for loop");
        System.out.println("   BEST: Enhanced for loop");
        System.out.println();
        
        for (String element : list) {
            System.out.println("   Element: " + element);
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Declare variables where first used");
        System.out.println("2. Initialize when declared");
        System.out.println("3. Minimize scope to reduce bugs");
        System.out.println("4. Prefer for loops to while loops");
    }
}

