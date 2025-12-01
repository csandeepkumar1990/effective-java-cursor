package com.effectivejava.item47.prefercollection;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Demonstration of Item 47: Prefer Collection to Stream as a return type.
 */
public class PreferCollectionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 47: Prefer Collection to Stream ===\n");
        
        System.out.println("1. RETURN Collection WHEN:");
        System.out.println("   - Users need to iterate multiple times");
        System.out.println("   - Users need to use for-each loops");
        System.out.println("   - Users need to check membership");
        System.out.println();
        
        System.out.println("2. RETURN Stream WHEN:");
        System.out.println("   - The sequence is too large to materialize");
        System.out.println("   - The sequence is infinite");
        System.out.println("   - The sequence is expensive to materialize");
        System.out.println();
        
        List<String> list = Arrays.asList("a", "b", "c");
        Collection<List<String>> sublists = SubLists.of(list);
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   Collection<List<String>> sublists = SubLists.of(list);");
        System.out.println("   Can iterate multiple times:");
        sublists.forEach(System.out::println);
        System.out.println("   Can check membership: " + sublists.contains(Arrays.asList("a", "b")));
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Prefer Collection to Stream as return type");
        System.out.println("2. Collection allows multiple iterations");
        System.out.println("3. Use Stream only for large/infinite sequences");
        System.out.println("4. Consider both Collection and Stream if appropriate");
    }
}

