package com.effectivejava.item6.avoidunnecessaryobjects;

import java.util.Date;

/**
 * Demonstration of Item 6: Avoid creating unnecessary objects.
 * 
 * This demo shows:
 * 1. String literal reuse
 * 2. Reusing expensive objects (Pattern compilation)
 * 3. Autoboxing pitfalls
 * 4. Static factory methods vs constructors
 * 5. When object reuse is appropriate
 */
public class AvoidUnnecessaryObjectsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 6: Avoid Creating Unnecessary Objects ===\n");
        
        // String literal reuse
        System.out.println("1. STRING LITERAL REUSE:");
        String s1 = "bikini";
        String s2 = "bikini";
        String s3 = new String("bikini");  // BAD: Creates new object
        System.out.println("   String s1 = \"bikini\";");
        System.out.println("   String s2 = \"bikini\";");
        System.out.println("   String s3 = new String(\"bikini\");  // BAD!");
        System.out.println("   s1 == s2: " + (s1 == s2) + " (same object - string literal pool)");
        System.out.println("   s1 == s3: " + (s1 == s3) + " (different objects)");
        System.out.println("   Always use string literals, never new String(\"literal\")");
        System.out.println();
        
        // Pattern reuse
        System.out.println("2. REUSING EXPENSIVE OBJECTS (Pattern):");
        System.out.println("   BAD: s.matches(regex) - compiles pattern every time");
        System.out.println("   GOOD: Pre-compile pattern and reuse");
        System.out.println();
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            StringExample.isRomanNumeralBad("MCMLXXVI");
        }
        long badTime = System.currentTimeMillis() - start;
        
        start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            StringExample.isRomanNumeralGood("MCMLXXVI");
        }
        long goodTime = System.currentTimeMillis() - start;
        
        System.out.println("   Bad approach (10000 calls): " + badTime + " ms");
        System.out.println("   Good approach (10000 calls): " + goodTime + " ms");
        System.out.println("   Improvement: " + (badTime / (double) goodTime) + "x faster");
        System.out.println();
        
        // Autoboxing
        System.out.println("3. AUTOBOXING PITFALLS:");
        System.out.println("   BAD: Long sum = 0L;  // Boxed primitive");
        System.out.println("        sum += i;  // Creates new Long object each time");
        System.out.println();
        System.out.println("   GOOD: long sum = 0L;  // Primitive");
        System.out.println("         sum += i;  // No object creation");
        System.out.println();
        System.out.println("   Prefer primitives to boxed primitives");
        System.out.println("   Watch out for unintentional autoboxing in loops");
        System.out.println();
        
        // Static factory methods
        System.out.println("4. STATIC FACTORY METHODS VS CONSTRUCTORS:");
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf(true);
        // NOTE: Boolean(boolean) constructor is deprecated, but used here for illustration
        @SuppressWarnings("deprecation")
        Boolean b3 = new Boolean(true);
        @SuppressWarnings("deprecation")
        Boolean b4 = new Boolean(true);
        Boolean b5 = Boolean.TRUE;  // The cached constant
        
        System.out.println("   Boolean.valueOf(true) - reuses cached instance");
        System.out.println("   new Boolean(true) - always creates new instance");
        System.out.println("   Boolean.valueOf(true) == Boolean.valueOf(true): " + (b1 == b2) + " (same cached object)");
        System.out.println("   Boolean.valueOf(true) == Boolean.TRUE: " + (b1 == b5) + " (same cached object)");
        System.out.println("   new Boolean(true) == new Boolean(true): " + (b3 == b4) + " (different objects)");
        System.out.println("   Boolean.valueOf(true) == new Boolean(true): " + (b1 == b3) + " (different objects)");
        System.out.println("   Prefer static factory methods when available");
        System.out.println();
        
        // Baby boomer example
        System.out.println("5. REUSING EXPENSIVE OBJECTS (Calendar/Date):");
        // NOTE: Date(int, int, int) constructor is deprecated, but used here for illustration
        @SuppressWarnings("deprecation")
        Date birthDate = new Date(50, 0, 1); // 1950-01-01
        Person person = new Person(birthDate);
        System.out.println("   BAD: Creates Calendar and Date objects on every call");
        System.out.println("   GOOD: Creates once, reuses for all calls");
        System.out.println("   isBabyBoomerGood(): " + person.isBabyBoomerGood());
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't create a new object when you can reuse an existing one");
        System.out.println("2. Reuse immutable objects (String, Pattern, etc.)");
        System.out.println("3. Prefer primitives to boxed primitives");
        System.out.println("4. Use static factory methods instead of constructors");
        System.out.println("5. Cache expensive objects (Pattern, Calendar, etc.)");
        System.out.println("6. BUT: Don't avoid object creation when clarity/simplicity is more important");
        System.out.println("7. Modern JVMs are good at eliminating unnecessary object creation");
        System.out.println("   (but it's still good practice to avoid it)");
    }
}

