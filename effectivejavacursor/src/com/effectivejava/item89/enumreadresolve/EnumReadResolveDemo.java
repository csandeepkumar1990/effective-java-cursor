package com.effectivejava.item89.enumreadresolve;

/**
 * Demonstration of Item 89: Prefer enum types to readResolve.
 */
public class EnumReadResolveDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 89: Prefer Enum Types to readResolve ===\n");
        
        System.out.println("1. PROBLEM:");
        System.out.println("   readResolve can be attacked via serialization");
        System.out.println();
        
        System.out.println("2. SOLUTION:");
        System.out.println("   Use enum singleton instead");
        System.out.println();
        
        System.out.println("3. ENUM SINGLETONS ARE:");
        System.out.println("   - Immune to serialization attacks");
        System.out.println("   - Immune to reflection attacks");
        System.out.println("   - More concise");
        System.out.println("   - Automatically handle serialization");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        Elvis.ElvisEnum.INSTANCE.leaveTheBuilding();
        System.out.println("   (Enum singleton - safe and simple)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer enum types to readResolve");
        System.out.println("2. Enum singletons are immune to attacks");
        System.out.println("3. More concise and safer");
        System.out.println("4. Automatic serialization handling");
    }
}

