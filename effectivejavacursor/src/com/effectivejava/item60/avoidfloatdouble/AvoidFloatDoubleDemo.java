package com.effectivejava.item60.avoidfloatdouble;

/**
 * Demonstration of Item 60: Avoid float and double if exact answers required.
 */
public class AvoidFloatDoubleDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 60: Avoid float and double ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   float and double use binary floating-point");
        System.out.println("   They cannot represent many decimal values exactly");
        System.out.println();
        
        System.out.println("2. EXAMPLE:");
        Money.badMoneyExample();
        System.out.println();
        Money.goodMoneyExample();
        System.out.println();
        Money.centsExample();
        System.out.println();
        
        System.out.println("3. WHEN TO USE float/double:");
        System.out.println("   - Performance is critical");
        System.out.println("   - Exact precision isn't required");
        System.out.println("   - Scientific calculations");
        System.out.println();
        
        System.out.println("4. WHEN TO USE BigDecimal:");
        System.out.println("   - Money calculations");
        System.out.println("   - Exact decimal precision required");
        System.out.println("   - Financial applications");
        System.out.println();
        
        System.out.println("5. ALTERNATIVE:");
        System.out.println("   Use int or long for cents (more efficient)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't use float/double for money");
        System.out.println("2. Use BigDecimal for exact decimal calculations");
        System.out.println("3. Consider int/long for cents as alternative");
        System.out.println("4. float/double are fine for scientific calculations");
    }
}

