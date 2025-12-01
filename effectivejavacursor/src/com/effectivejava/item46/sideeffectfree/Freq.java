package com.effectivejava.item46.sideeffectfree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Item 46: Prefer side-effect-free functions in streams.
 * 
 * Streams should be functional - avoid side effects.
 * 
 * BAD: Using forEach with side effects
 * GOOD: Using collectors to accumulate results
 */
public class Freq {
    
    /**
     * BAD: Using forEach with side effects.
     * This is not functional programming.
     */
    public static Map<String, Long> badWay(Stream<String> words) {
        Map<String, Long> freq = new HashMap<>();
        words.forEach(word -> 
            freq.merge(word.toLowerCase(), 1L, Long::sum));  // Side effect!
        return freq;
    }
    
    /**
     * GOOD: Using collectors - side-effect-free.
     * This is functional programming.
     */
    public static Map<String, Long> goodWay(Stream<String> words) {
        return words.collect(groupingBy(String::toLowerCase, counting()));
    }
    
    /**
     * Example: Top ten words.
     */
    public static List<String> topTen(Stream<String> words) {
        return words.collect(groupingBy(String::toLowerCase, counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(10)
            .map(Map.Entry::getKey)
            .collect(toList());
    }
}

