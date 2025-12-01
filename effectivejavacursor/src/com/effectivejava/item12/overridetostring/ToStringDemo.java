package com.effectivejava.item12.overridetostring;

import java.util.ArrayList;
import java.util.List;

/**
 * Demonstration of Item 12: Always override toString.
 */
public class ToStringDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 12: Always Override toString ===\n");
        
        System.out.println("1. WHY OVERRIDE toString():");
        System.out.println("   - Makes debugging easier");
        System.out.println("   - Improves readability of logs");
        System.out.println("   - Better error messages");
        System.out.println("   - Collections print nicely");
        System.out.println();
        
        // Without toString
        System.out.println("2. WITHOUT toString() OVERRIDE:");
        Object obj = new Object();
        System.out.println("   obj.toString(): " + obj.toString());
        System.out.println("   (Not very useful - just class name and hash)");
        System.out.println();
        
        // With toString
        System.out.println("3. WITH toString() OVERRIDE:");
        PhoneNumberToString pn = new PhoneNumberToString(707, 867, 5309);
        System.out.println("   pn.toString(): " + pn.toString());
        System.out.println("   (Much more informative!)");
        System.out.println();
        
        // In collections
        System.out.println("4. IN COLLECTIONS:");
        List<PhoneNumberToString> phoneNumbers = new ArrayList<>();
        phoneNumbers.add(new PhoneNumberToString(707, 867, 5309));
        phoneNumbers.add(new PhoneNumberToString(415, 555, 1234));
        System.out.println("   phoneNumbers: " + phoneNumbers);
        System.out.println("   (toString() is called automatically)");
        System.out.println();
        
        // Parsing
        System.out.println("5. PARSING FROM STRING:");
        PhoneNumberToString parsed = PhoneNumberToString.fromString("707-867-5309");
        System.out.println("   Parsed: " + parsed);
        System.out.println("   (If format is important, provide parsing method)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always override toString() in your classes");
        System.out.println("2. Include all interesting information");
        System.out.println("3. Make it self-documenting");
        System.out.println("4. If format is important, document it");
        System.out.println("5. Provide parsing method if format is specified");
    }
}

