package com.effectivejava.item57.minimizescope;

import java.util.Iterator;
import java.util.List;

/**
 * Item 57: Minimize the scope of local variables.
 * 
 * Best practices:
 * - Declare variables where they're first used
 * - Initialize variables when declared
 * - Prefer for loops to while loops
 * - Keep methods small and focused
 */
public class MinimizeScope {
    
    /**
     * BAD: Variable declared too early.
     */
    public void badExample(List<String> list) {
        Iterator<String> i = list.iterator();  // Declared too early
        // ... lots of code ...
        while (i.hasNext()) {
            // Use i
        }
    }
    
    /**
     * GOOD: Variable declared where used.
     */
    public void goodExample(List<String> list) {
        // ... code ...
        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            // Use i - scope is limited to loop
        }
    }
    
    /**
     * BEST: Enhanced for loop.
     */
    public void bestExample(List<String> list) {
        for (String element : list) {
            // Use element - scope is limited to loop
        }
    }
    
    /**
     * BAD: Variable scope too large.
     */
    public void badScope() {
        int i;
        // ... lots of code ...
        i = computeValue();
        // ... more code ...
        useValue(i);
    }
    
    /**
     * GOOD: Variable scope minimized.
     */
    public void goodScope() {
        // ... code ...
        int i = computeValue();  // Declared and initialized where used
        useValue(i);
    }
    
    private int computeValue() {
        return 42;
    }
    
    private void useValue(int value) {
        // Use value
    }
}

