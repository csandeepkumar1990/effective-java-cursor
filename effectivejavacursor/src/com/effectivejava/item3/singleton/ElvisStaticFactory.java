package com.effectivejava.item3.singleton;

/**
 * Singleton with static factory method - Approach 2
 * 
 * Advantages:
 * 1. Flexibility to change implementation without changing API
 * 2. Can return separate instance per thread if needed
 * 3. Can write generic singleton factory (Item 30)
 * 4. Method reference can be used as Supplier: Elvis::getInstance
 * 
 * All calls to getInstance() return the same object reference.
 */
public class ElvisStaticFactory {
    private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();
    private static boolean instantiated = false;
    
    private ElvisStaticFactory() {
        // Defend against reflection attack
        if (instantiated) {
            throw new IllegalStateException("Already instantiated");
        }
        instantiated = true;
    }
    
    public static ElvisStaticFactory getInstance() {
        return INSTANCE;
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

