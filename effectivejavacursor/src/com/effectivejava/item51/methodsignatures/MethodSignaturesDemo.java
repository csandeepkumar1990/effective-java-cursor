package com.effectivejava.item51.methodsignatures;

/**
 * Demonstration of Item 51: Design method signatures carefully.
 */
public class MethodSignaturesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 51: Design Method Signatures Carefully ===\n");
        
        System.out.println("1. BEST PRACTICES:");
        System.out.println("   - Choose method names carefully");
        System.out.println("   - Don't go overboard with convenience methods");
        System.out.println("   - Avoid long parameter lists (use builder pattern)");
        System.out.println("   - Prefer interfaces to classes for parameters");
        System.out.println("   - Use two-element enum types instead of boolean");
        System.out.println();
        
        System.out.println("2. METHOD NAMES:");
        System.out.println("   GOOD: drawCircle(x, y, radius)");
        System.out.println("   BAD: draw(a, b, c)");
        System.out.println();
        
        System.out.println("3. PARAMETER LISTS:");
        System.out.println("   BAD: createUser(firstName, lastName, email, phone, ...)");
        System.out.println("   GOOD: Use builder pattern");
        System.out.println();
        
        System.out.println("4. BOOLEAN PARAMETERS:");
        System.out.println("   BAD: setThermostat(boolean fahrenheit)");
        System.out.println("   GOOD: setThermostat(TemperatureScale.FAHRENHEIT)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Choose clear, descriptive method names");
        System.out.println("2. Keep parameter lists short");
        System.out.println("3. Use builder pattern for many parameters");
        System.out.println("4. Prefer enums to boolean parameters");
    }
}

