package com.effectivejava.item11.overridehashcode;

/**
 * Item 11: Always override hashCode when you override equals.
 * 
 * The hashCode contract:
 * 1. Consistent: multiple calls return same value (if object unchanged)
 * 2. If x.equals(y), then x.hashCode() == y.hashCode()
 * 3. If !x.equals(y), hashCode can be same or different (but different is better)
 * 
 * Recipe for hashCode:
 * 1. Declare int variable named result, initialize to hash code c1 of first field
 * 2. For each remaining field f:
 *    a. Compute hash code c for the field
 *    b. Combine: result = 31 * result + c
 * 3. Return result
 * 
 * This class demonstrates the proper implementation.
 */
public class PhoneNumberWithHashCode {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumberWithHashCode(int areaCode, int prefix, int lineNum) {
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
        if (o == this) return true;
        if (!(o instanceof PhoneNumberWithHashCode)) return false;
        PhoneNumberWithHashCode pn = (PhoneNumberWithHashCode) o;
        return pn.lineNum == lineNum 
            && pn.prefix == prefix 
            && pn.areaCode == areaCode;
    }
    
    /**
     * GOOD: Proper hashCode implementation using the recipe.
     */
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
    
    /**
     * ALTERNATIVE: Using Objects.hash() - simpler but slower.
     * Use this for simple cases or when performance is not critical.
     */
    // @Override
    // public int hashCode() {
    //     return Objects.hash(areaCode, prefix, lineNum);
    // }
    
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}

