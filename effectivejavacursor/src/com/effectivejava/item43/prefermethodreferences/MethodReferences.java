package com.effectivejava.item43.prefermethodreferences;

import java.util.HashMap;
import java.util.Map;

/**
 * Item 43: Prefer method references to lambdas.
 * 
 * Method references are often more concise and readable than lambdas.
 * 
 * Types of method references:
 * 1. Static: Integer::parseInt
 * 2. Bound instance: Instant.now()::isAfter
 * 3. Unbound instance: String::toLowerCase
 * 4. Class constructor: TreeMap<K,V>::new
 * 5. Array constructor: int[]::new
 */
public class MethodReferences {
    
    /**
     * LAMBDA: More verbose.
     */
    public static void lambdaWay(Map<String, Integer> map, String key) {
        map.merge(key, 1, (count, incr) -> count + incr);
    }
    
    /**
     * METHOD REFERENCE: More concise.
     */
    public static void methodRefWay(Map<String, Integer> map, String key) {
        map.merge(key, 1, Integer::sum);
    }
    
    /**
     * Example with service.
     */
    public static class Service {
        public void execute() {
            System.out.println("Executing service");
        }
    }
    
    /**
     * LAMBDA: Verbose.
     */
    public static void executeLambda(Service service) {
        Runnable r = () -> service.execute();
        r.run();
    }
    
    /**
     * METHOD REFERENCE: Concise.
     */
    public static void executeMethodRef(Service service) {
        Runnable r = service::execute;
        r.run();
    }
}

