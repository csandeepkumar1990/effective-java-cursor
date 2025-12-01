package com.effectivejava.item10.overrideequals;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration of Item 10: Obey the general contract when overriding equals.
 * 
 * This demo shows:
 * 1. The equals contract (reflexive, symmetric, transitive, consistent, non-null)
 * 2. Recipe for implementing equals
 * 3. Common mistakes
 * 4. The ColorPoint problem (inheritance and equals)
 */
public class EqualsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 10: Obey the General Contract for equals ===\n");
        
        System.out.println("1. THE EQUALS CONTRACT:");
        System.out.println("   - Reflexive: x.equals(x) must be true");
        System.out.println("   - Symmetric: x.equals(y) == y.equals(x)");
        System.out.println("   - Transitive: if x.equals(y) && y.equals(z), then x.equals(z)");
        System.out.println("   - Consistent: multiple calls return same result");
        System.out.println("   - Non-null: x.equals(null) must be false");
        System.out.println();
        
        // Reflexive
        System.out.println("2. REFLEXIVE TEST:");
        PhoneNumber pn1 = new PhoneNumber(707, 867, 5309);
        System.out.println("   pn1.equals(pn1): " + pn1.equals(pn1) + " (must be true)");
        System.out.println();
        
        // Symmetric
        System.out.println("3. SYMMETRIC TEST:");
        PhoneNumber pn2 = new PhoneNumber(707, 867, 5309);
        System.out.println("   pn1.equals(pn2): " + pn1.equals(pn2));
        System.out.println("   pn2.equals(pn1): " + pn2.equals(pn1) + " (must be same)");
        System.out.println();
        
        // Transitive
        System.out.println("4. TRANSITIVE TEST:");
        PhoneNumber pn3 = new PhoneNumber(707, 867, 5309);
        System.out.println("   pn1.equals(pn2): " + pn1.equals(pn2));
        System.out.println("   pn2.equals(pn3): " + pn2.equals(pn3));
        System.out.println("   pn1.equals(pn3): " + pn1.equals(pn3) + " (must be true)");
        System.out.println();
        
        // Consistent
        System.out.println("5. CONSISTENT TEST:");
        System.out.println("   Multiple calls to pn1.equals(pn2):");
        for (int i = 0; i < 5; i++) {
            System.out.println("   Call " + (i + 1) + ": " + pn1.equals(pn2));
        }
        System.out.println();
        
        // Non-null
        System.out.println("6. NON-NULL TEST:");
        System.out.println("   pn1.equals(null): " + pn1.equals(null) + " (must be false)");
        System.out.println();
        
        // Recipe
        System.out.println("7. RECIPE FOR EQUALS:");
        System.out.println("   1. Use == to check if argument is a reference to this object");
        System.out.println("   2. Use instanceof to check if argument has correct type");
        System.out.println("   3. Cast argument to correct type");
        System.out.println("   4. Check each \"significant\" field for equality");
        System.out.println("   5. Always override hashCode when you override equals");
        System.out.println();
        
        // ColorPoint problem
        System.out.println("8. THE COLORPOINT PROBLEM (Inheritance and equals):");
        ColorPoint.Point point = new ColorPoint.Point(1, 2);
        ColorPoint colorPoint1 = new ColorPoint(1, 2, "RED");
        ColorPoint colorPoint2 = new ColorPoint(1, 2, "BLUE");
        
        System.out.println("   point.equals(colorPoint1.asPoint()): " + 
            point.equals(colorPoint1.asPoint()));
        System.out.println("   colorPoint1.equals(colorPoint2): " + 
            colorPoint1.equals(colorPoint2));
        System.out.println("   Solution: Use composition instead of inheritance");
        System.out.println();
        
        // List contains
        System.out.println("9. USING EQUALS IN COLLECTIONS:");
        List<PhoneNumber> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(pn1);
        System.out.println("   phoneNumbers.contains(pn2): " + phoneNumbers.contains(pn2));
        System.out.println("   (Uses equals() method)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Don't override equals unless you need value equality");
        System.out.println("2. Follow the equals contract strictly");
        System.out.println("3. Use the recipe: ==, instanceof, cast, field comparison");
        System.out.println("4. Always override hashCode when overriding equals");
        System.out.println("5. Don't try to be too clever");
        System.out.println("6. Prefer composition over inheritance when adding value components");
    }
}

