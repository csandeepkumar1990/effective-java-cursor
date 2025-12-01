package com.effectivejava.item71.avoidchecked;

/**
 * Demonstration of Item 71: Avoid unnecessary use of checked exceptions.
 */
public class AvoidCheckedDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 71: Avoid Unnecessary Checked Exceptions ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   Checked exceptions force callers to handle them");
        System.out.println("   This can be burdensome when recovery isn't possible");
        System.out.println();
        
        System.out.println("2. WHEN TO AVOID:");
        System.out.println("   - When callers can't recover");
        System.out.println("   - When the only recovery is to catch and ignore");
        System.out.println("   - When it makes API harder to use");
        System.out.println();
        
        System.out.println("3. ALTERNATIVES:");
        System.out.println("   - Return Optional");
        System.out.println("   - Return boolean (success/failure)");
        System.out.println("   - Use runtime exception");
        System.out.println("   - Provide state-testing method");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        if (UnnecessaryChecked.canPerformAction()) {
            UnnecessaryChecked.performAction();
            System.out.println("   (State-testing method pattern)");
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Avoid checked exceptions when recovery isn't possible");
        System.out.println("2. Use Optional or boolean return values");
        System.out.println("3. Provide state-testing methods when appropriate");
        System.out.println("4. Make APIs easy to use");
    }
}

