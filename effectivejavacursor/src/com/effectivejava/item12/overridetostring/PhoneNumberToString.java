package com.effectivejava.item12.overridetostring;

/**
 * Item 12: Always override toString.
 * 
 * The toString contract:
 * - Should return a concise, informative representation
 * - Should be self-documenting
 * - Should include all interesting information
 * - Should specify format in documentation if format is important
 * 
 * Benefits:
 * - Makes debugging easier
 * - Improves readability of logs
 * - Better error messages
 * - Collections print nicely
 */
public class PhoneNumberToString {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumberToString(int areaCode, int prefix, int lineNum) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNum = (short) lineNum;
    }
    
    /**
     * GOOD: Informative toString implementation.
     * Returns all interesting information in a readable format.
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
    
    /**
     * ALTERNATIVE: If format is important, document it and provide parsing method.
     * 
     * Returns the string representation of this phone number.
     * The string is of the form "XXX-YYY-ZZZZ" where:
     * - XXX is the area code (3 digits)
     * - YYY is the prefix (3 digits)
     * - ZZZZ is the line number (4 digits)
     * 
     * @return string representation in format XXX-YYY-ZZZZ
     */
    // public String toString() {
    //     return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    // }
    
    /**
     * If you specify a format, provide a static factory or constructor
     * that parses the string representation.
     */
    public static PhoneNumberToString fromString(String phoneNumber) {
        String[] parts = phoneNumber.split("-");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid phone number format");
        }
        return new PhoneNumberToString(
            Integer.parseInt(parts[0]),
            Integer.parseInt(parts[1]),
            Integer.parseInt(parts[2])
        );
    }
}

