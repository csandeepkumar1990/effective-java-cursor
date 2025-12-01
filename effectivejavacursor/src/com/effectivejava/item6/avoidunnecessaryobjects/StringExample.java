package com.effectivejava.item6.avoidunnecessaryobjects;

/**
 * Item 6: Avoid creating unnecessary objects.
 * 
 * This class demonstrates common mistakes that create unnecessary objects
 * and how to avoid them.
 */
public class StringExample {
    
    /**
     * BAD: Creates a new String object every time it's called.
     * String("bikini") creates a new instance even though "bikini" is a string literal.
     */
    public static boolean isRomanNumeralBad(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
    
    /**
     * GOOD: Reuses the compiled Pattern object.
     * Pattern.compile() is expensive, so we compile once and reuse.
     */
    private static final java.util.regex.Pattern ROMAN = 
        java.util.regex.Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    
    public static boolean isRomanNumeralGood(String s) {
        return ROMAN.matcher(s).matches();
    }
    
    /**
     * BAD: Autoboxing creates unnecessary Integer objects.
     * This creates a new Integer object for every iteration.
     */
    public static long sumBad() {
        Long sum = 0L;  // Should be long, not Long
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // Autoboxing: creates new Long object each time
        }
        return sum;
    }
    
    /**
     * GOOD: Uses primitive long, avoiding autoboxing.
     * Much faster and uses less memory.
     */
    public static long sumGood() {
        long sum = 0L;  // Primitive, not boxed
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;  // No autoboxing
        }
        return sum;
    }
}

