package com.effectivejava.item11.overridehashcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Demonstration of Item 11: Always override hashCode when you override equals.
 * 
 * This demo shows:
 * 1. The hashCode contract
 * 2. What happens when hashCode is not overridden
 * 3. Proper hashCode implementation
 * 4. Performance implications
 */
public class HashCodeDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 11: Always Override hashCode ===\n");
        
        System.out.println("1. THE HASHCODE CONTRACT:");
        System.out.println("   - Consistent: multiple calls return same value (if object unchanged)");
        System.out.println("   - If x.equals(y), then x.hashCode() == y.hashCode()");
        System.out.println("   - If !x.equals(y), hashCode can be same or different");
        System.out.println("     (but different is better for performance)");
        System.out.println();
        
        // Good hashCode
        System.out.println("2. PROPER HASHCODE IMPLEMENTATION:");
        PhoneNumberWithHashCode pn1 = new PhoneNumberWithHashCode(707, 867, 5309);
        PhoneNumberWithHashCode pn2 = new PhoneNumberWithHashCode(707, 867, 5309);
        
        System.out.println("   pn1.equals(pn2): " + pn1.equals(pn2));
        System.out.println("   pn1.hashCode(): " + pn1.hashCode());
        System.out.println("   pn2.hashCode(): " + pn2.hashCode());
        System.out.println("   Hash codes are equal: " + (pn1.hashCode() == pn2.hashCode()));
        System.out.println();
        
        // Using in HashMap
        System.out.println("3. USING IN HASH-BASED COLLECTIONS:");
        Map<PhoneNumberWithHashCode, String> phoneBook = new HashMap<>();
        phoneBook.put(pn1, "Jenny");
        System.out.println("   phoneBook.put(pn1, \"Jenny\")");
        System.out.println("   phoneBook.get(pn2): " + phoneBook.get(pn2));
        System.out.println("   (Works correctly because hashCode is properly implemented)");
        System.out.println();
        
        // Bad hashCode example
        System.out.println("4. PROBLEM WITHOUT HASHCODE:");
        System.out.println("   If hashCode is not overridden:");
        System.out.println("   - Equal objects may have different hash codes");
        System.out.println("   - Hash-based collections won't work correctly");
        System.out.println("   - Objects may be stored in wrong buckets");
        System.out.println("   - Lookups may fail even for equal objects");
        System.out.println();
        
        // Recipe
        System.out.println("5. RECIPE FOR HASHCODE:");
        System.out.println("   1. Declare int variable named result, initialize to hash code c1");
        System.out.println("   2. For each remaining field f:");
        System.out.println("      a. Compute hash code c for the field");
        System.out.println("      b. Combine: result = 31 * result + c");
        System.out.println("   3. Return result");
        System.out.println();
        System.out.println("   Why 31?");
        System.out.println("   - It's an odd prime");
        System.out.println("   - 31 * i == (i << 5) - i (optimized by VM)");
        System.out.println("   - Good distribution properties");
        System.out.println();
        
        // Performance
        System.out.println("6. PERFORMANCE CONSIDERATIONS:");
        System.out.println("   - Exclude fields that are not used in equals()");
        System.out.println("   - Don't be too clever (don't try to exclude significant fields)");
        System.out.println("   - Use Objects.hash() for simple cases (but it's slower)");
        System.out.println("   - For immutable objects, consider caching hashCode");
        System.out.println();
        
        // Consistent
        System.out.println("7. CONSISTENCY TEST:");
        System.out.println("   Multiple calls to hashCode():");
        for (int i = 0; i < 5; i++) {
            System.out.println("   Call " + (i + 1) + ": " + pn1.hashCode());
        }
        System.out.println("   (All calls return the same value)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always override hashCode when you override equals");
        System.out.println("2. Follow the hashCode contract");
        System.out.println("3. Use the recipe: result = 31 * result + c");
        System.out.println("4. Exclude fields not used in equals()");
        System.out.println("5. Don't be too clever - keep it simple");
        System.out.println("6. Consider caching hashCode for immutable objects");
    }
}

