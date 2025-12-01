package com.effectivejava.item35.instancefieldsinsteadofordinals;

/**
 * Demonstration of Item 35: Use instance fields instead of ordinals.
 */
public class InstanceFieldsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 35: Use Instance Fields Instead of Ordinals ===\n");
        
        System.out.println("1. PROBLEM WITH ordinal():");
        System.out.println("   If you reorder enum constants, values change!");
        System.out.println("   ordinal() is for use by EnumSet and EnumMap only");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   Store values in instance fields");
        System.out.println();
        
        for (Ensemble e : Ensemble.values()) {
            System.out.println("   " + e + ": " + e.numberOfMusicians() + " musicians");
        }
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Never derive values from ordinal()");
        System.out.println("2. Store values in instance fields");
        System.out.println("3. ordinal() is for use by EnumSet and EnumMap only");
    }
}

