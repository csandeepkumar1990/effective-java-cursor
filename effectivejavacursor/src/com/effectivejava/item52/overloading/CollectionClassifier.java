package com.effectivejava.item52.overloading;

import java.util.*;

/**
 * Item 52: Use overloading judiciously.
 * 
 * Overloading is resolved at compile time based on static types.
 * This can lead to confusing behavior.
 * 
 * RULE: Never export two overloadings with the same number of parameters.
 * Use different method names instead.
 */
public class CollectionClassifier {
    
    /**
     * BAD: Overloading with same number of parameters.
     * This doesn't work as expected!
     */
    public static String classify(Set<?> s) {
        return "Set";
    }
    
    public static String classify(List<?> lst) {
        return "List";
    }
    
    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }
    
    /**
     * This will always print "Unknown Collection" because
     * overloading is resolved at compile time!
     */
    public static void demonstrateProblem() {
        Collection<?>[] collections = {
            new HashSet<String>(),
            new ArrayList<String>(),
            new HashMap<String, String>().values()
        };
        
        for (Collection<?> c : collections) {
            System.out.println(classify(c));  // Always "Unknown Collection"!
        }
    }
    
    /**
     * GOOD: Use different method names.
     */
    public static String classifySet(Set<?> s) {
        return "Set";
    }
    
    public static String classifyList(List<?> lst) {
        return "List";
    }
    
    public static String classifyCollection(Collection<?> c) {
        return "Unknown Collection";
    }
    
    /**
     * GOOD: Use instanceof for runtime type checking.
     */
    public static String classifyCorrect(Collection<?> c) {
        if (c instanceof Set) {
            return "Set";
        } else if (c instanceof List) {
            return "List";
        } else {
            return "Unknown Collection";
        }
    }
}

