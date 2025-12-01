package com.effectivejava.item71.avoidchecked;

import java.util.List;

/**
 * Item 71: Avoid unnecessary use of checked exceptions.
 * 
 * Checked exceptions force callers to handle them, which can be burdensome.
 * 
 * When to avoid checked exceptions:
 * - When callers can't recover
 * - When the only recovery is to catch and ignore
 * - When it makes API harder to use
 * 
 * Alternatives:
 * - Return Optional
 * - Return boolean (success/failure)
 * - Use runtime exception
 * - Provide state-testing method
 */
public class UnnecessaryChecked {
    
    /**
     * BAD: Unnecessary checked exception.
     * Callers can't really recover from this.
     */
    public static void actionBad() throws ActionException {
        // Throws checked exception
        throw new ActionException("Action failed");
    }
    
    /**
     * GOOD: Return Optional instead.
     * Caller can check if action succeeded.
     */
    public static java.util.Optional<String> actionGood() {
        // Return Optional.empty() on failure
        return java.util.Optional.empty();
    }
    
    /**
     * GOOD: Return boolean.
     * Simple success/failure indicator.
     */
    public static boolean tryAction() {
        // Return true on success, false on failure
        return false;
    }
    
    /**
     * GOOD: Provide state-testing method.
     * Check if action can be performed before trying.
     */
    public static boolean canPerformAction() {
        return true;  // Check if action is possible
    }
    
    public static void performAction() {
        if (!canPerformAction()) {
            throw new IllegalStateException("Cannot perform action");
        }
        // Perform action
    }
    
    /**
     * Custom checked exception (for illustration).
     */
    public static class ActionException extends Exception {
        public ActionException(String message) {
            super(message);
        }
    }
}

