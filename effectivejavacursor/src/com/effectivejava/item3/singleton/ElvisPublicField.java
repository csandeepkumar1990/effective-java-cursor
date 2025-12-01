package com.effectivejava.item3.singleton;

/**
 * Singleton with public final field - Approach 1
 * 
 * Advantages:
 * 1. API makes it clear that the class is a singleton
 * 2. Simpler - direct field access
 * 3. Public static final field guarantees same object reference
 * 
 * The private constructor is called only once to initialize INSTANCE.
 * The lack of a public or protected constructor guarantees exactly one instance.
 */
public class ElvisPublicField {
    public static final ElvisPublicField INSTANCE = new ElvisPublicField();
    private static boolean instantiated = false;
    
    private ElvisPublicField() {
        // Defend against reflection attack
        if (instantiated) {
            throw new IllegalStateException("Already instantiated");
        }
        instantiated = true;
    }
    
    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building!");
    }
    
    // For serialization - preserve singleton property
    private Object readResolve() {
        // Return the one true Elvis and let the garbage collector
        // take care of the Elvis impersonator.
        return INSTANCE;
    }
}

