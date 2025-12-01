package com.effectivejava.item87.customserializedform;

/**
 * Demonstration of Item 87: Consider using a custom serialized form.
 */
public class CustomSerializedFormDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 87: Consider Custom Serialized Form ===\n");
        
        System.out.println("1. DEFAULT SERIALIZATION:");
        System.out.println("   - Serializes all non-transient fields");
        System.out.println("   - Includes class name and field names");
        System.out.println("   - Can be inefficient");
        System.out.println("   - Ties you to implementation");
        System.out.println();
        
        System.out.println("2. CUSTOM SERIALIZED FORM:");
        System.out.println("   - More control");
        System.out.println("   - Can be more efficient");
        System.out.println("   - Better encapsulation");
        System.out.println("   - Easier to evolve");
        System.out.println();
        
        System.out.println("3. WHEN TO USE:");
        System.out.println("   - When default form is inefficient");
        System.out.println("   - When you want to hide implementation");
        System.out.println("   - When you need versioning control");
        System.out.println();
        
        System.out.println("4. IMPLEMENTATION:");
        System.out.println("   - Implement writeObject()");
        System.out.println("   - Implement readObject()");
        System.out.println("   - Use transient for non-serializable fields");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Consider custom serialized form");
        System.out.println("2. More control and better encapsulation");
        System.out.println("3. Can be more efficient");
        System.out.println("4. Easier to evolve implementation");
    }
}

