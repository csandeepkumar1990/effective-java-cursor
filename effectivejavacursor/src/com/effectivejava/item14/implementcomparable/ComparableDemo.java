package com.effectivejava.item14.implementcomparable;

import java.util.*;

/**
 * Demonstration of Item 14: Consider implementing Comparable.
 */
public class ComparableDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 14: Consider Implementing Comparable ===\n");
        
        System.out.println("1. THE compareTo CONTRACT:");
        System.out.println("   - sgn(x.compareTo(y)) == -sgn(y.compareTo(x))");
        System.out.println("   - Transitive: if x.compareTo(y) > 0 && y.compareTo(z) > 0,");
        System.out.println("     then x.compareTo(z) > 0");
        System.out.println("   - x.compareTo(y) == 0 implies");
        System.out.println("     sgn(x.compareTo(z)) == sgn(y.compareTo(z))");
        System.out.println("   - Strongly recommended:");
        System.out.println("     (x.compareTo(y) == 0) == (x.equals(y))");
        System.out.println();
        
        // Comparison
        System.out.println("2. COMPARISON EXAMPLES:");
        PhoneNumberComparable pn1 = new PhoneNumberComparable(707, 867, 5309);
        PhoneNumberComparable pn2 = new PhoneNumberComparable(415, 555, 1234);
        PhoneNumberComparable pn3 = new PhoneNumberComparable(707, 867, 5309);
        
        System.out.println("   pn1: " + pn1);
        System.out.println("   pn2: " + pn2);
        System.out.println("   pn3: " + pn3);
        System.out.println();
        
        System.out.println("   pn1.compareTo(pn2): " + pn1.compareTo(pn2));
        System.out.println("   pn2.compareTo(pn1): " + pn2.compareTo(pn1));
        System.out.println("   (Signs are opposite)");
        System.out.println();
        
        System.out.println("   pn1.compareTo(pn3): " + pn1.compareTo(pn3));
        System.out.println("   pn1.equals(pn3): " + pn1.equals(pn3));
        System.out.println("   (compareTo == 0 when equals is true)");
        System.out.println();
        
        // Sorting
        System.out.println("3. SORTING:");
        List<PhoneNumberComparable> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumberComparable(415, 555, 1234));
        phoneNumbers.add(new PhoneNumberComparable(707, 867, 5309));
        phoneNumbers.add(new PhoneNumberComparable(212, 555, 9999));
        phoneNumbers.add(new PhoneNumberComparable(415, 555, 0000));
        
        System.out.println("   Before sorting:");
        phoneNumbers.forEach(pn -> System.out.println("     " + pn));
        
        Collections.sort(phoneNumbers);
        
        System.out.println("   After sorting:");
        phoneNumbers.forEach(pn -> System.out.println("     " + pn));
        System.out.println();
        
        // TreeSet
        System.out.println("4. IN SORTED COLLECTIONS:");
        Set<PhoneNumberComparable> sortedSet = new TreeSet<>();
        sortedSet.add(new PhoneNumberComparable(415, 555, 1234));
        sortedSet.add(new PhoneNumberComparable(707, 867, 5309));
        sortedSet.add(new PhoneNumberComparable(212, 555, 9999));
        
        System.out.println("   TreeSet (automatically sorted):");
        sortedSet.forEach(pn -> System.out.println("     " + pn));
        System.out.println();
        
        // Recipe
        System.out.println("5. RECIPE FOR compareTo:");
        System.out.println("   1. Compare most significant field first");
        System.out.println("   2. Use primitive comparison operators (<, >, ==)");
        System.out.println("   3. Use compare() methods for boxed primitives");
        System.out.println("   4. Use Comparator.comparing() for object fields");
        System.out.println("   5. Use thenComparing() for subsequent fields");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Implement Comparable if your class has a natural ordering");
        System.out.println("2. Follow the compareTo contract strictly");
        System.out.println("3. Maintain consistency with equals()");
        System.out.println("4. Use primitive comparison operators when possible");
        System.out.println("5. Compare most significant fields first");
        System.out.println("6. Consider Comparator.comparing() for complex comparisons");
    }
}

