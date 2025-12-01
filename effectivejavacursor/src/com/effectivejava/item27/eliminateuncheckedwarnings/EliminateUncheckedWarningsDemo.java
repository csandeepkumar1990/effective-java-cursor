package com.effectivejava.item27.eliminateuncheckedwarnings;

import java.util.Set;

/**
 * Demonstration of Item 27: Eliminate unchecked warnings.
 */
public class EliminateUncheckedWarningsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 27: Eliminate Unchecked Warnings ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Eliminate every unchecked warning that you can.");
        System.out.println();
        
        System.out.println("2. IF YOU CAN'T ELIMINATE:");
        System.out.println("   - Prove that the code is typesafe");
        System.out.println("   - Suppress the warning with @SuppressWarnings(\"unchecked\")");
        System.out.println("   - Add a comment explaining why it's safe");
        System.out.println();
        
        System.out.println("3. BEST PRACTICES:");
        System.out.println("   - Use @SuppressWarnings on the smallest scope possible");
        System.out.println("   - Never suppress on entire classes");
        System.out.println("   - Always document why suppression is safe");
        System.out.println();
        
        Set<String> set = UncheckedWarnings.createSetGood();
        set.add("test");
        System.out.println("   Example: Set<String> set = createSetGood();");
        System.out.println("   (No warnings, type-safe)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Eliminate all unchecked warnings if possible");
        System.out.println("2. If you must suppress, prove the code is safe");
        System.out.println("3. Use @SuppressWarnings on smallest scope");
        System.out.println("4. Always document why suppression is safe");
    }
}

