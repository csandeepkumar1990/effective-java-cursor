package com.effectivejava.item77.dontignore;

/**
 * Demonstration of Item 77: Don't ignore exceptions.
 */
public class DontIgnoreDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 77: Don't Ignore Exceptions ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   NEVER use an empty catch block!");
        System.out.println();
        
        System.out.println("2. IF YOU CAN'T HANDLE:");
        System.out.println("   1. At minimum, log it");
        System.out.println("   2. Document why it's safe to ignore");
        System.out.println("   3. Consider rethrowing");
        System.out.println("   4. Consider translating to appropriate exception");
        System.out.println();
        
        System.out.println("3. BAD:");
        System.out.println("   try { ... } catch (Exception e) { }");
        System.out.println("   (Exception silently ignored - very dangerous!)");
        System.out.println();
        
        System.out.println("4. GOOD:");
        System.out.println("   try { ... } catch (Exception e) {");
        System.out.println("       logger.error(\"Error\", e);");
        System.out.println("   }");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Never use empty catch blocks");
        System.out.println("2. At minimum, log exceptions");
        System.out.println("3. Document why it's safe to ignore");
        System.out.println("4. Consider rethrowing or translating");
    }
}

