package com.effectivejava.item56.doccomments;

/**
 * Item 56: Write doc comments for all exposed API elements.
 * 
 * Every exported class, interface, constructor, method, and field
 * should have a doc comment.
 * 
 * JavaDoc conventions:
 * - Summary sentence (first sentence)
 * - Detailed description
 * - @param for parameters
 * - @return for return values
 * - @throws for exceptions
 * - @since for version
 * - @see for references
 */
public class MathUtils {
    
    /**
     * Returns the greatest common divisor of two integers.
     * 
     * <p>This method uses the Euclidean algorithm to compute the GCD.
     * The algorithm is efficient and works for both positive and negative
     * integers, returning the absolute value of the GCD.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor of {@code a} and {@code b}
     * @throws ArithmeticException if both arguments are zero
     * @since 1.0
     * @see <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">Euclidean Algorithm</a>
     */
    public static int gcd(int a, int b) {
        if (a == 0 && b == 0) {
            throw new ArithmeticException("GCD of (0, 0) is undefined");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    /**
     * Calculates the factorial of a non-negative integer.
     * 
     * <p>The factorial of n (denoted as n!) is the product of all positive
     * integers less than or equal to n. For example, 5! = 5 × 4 × 3 × 2 × 1 = 120.
     * 
     * <p><b>Note:</b> This method may overflow for large values of n.
     * Consider using {@link java.math.BigInteger} for larger factorials.
     * 
     * @param n the non-negative integer
     * @return the factorial of {@code n}
     * @throws IllegalArgumentException if {@code n} is negative
     * @since 1.0
     */
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative: " + n);
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}

