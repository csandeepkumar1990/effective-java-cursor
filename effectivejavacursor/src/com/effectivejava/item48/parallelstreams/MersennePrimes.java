package com.effectivejava.item48.parallelstreams;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * Item 48: Use caution when making streams parallel.
 * 
 * Parallel streams can improve performance, but:
 * - Only use when you have a large amount of data
 * - Operations must be independent
 * - Must be thread-safe
 * - Overhead can outweigh benefits
 * 
 * Use parallel streams when:
 * - Large datasets
 * - CPU-intensive operations
 * - Independent operations
 * - No shared mutable state
 */
public class MersennePrimes {
    
    /**
     * Sequential stream - safe and predictable.
     */
    public static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
    
    /**
     * Parallel stream - use with caution!
     * Only use when you have large datasets and independent operations.
     */
    public static Stream<BigInteger> primesParallel() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime)
            .parallel();  // May not improve performance!
    }
    
    /**
     * Example: Finding Mersenne primes.
     * Sequential is often better for this.
     */
    public static void findMersennePrimes() {
        primes()
            .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
            .filter(mersenne -> mersenne.isProbablePrime(50))
            .limit(20)
            .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }
}

