package com.effectivejava.item36.useenumset;

import java.util.EnumSet;

/**
 * Demonstration of Item 36: Use EnumSet instead of bit fields.
 */
public class UseEnumSetDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 36: Use EnumSet Instead of Bit Fields ===\n");
        
        System.out.println("1. PROBLEM WITH BIT FIELDS:");
        System.out.println("   - Not type-safe");
        System.out.println("   - Hard to use");
        System.out.println("   - Limited to 32 or 64 flags");
        System.out.println();
        
        System.out.println("2. SOLUTION: EnumSet");
        System.out.println("   - Type-safe");
        System.out.println("   - More readable");
        System.out.println("   - More efficient than HashSet");
        System.out.println("   - Can be used in APIs that accept Set");
        System.out.println();
        
        EnumSet<Style> styles = EnumSet.of(Style.BOLD, Style.ITALIC);
        System.out.println("3. EXAMPLE:");
        System.out.println("   EnumSet<Style> styles = EnumSet.of(Style.BOLD, Style.ITALIC);");
        System.out.println("   styles: " + styles);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use EnumSet instead of bit fields");
        System.out.println("2. EnumSet is type-safe and efficient");
        System.out.println("3. Can be used anywhere a Set is expected");
    }
}

