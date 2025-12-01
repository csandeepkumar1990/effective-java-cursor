package com.effectivejava.item88.defensivereadobject;

/**
 * Demonstration of Item 88: Write readObject methods defensively.
 */
public class DefensiveReadObjectDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 88: Write readObject Methods Defensively ===\n");
        
        System.out.println("1. RULES FOR readObject:");
        System.out.println("   1. Validate all parameters");
        System.out.println("   2. Make defensive copies");
        System.out.println("   3. Check invariants");
        System.out.println("   4. Don't invoke overridable methods");
        System.out.println();
        
        System.out.println("2. WHY:");
        System.out.println("   - Prevents attacks");
        System.out.println("   - Ensures object integrity");
        System.out.println("   - Maintains invariants");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   private void readObject(ObjectInputStream s) {");
        System.out.println("       s.defaultReadObject();");
        System.out.println("       // Defensive copy");
        System.out.println("       start = new Date(start.getTime());");
        System.out.println("       // Validate");
        System.out.println("       if (start.compareTo(end) > 0) throw ...;");
        System.out.println("   }");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Always write readObject defensively");
        System.out.println("2. Validate and make defensive copies");
        System.out.println("3. Check invariants");
        System.out.println("4. Prevents attacks and ensures integrity");
    }
}

