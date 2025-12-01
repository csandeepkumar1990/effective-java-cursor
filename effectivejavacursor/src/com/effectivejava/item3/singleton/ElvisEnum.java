package com.effectivejava.item3.singleton;

/**
 * Enum singleton - Approach 3 (PREFERRED)
 * 
 * This is the preferred approach because:
 * 1. More concise than public field approach
 * 2. Provides serialization machinery for free
 * 3. Ironclad guarantee against multiple instantiation
 * 4. Immune to reflection attacks
 * 5. Immune to serialization attacks
 * 
 * Note: Can't use this if singleton must extend a superclass other than Enum
 * (though you can declare an enum to implement interfaces).
 */
public enum ElvisEnum {
    INSTANCE;
    
    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building!");
    }
}

