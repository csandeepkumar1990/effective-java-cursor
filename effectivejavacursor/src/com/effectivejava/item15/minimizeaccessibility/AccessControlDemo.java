package com.effectivejava.item15.minimizeaccessibility;

import java.util.Arrays;

/**
 * Demonstration of Item 15: Minimize the accessibility of classes and members.
 */
public class AccessControlDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 15: Minimize Accessibility ===\n");
        
        System.out.println("1. ACCESS LEVELS (from most to least restrictive):");
        System.out.println("   - private: accessible only within the class");
        System.out.println("   - package-private: accessible within the package");
        System.out.println("   - protected: accessible within package and subclasses");
        System.out.println("   - public: accessible everywhere");
        System.out.println();
        
        System.out.println("2. RULE: Make each class or member as inaccessible as possible");
        System.out.println();
        
        System.out.println("3. PROBLEM WITH INHERITANCE:");
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(Arrays.asList("Snap", "Crackle", "Pop"));
        System.out.println("   set.addAll([\"Snap\", \"Crackle\", \"Pop\"])");
        System.out.println("   Expected count: 3");
        System.out.println("   Actual count: " + set.getAddCount());
        System.out.println("   Problem: addAll() calls add(), so elements counted twice!");
        System.out.println("   Solution: Use composition instead of inheritance");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Make classes and members as inaccessible as possible");
        System.out.println("2. Use private for implementation details");
        System.out.println("3. Use package-private for package-level access");
        System.out.println("4. Use protected only when necessary for inheritance");
        System.out.println("5. Use public only for the API");
        System.out.println("6. Prefer composition over inheritance");
    }
}

