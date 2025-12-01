package com.effectivejava.item13.overrideclone;

/**
 * Demonstration of Item 13: Override clone judiciously.
 */
public class CloneDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 13: Override clone judiciously ===\n");
        
        System.out.println("1. PROBLEMS WITH CLONEABLE:");
        System.out.println("   - Marker interface with no methods");
        System.out.println("   - Changes behavior of Object.clone()");
        System.out.println("   - clone() is protected");
        System.out.println("   - Weak contract");
        System.out.println("   - Final fields can't be cloned");
        System.out.println();
        
        // Clone example
        System.out.println("2. CLONE() EXAMPLE:");
        Stack original = new Stack();
        original.push("first");
        original.push("second");
        original.push("third");
        
        Stack cloned = original.clone();
        System.out.println("   Original: " + original);
        System.out.println("   Cloned: " + cloned);
        System.out.println("   (Both have same size)");
        System.out.println();
        
        // Copy constructor (preferred)
        System.out.println("3. COPY CONSTRUCTOR (PREFERRED):");
        Stack copied = new Stack(original);
        System.out.println("   Stack copied = new Stack(original);");
        System.out.println("   Copied: " + copied);
        System.out.println("   (No need to implement Cloneable)");
        System.out.println();
        
        // Copy factory (preferred)
        System.out.println("4. COPY FACTORY (PREFERRED):");
        Stack factory = Stack.newInstance(original);
        System.out.println("   Stack factory = Stack.newInstance(original);");
        System.out.println("   Factory: " + factory);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Avoid implementing Cloneable if possible");
        System.out.println("2. Prefer copy constructor: new MyClass(original)");
        System.out.println("3. Prefer copy factory: MyClass.newInstance(original)");
        System.out.println("4. If you must use clone(), do it properly:");
        System.out.println("   - Implement Cloneable");
        System.out.println("   - Override clone() with public access");
        System.out.println("   - Call super.clone()");
        System.out.println("   - Fix any fields that need fixing");
        System.out.println("5. For arrays, use clone() - it's the right way");
    }
}

