package com.effectivejava.item1;

/**
 * Example demonstrating static factory method from Boolean class.
 * This method translates a boolean primitive value into a Boolean object reference.
 * 
 * Note: This is a simplified example. The actual Boolean.valueOf() method
 * returns cached instances (Boolean.TRUE or Boolean.FALSE) for efficiency.
 */
public class BooleanExample {
    
    /**
     * Static factory method that returns a Boolean instance.
     * This is more efficient than using a constructor because it can return
     * cached instances instead of creating new ones.
     * 
     * @param b the boolean primitive value
     * @return Boolean.TRUE if b is true, Boolean.FALSE otherwise
     */
    public static Boolean valueOf(boolean b) {
        return b ? Boolean.TRUE : Boolean.FALSE;
    }
    
    public static void demonstrate() {
        // Using static factory method
        Boolean bool1 = BooleanExample.valueOf(true);
        Boolean bool2 = BooleanExample.valueOf(true);
        
        // Both references point to the same cached instance
        System.out.println("bool1 == bool2: " + (bool1 == bool2)); // true (same instance)
        System.out.println("bool1.equals(bool2): " + bool1.equals(bool2)); // true
        
        // Compare with constructor (creates new instances)
        // NOTE: Boolean(boolean) constructor is deprecated since Java 9 and marked for removal.
        // The code below is commented out for illustration purposes only to demonstrate
        // why static factory methods are preferred over constructors.
        // The deprecated constructor would create new instances each time, unlike
        // the static factory method which returns cached instances.
        // In production code, always use Boolean.valueOf() instead of new Boolean().
        // Boolean bool3 = new Boolean(true);  // Deprecated - creates new instance
        // Boolean bool4 = new Boolean(true);  // Deprecated - creates new instance
        // System.out.println("bool3 == bool4: " + (bool3 == bool4)); // false (different instances)
        // System.out.println("bool3.equals(bool4): " + bool3.equals(bool4)); // true
        
        // Using static factory method instead (recommended approach)
        Boolean bool3 = Boolean.valueOf(true);
        Boolean bool4 = Boolean.valueOf(true);
        System.out.println("bool3 == bool4: " + (bool3 == bool4)); // true (same cached instance)
        System.out.println("bool3.equals(bool4): " + bool3.equals(bool4)); // true
    }
}


