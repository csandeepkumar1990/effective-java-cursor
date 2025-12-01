package com.effectivejava.item64.refertointerfaces;

import java.util.*;

/**
 * Demonstration of Item 64: Refer to objects by their interfaces.
 */
public class ReferToInterfacesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 64: Refer to Objects by Their Interfaces ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Use interface types for parameters, return values,");
        System.out.println("   variables, and fields");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - More flexible");
        System.out.println("   - Better encapsulation");
        System.out.println("   - Easier to change implementations");
        System.out.println("   - Follows dependency inversion principle");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   BAD: ArrayList<String> list = new ArrayList<>()");
        System.out.println("   GOOD: List<String> list = new ArrayList<>()");
        System.out.println();
        
        List<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        ReferToInterfaces.goodExample(list);
        System.out.println("   Can pass ArrayList, LinkedList, or any List implementation");
        System.out.println();
        
        System.out.println("4. EXCEPTIONS:");
        System.out.println("   - When you need class-specific methods");
        System.out.println("   - Value classes (String, BigInteger, etc.)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use interface types for variables and parameters");
        System.out.println("2. More flexible and maintainable");
        System.out.println("3. Exception: when you need class-specific methods");
        System.out.println("4. Value classes are an exception");
    }
}

