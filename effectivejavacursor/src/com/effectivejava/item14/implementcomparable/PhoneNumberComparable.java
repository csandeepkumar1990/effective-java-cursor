package com.effectivejava.item14.implementcomparable;

import java.util.Objects;

/**
 * Item 14: Consider implementing Comparable.
 * 
 * The compareTo contract:
 * 1. sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
 * 2. Transitive: if x.compareTo(y) > 0 && y.compareTo(z) > 0, then x.compareTo(z) > 0
 * 3. x.compareTo(y) == 0 implies sgn(x.compareTo(z)) == sgn(y.compareTo(z))
 * 4. Strongly recommended: (x.compareTo(y) == 0) == (x.equals(y))
 * 
 * Recipe:
 * 1. Compare most significant field first
 * 2. Use primitive comparison operators (<, >, ==)
 * 3. Use compare() methods for boxed primitives
 * 4. Use Comparator.comparing() for object fields
 * 5. Use thenComparing() for subsequent fields
 */
public class PhoneNumberComparable implements Comparable<PhoneNumberComparable> {
    private final short areaCode, prefix, lineNum;
    
    public PhoneNumberComparable(int areaCode, int prefix, int lineNum) {
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
    
    /**
     * GOOD: Proper compareTo implementation.
     * Compares area code first, then prefix, then line number.
     */
    @Override
    public int compareTo(PhoneNumberComparable pn) {
        int result = Short.compare(areaCode, pn.areaCode);
        if (result != 0) return result;
        
        result = Short.compare(prefix, pn.prefix);
        if (result != 0) return result;
        
        return Short.compare(lineNum, pn.lineNum);
    }
    
    /**
     * ALTERNATIVE: Using Comparator.comparing() (Java 8+).
     * More concise but potentially slower.
     */
    // @Override
    // public int compareTo(PhoneNumberComparable pn) {
    //     return Comparator.comparing((PhoneNumberComparable p) -> p.areaCode)
    //         .thenComparing(p -> p.prefix)
    //         .thenComparing(p -> p.lineNum)
    //         .compare(this, pn);
    // }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof PhoneNumberComparable)) return false;
        PhoneNumberComparable pn = (PhoneNumberComparable) o;
        return pn.lineNum == lineNum 
            && pn.prefix == prefix 
            && pn.areaCode == areaCode;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
    
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }
}

