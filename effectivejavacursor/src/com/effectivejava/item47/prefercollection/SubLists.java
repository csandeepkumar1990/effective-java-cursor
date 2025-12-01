package com.effectivejava.item47.prefercollection;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Item 47: Prefer Collection to Stream as a return type.
 * 
 * Return Collection (or appropriate subtype) instead of Stream when:
 * - Users need to iterate multiple times
 * - Users need to use for-each loops
 * - Users need to check membership
 * 
 * Return Stream when:
 * - The sequence is too large to materialize
 * - The sequence is infinite
 * - The sequence is expensive to materialize
 */
public class SubLists {
    
    /**
     * Returns Collection - users can iterate multiple times.
     */
    public static <E> Collection<List<E>> of(List<E> list) {
        List<List<E>> result = new ArrayList<>();
        for (int start = 0; start < list.size(); start++) {
            for (int end = start + 1; end <= list.size(); end++) {
                result.add(list.subList(start, end));
            }
        }
        return result;
    }
    
    /**
     * Returns Stream - for large or infinite sequences.
     */
    public static <E> Stream<List<E>> ofStream(List<E> list) {
        return Stream.concat(Stream.of(Collections.emptyList()),
            prefixes(list).flatMap(SubLists::suffixes));
    }
    
    private static <E> Stream<List<E>> prefixes(List<E> list) {
        return IntStream.rangeClosed(1, list.size())
            .mapToObj(end -> list.subList(0, end));
    }
    
    private static <E> Stream<List<E>> suffixes(List<E> list) {
        return IntStream.range(0, list.size())
            .mapToObj(start -> list.subList(start, list.size()));
    }
}

