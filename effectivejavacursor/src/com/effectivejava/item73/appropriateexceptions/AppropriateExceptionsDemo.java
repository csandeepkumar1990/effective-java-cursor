package com.effectivejava.item73.appropriateexceptions;

/**
 * Demonstration of Item 73: Throw exceptions appropriate to the abstraction.
 */
public class AppropriateExceptionsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 73: Throw Exceptions Appropriate to Abstraction ===\n");
        
        System.out.println("1. PRINCIPLE:");
        System.out.println("   Higher layers should catch lower-level exceptions");
        System.out.println("   and throw exceptions appropriate to the higher-level abstraction");
        System.out.println();
        
        System.out.println("2. EXCEPTION TRANSLATION:");
        System.out.println("   try {");
        System.out.println("       // Lower-level operation");
        System.out.println("   } catch (LowerLevelException e) {");
        System.out.println("       throw new HigherLevelException(e);");
        System.out.println("   }");
        System.out.println();
        
        System.out.println("3. BENEFITS:");
        System.out.println("   - Hides implementation details");
        System.out.println("   - Provides appropriate abstraction");
        System.out.println("   - Preserves cause for debugging");
        System.out.println();
        
        System.out.println("4. EXAMPLE:");
        System.out.println("   BAD: Propagating SQLException (implementation detail)");
        System.out.println("   GOOD: Translating to DataAccessException (abstraction)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Translate lower-level exceptions to higher-level");
        System.out.println("2. Preserve cause for debugging");
        System.out.println("3. Hide implementation details");
        System.out.println("4. Provide appropriate abstraction");
    }
}

