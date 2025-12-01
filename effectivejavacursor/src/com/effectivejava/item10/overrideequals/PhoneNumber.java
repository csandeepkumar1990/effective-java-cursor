package com.effectivejava.item10.overrideequals;

import java.util.Objects;

/**
 * Item 10: Obey the general contract when overriding equals.
 * 
 * This class demonstrates proper equals() implementation following the contract:
 * 1. Reflexive: x.equals(x) must be true
 * 2. Symmetric: x.equals(y) == y.equals(x)
 * 3. Transitive: if x.equals(y) && y.equals(z), then x.equals(z)
 * 4. Consistent: multiple calls return same result
 * 5. Non-null: x.equals(null) must be false
 * 
 * Recipe for a high-quality equals method:
 * 1. Use == to check if argument is a reference to this object
 * 2. Use instanceof to check if argument has correct type
 * 3. Cast argument to correct type
 * 4. Check each "significant" field for equality
 * 5. Always override hashCode when you override equals
 */
public class PhoneNumber {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix = rangeCheck(prefix, 999, "prefix");
        this.lineNum = rangeCheck(lineNum, 9999, "line num");
    }
    
    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max) {
            throw new IllegalArgumentException(arg + ": " + val);
        }
        return (short) val;
    }
    
    @Override
    public boolean equals(Object o) {
        // 1. Use == to check if argument is a reference to this object
        if (o == this) {
            return true;
        }
        
        // 2. Use instanceof to check if argument has correct type
        if (!(o instanceof PhoneNumber)) {
            return false;
        }
        
        // 3. Cast argument to correct type
        PhoneNumber pn = (PhoneNumber) o;
        
        // 4. Check each "significant" field for equality
        return pn.lineNum == lineNum 
            && pn.prefix == prefix 
            && pn.areaCode == areaCode;
    }
    
    // Must override hashCode when overriding equals (Item 11)
    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
    
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}

