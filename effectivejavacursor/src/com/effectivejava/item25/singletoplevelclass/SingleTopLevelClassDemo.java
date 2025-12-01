package com.effectivejava.item25.singletoplevelclass;

/**
 * Demonstration of Item 25: Limit source files to a single top-level class.
 */
public class SingleTopLevelClassDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 25: Limit Source Files to Single Top-Level Class ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Never put multiple top-level classes or interfaces in a single source file.");
        System.out.println();
        
        System.out.println("2. PROBLEM: Multiple top-level classes in one file");
        System.out.println("   - Can cause compilation errors");
        System.out.println("   - Order of compilation matters");
        System.out.println("   - Confusing and error-prone");
        System.out.println("   - Can lead to name conflicts");
        System.out.println();
        
        System.out.println("3. SOLUTION:");
        System.out.println("   - One top-level class per source file");
        System.out.println("   - Name the file after the class");
        System.out.println("   - Use nested classes if you need multiple classes");
        System.out.println();
        
        System.out.println("   Utensil.NAME = " + Utensil.NAME);
        System.out.println("   Dessert.NAME = " + Dessert.NAME);
        System.out.println("   (Each in its own file)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. One top-level class per source file");
        System.out.println("2. Name the file after the class");
        System.out.println("3. Use nested classes if you need multiple classes");
        System.out.println("4. This prevents compilation errors and confusion");
    }
}

