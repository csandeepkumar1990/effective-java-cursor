package com.effectivejava.item39.preferannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Item 39: Prefer annotations to naming patterns.
 * 
 * This demonstrates a test annotation - much better than naming patterns like testMethodName().
 * 
 * BAD: Naming patterns (testMethodName, TEST_METHOD_NAME)
 * - Typos aren't caught
 * - No way to pass parameters
 * - No tool support
 * 
 * GOOD: Annotations
 * - Type-safe
 * - Tool support
 * - Can pass parameters
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    // Marker annotation - no parameters
}

/**
 * Annotation with parameters.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTest {
    Class<? extends Throwable> value();
}

/**
 * Repeatable annotation (Java 8+).
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ExceptionTests {
    ExceptionTest[] value();
}

