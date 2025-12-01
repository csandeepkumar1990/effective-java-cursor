package com.effectivejava.item11.overridehashcode;

/**
 * BAD EXAMPLE: PhoneNumber without hashCode override.
 * 
 * This demonstrates what happens when you override equals but not hashCode.
 * 
 * Problem: Two equal objects can have different hash codes, breaking
 * the contract and causing issues with hash-based collections.
 */
public class PhoneNumberBadHashCode {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumberBadHashCode(int areaCode, int prefix, int lineNum) {
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNum = (short) lineNum;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumberBadHashCode)) return false;
        PhoneNumberBadHashCode pn = (PhoneNumberBadHashCode) o;
        return pn.lineNum == lineNum 
            && pn.prefix == prefix 
            && pn.areaCode == areaCode;
    }
    
    // BAD: No hashCode override!
    // This violates the contract: equal objects must have equal hash codes
    // Hash-based collections (HashMap, HashSet) will not work correctly
}

