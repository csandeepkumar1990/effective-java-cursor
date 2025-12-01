package com.effectivejava.item23.classhierarchies;

/**
 * Demonstration of Item 23: Prefer class hierarchies to tagged classes.
 */
public class ClassHierarchiesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 23: Prefer Class Hierarchies to Tagged Classes ===\n");
        
        System.out.println("1. PROBLEM: Tagged Classes");
        System.out.println("   A tagged class has a tag field indicating what kind of instance it is.");
        System.out.println("   Problems:");
        System.out.println("   - Verbose and error-prone");
        System.out.println("   - Inefficient (carries unused fields)");
        System.out.println("   - Not type-safe");
        System.out.println("   - Hard to extend");
        System.out.println();
        
        System.out.println("2. SOLUTION: Class Hierarchy");
        System.out.println("   Use abstract classes and inheritance instead.");
        System.out.println();
        
        // Class hierarchy example
        Figure circle = new Circle(5.0);
        Figure rectangle = new Rectangle(4.0, 6.0);
        Figure square = new Square(3.0);
        
        System.out.println("3. CLASS HIERARCHY EXAMPLE:");
        System.out.println("   Circle area: " + circle.area());
        System.out.println("   Rectangle area: " + rectangle.area());
        System.out.println("   Square area: " + square.area());
        System.out.println("   (Type-safe, efficient, extensible)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Avoid tagged classes");
        System.out.println("2. Use class hierarchies instead");
        System.out.println("3. Class hierarchies are type-safe and efficient");
        System.out.println("4. Class hierarchies are easier to extend");
    }
}

