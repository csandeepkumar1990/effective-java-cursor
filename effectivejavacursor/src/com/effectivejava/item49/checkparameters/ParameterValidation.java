package com.effectivejava.item49.checkparameters;

import java.math.BigInteger;
import java.util.Objects;

/**
 * Item 49: Check parameters for validity.
 * 
 * Always validate parameters at the beginning of methods.
 * 
 * Use:
 * - Objects.requireNonNull() for null checks
 * - assert for internal invariants
 * - @throws in JavaDoc
 * - IllegalArgumentException for invalid values
 */
public class ParameterValidation {
    
    /**
     * GOOD: Validates parameters.
     */
    public static BigInteger mod(BigInteger m, BigInteger n) {
        if (m == null) {
            throw new NullPointerException("m cannot be null");
        }
        if (n == null) {
            throw new NullPointerException("n cannot be null");
        }
        if (n.signum() <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        return m.mod(n);
    }
    
    /**
     * BETTER: Using Objects.requireNonNull().
     */
    public static BigInteger modBetter(BigInteger m, BigInteger n) {
        Objects.requireNonNull(m, "m cannot be null");
        Objects.requireNonNull(n, "n cannot be null");
        if (n.signum() <= 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        return m.mod(n);
    }
    
    /**
     * Using assertions for internal invariants.
     * Assertions are disabled by default - use for internal checks only.
     */
    private static void sort(long a[], int offset, int length) {
        assert a != null;
        assert offset >= 0 && offset <= a.length;
        assert length >= 0 && length <= a.length - offset;
        // Implementation
    }
}

