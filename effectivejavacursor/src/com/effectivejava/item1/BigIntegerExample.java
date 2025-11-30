package com.effectivejava.item1;

import java.util.Random;

/**
 * Example demonstrating the advantage of named static factory methods.
 * 
 * This shows how a static factory method with a descriptive name is clearer
 * than a constructor with parameters that don't clearly describe what they do.
 * 
 * The BigInteger.probablePrime example from the book:
 * - Constructor: BigInteger(int, int, Random) - unclear what the parameters mean
 * - Static factory: BigInteger.probablePrime(int, Random) - clearly indicates it returns a probable prime
 */
public class BigIntegerExample {
    private final int value;
    private final boolean isProbablePrime;
    
    // Static factory method with a descriptive name - much clearer!
    // BigInteger.probablePrime(int bitLength, Random rnd)
    public static BigIntegerExample probablePrime(int bitLength, Random random) {
        // Default certainty is typically used
        int defaultCertainty = 100;
        return new BigIntegerExample(bitLength, defaultCertainty, random);
    }
    
    // Another example: creating from a string representation
    // Constructor: BigInteger(String val) - clear enough
    // But what if we want to parse from different bases?
    
    // Static factory with descriptive name for base conversion
    public static BigIntegerExample fromString(String value, int radix) {
        // Implementation would parse the string with the given radix
        return new BigIntegerExample(Integer.parseInt(value, radix));
    }
    
    // Private constructor for internal use
    private BigIntegerExample(int value) {
        this.value = value;
        this.isProbablePrime = false;
    }
    
    // Private constructor for internal use
    private BigIntegerExample(int bitLength, int certainty, Random random) {
        this.value = generateProbablePrime(bitLength, certainty, random);
        this.isProbablePrime = true;
    }
    
    private static int generateProbablePrime(int bitLength, int certainty, Random random) {
        // Simplified implementation - just return a random number in the range
        int min = (int) Math.pow(2, bitLength - 1);
        int max = (int) Math.pow(2, bitLength) - 1;
        return min + random.nextInt(max - min + 1);
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isProbablePrime() {
        return isProbablePrime;
    }
    
    @Override
    public String toString() {
        return String.format("BigIntegerExample(value=%d, isProbablePrime=%b)", value, isProbablePrime);
    }
    
    /**
     * Demonstration of the readability advantage.
     */
    public static void demonstrate() {
        Random random = new Random();
        
        System.out.println("=== Named Static Factory Methods vs Constructors ===\n");
        
        // Using constructor - unclear what the parameters mean
        System.out.println("1. Using Constructor (unclear):");
        BigIntegerExample num1 = new BigIntegerExample(10, 100, random);
        System.out.println("   new BigIntegerExample(10, 100, random)");
        System.out.println("   What do 10 and 100 mean? Is it bitLength and certainty?");
        System.out.println("   Result: " + num1);
        System.out.println();
        
        // Using static factory method - much clearer!
        System.out.println("2. Using Static Factory Method (clear):");
        BigIntegerExample num2 = BigIntegerExample.probablePrime(10, random);
        System.out.println("   BigIntegerExample.probablePrime(10, random)");
        System.out.println("   Clearly indicates: returns a probable prime with 10 bits");
        System.out.println("   Result: " + num2);
        System.out.println();
        
        // Another example with string parsing
        System.out.println("3. Another Example - String Parsing:");
        BigIntegerExample num3 = BigIntegerExample.fromString("FF", 16);
        System.out.println("   BigIntegerExample.fromString(\"FF\", 16)");
        System.out.println("   Clearly indicates: parse from string with radix 16");
        System.out.println("   Result: " + num3);
        System.out.println();
        
        System.out.println("Key Takeaway:");
        System.out.println("Static factory methods with descriptive names make code");
        System.out.println("more readable and self-documenting compared to constructors");
        System.out.println("with parameters that don't clearly describe their purpose.");
    }
}


