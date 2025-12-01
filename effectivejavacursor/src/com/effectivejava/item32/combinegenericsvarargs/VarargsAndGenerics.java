package com.effectivejava.item32.combinegenericsvarargs;

import java.util.ArrayList;
import java.util.List;

/**
 * Item 32: Combine generics and varargs judiciously.
 * 
 * PROBLEM: Varargs and generics don't mix well.
 * - Varargs creates an array
 * - Arrays and generics don't mix (Item 28)
 * - Can cause heap pollution
 * 
 * SOLUTION: Use @SafeVarargs annotation when method is safe.
 */
public class VarargsAndGenerics {
    
    /**
     * UNSAFE: Heap pollution possible.
     * The varargs parameter creates an array, which can be unsafe with generics.
     */
    @SafeVarargs  // Don't use this unless method is actually safe!
    public static <T> List<T> flattenUnsafe(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
    
    /**
     * SAFE: No heap pollution.
     * Method doesn't store anything in the varargs array.
     * Only reads from it.
     */
    @SafeVarargs
    public static <T> List<T> flattenSafe(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
    
    /**
     * ALTERNATIVE: Use List instead of varargs.
     * This avoids the problem entirely.
     */
    public static <T> List<T> flatten(List<List<? extends T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists) {
            result.addAll(list);
        }
        return result;
    }
}

