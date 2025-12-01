package com.effectivejava.item44.standardfunctionalinterfaces;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Demonstration of Item 44: Favor the use of standard functional interfaces.
 */
public class StandardFunctionalInterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 44: Favor Standard Functional Interfaces ===\n");
        
        System.out.println("1. STANDARD FUNCTIONAL INTERFACES:");
        System.out.println("   - UnaryOperator<T>: T apply(T t)");
        System.out.println("   - BinaryOperator<T>: T apply(T t1, T t2)");
        System.out.println("   - Predicate<T>: boolean test(T t)");
        System.out.println("   - Function<T,R>: R apply(T t)");
        System.out.println("   - Supplier<T>: T get()");
        System.out.println("   - Consumer<T>: void accept(T t)");
        System.out.println();
        
        System.out.println("2. WHEN TO USE STANDARD INTERFACES:");
        System.out.println("   - Always prefer standard interfaces");
        System.out.println("   - They're well-known and tested");
        System.out.println("   - Better interoperability");
        System.out.println();
        
        System.out.println("3. WHEN TO CREATE CUSTOM INTERFACE:");
        System.out.println("   - When standard interfaces don't fit");
        System.out.println("   - When you need a more descriptive name");
        System.out.println("   - When you need additional methods");
        System.out.println();
        
        String result = StandardInterfaces.transform("hello", String::toUpperCase);
        System.out.println("4. EXAMPLE:");
        System.out.println("   transform(\"hello\", String::toUpperCase) = " + result);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use standard functional interfaces from java.util.function");
        System.out.println("2. They're well-tested and interoperable");
        System.out.println("3. Create custom interfaces only when necessary");
        System.out.println("4. Always annotate with @FunctionalInterface");
    }
}

