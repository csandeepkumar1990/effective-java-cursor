package com.effectivejava.item55.returnoptionals;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

/**
 * Item 55: Return optionals judiciously.
 * 
 * Optional<T> represents a value that may or may not be present.
 * 
 * Use Optional when:
 * - A method might not return a value
 * - The client must check for absence
 * - More expressive than returning null
 * 
 * Don't use Optional when:
 * - Performance is critical (Optional has overhead)
 * - For collections, arrays, or other containers (return empty instead)
 * - For primitive types (use OptionalInt, OptionalLong, OptionalDouble)
 */
public class Max {
    
    /**
     * BAD: Returns null.
     * Client must check for null.
     */
    public static <E extends Comparable<E>> E maxBad(Collection<E> c) {
        if (c.isEmpty()) {
            return null;  // BAD: Returns null
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = e;
            }
        }
        return result;
    }
    
    /**
     * GOOD: Returns Optional.
     * Client must handle absence explicitly.
     */
    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        if (c.isEmpty()) {
            return Optional.empty();
        }
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = e;
            }
        }
        return Optional.of(result);
    }
    
    /**
     * BETTER: Using stream.
     */
    public static <E extends Comparable<E>> Optional<E> maxStream(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }
    
    /**
     * Example usage.
     */
    public static void example() {
        Collection<String> words = java.util.Arrays.asList("hello", "world", "java");
        Optional<String> maxWord = max(words);
        
        // Handle presence
        if (maxWord.isPresent()) {
            System.out.println("Max: " + maxWord.get());
        }
        
        // Or use ifPresent
        maxWord.ifPresent(word -> System.out.println("Max: " + word));
        
        // Or use orElse
        String result = maxWord.orElse("No words");
    }
}

