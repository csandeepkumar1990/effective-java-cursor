package com.effectivejava.item86.implementserializable;

/**
 * Demonstration of Item 86: Implement Serializable with great caution.
 */
public class ImplementSerializableDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 86: Implement Serializable with Great Caution ===\n");
        
        System.out.println("1. PROBLEMS:");
        System.out.println("   - Decreases flexibility to change implementation");
        System.out.println("   - Increases testing burden");
        System.out.println("   - Security risks");
        System.out.println("   - Versioning issues");
        System.out.println("   - Performance overhead");
        System.out.println();
        
        System.out.println("2. DECISION FACTORS:");
        System.out.println("   - Will this class be part of a framework?");
        System.out.println("   - Will clients need to serialize instances?");
        System.out.println("   - Is it a value class?");
        System.out.println("   - Is it part of a stateful framework?");
        System.out.println();
        
        System.out.println("3. IF YOU MUST:");
        System.out.println("   - Declare serialVersionUID");
        System.out.println("   - Use transient for non-serializable fields");
        System.out.println("   - Implement readObject defensively");
        System.out.println("   - Consider serialization proxy");
        System.out.println();
        
        System.out.println("4. BEST PRACTICE:");
        System.out.println("   Avoid implementing Serializable if possible");
        System.out.println("   Use alternatives (JSON, Protocol Buffers)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Implement Serializable with great caution");
        System.out.println("2. Consider alternatives first");
        System.out.println("3. If you must, do it carefully");
        System.out.println("4. Declare serialVersionUID");
    }
}

