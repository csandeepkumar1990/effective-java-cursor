package com.effectivejava.item49.checkparameters;

import java.math.BigInteger;

/**
 * Demonstration of Item 49: Check parameters for validity.
 */
public class CheckParametersDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 49: Check Parameters for Validity ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Always validate parameters at the beginning of methods");
        System.out.println();
        
        System.out.println("2. METHODS:");
        System.out.println("   - Objects.requireNonNull() for null checks");
        System.out.println("   - assert for internal invariants");
        System.out.println("   - @throws in JavaDoc");
        System.out.println("   - IllegalArgumentException for invalid values");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        try {
            ParameterValidation.mod(BigInteger.valueOf(10), BigInteger.valueOf(3));
            System.out.println("   mod(10, 3) = valid");
        } catch (Exception e) {
            System.out.println("   Error: " + e.getMessage());
        }
        
        try {
            ParameterValidation.mod(null, BigInteger.valueOf(3));
        } catch (NullPointerException e) {
            System.out.println("   mod(null, 3) throws: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always validate parameters");
        System.out.println("2. Use Objects.requireNonNull() for null checks");
        System.out.println("3. Document parameter restrictions in JavaDoc");
        System.out.println("4. Fail fast - catch errors early");
    }
}

