package com.effectivejava.item45.usestreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

/**
 * Item 45: Use streams judiciously.
 * 
 * This demonstrates when to use streams vs iterative code.
 * 
 * Use streams when:
 * - Transforming a sequence of elements
 * - Filtering elements
 * - Combining elements
 * - Accumulating into collections
 * - Finding elements
 * 
 * Don't use streams when:
 * - You need to read or modify local variables
 * - You need to return from enclosing method
 * - You need to handle checked exceptions
 */
public class Anagrams {
    
    /**
     * ITERATIVE APPROACH: More verbose but sometimes clearer.
     */
    public static void printAnagramsIterative(List<String> words) {
        Map<String, Set<String>> groups = new HashMap<>();
        for (String word : words) {
            groups.computeIfAbsent(alphabetize(word), 
                (unused) -> new TreeSet<>()).add(word);
        }
        for (Set<String> group : groups.values()) {
            if (group.size() >= 2) {
                System.out.println(group.size() + ": " + group);
            }
        }
    }
    
    /**
     * STREAM APPROACH: More concise and functional.
     */
    public static void printAnagramsStream(List<String> words) {
        words.stream()
            .collect(groupingBy(word -> alphabetize(word)))
            .values().stream()
            .filter(group -> group.size() >= 2)
            .forEach(group -> System.out.println(group.size() + ": " + group));
    }
    
    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
    
    /**
     * Example showing stream pipeline.
     */
    public static void streamExample() {
        List<String> words = Arrays.asList("stop", "pots", "tops", "opts");
        
        // Stream pipeline: source -> intermediate ops -> terminal op
        words.stream()
            .filter(word -> word.length() > 3)
            .map(String::toUpperCase)
            .sorted()
            .forEach(System.out::println);
    }
}

