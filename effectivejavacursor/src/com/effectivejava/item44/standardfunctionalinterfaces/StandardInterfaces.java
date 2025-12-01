package com.effectivejava.item44.standardfunctionalinterfaces;

import java.util.function.*;

/**
 * Item 44: Favor the use of standard functional interfaces.
 * 
 * Java provides many standard functional interfaces in java.util.function.
 * Use them instead of creating your own.
 * 
 * Common standard functional interfaces:
 * - UnaryOperator<T>: T apply(T t)
 * - BinaryOperator<T>: T apply(T t1, T t2)
 * - Predicate<T>: boolean test(T t)
 * - Function<T,R>: R apply(T t)
 * - Supplier<T>: T get()
 * - Consumer<T>: void accept(T t)
 */
public class StandardInterfaces {
    
    /**
     * BAD: Custom functional interface.
     * Don't do this - use standard interfaces!
     */
    @FunctionalInterface
    interface MyFunction<T, R> {
        R apply(T t);
    }
    
    /**
     * GOOD: Use standard Function interface.
     */
    public static <T, R> R transform(T input, Function<T, R> function) {
        return function.apply(input);
    }
    
    /**
     * Example using standard interfaces.
     */
    public static void examples() {
        // Predicate
        Predicate<String> isEmpty = String::isEmpty;
        
        // Function
        Function<String, Integer> length = String::length;
        
        // Supplier
        Supplier<String> supplier = () -> "Hello";
        
        // Consumer
        Consumer<String> printer = System.out::println;
        
        // UnaryOperator
        UnaryOperator<String> upper = String::toUpperCase;
        
        // BinaryOperator
        BinaryOperator<Integer> sum = Integer::sum;
    }
}

