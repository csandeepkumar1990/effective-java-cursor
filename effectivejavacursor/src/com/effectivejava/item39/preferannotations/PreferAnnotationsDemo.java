package com.effectivejava.item39.preferannotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Demonstration of Item 39: Prefer annotations to naming patterns.
 */
public class PreferAnnotationsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 39: Prefer Annotations to Naming Patterns ===\n");
        
        System.out.println("1. PROBLEM WITH NAMING PATTERNS:");
        System.out.println("   - Typos aren't caught");
        System.out.println("   - No way to pass parameters");
        System.out.println("   - No tool support");
        System.out.println();
        
        System.out.println("2. SOLUTION: ANNOTATIONS");
        System.out.println("   - Type-safe");
        System.out.println("   - Tool support");
        System.out.println("   - Can pass parameters");
        System.out.println();
        
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Sample.class;
        
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception exc) {
                    System.out.println("Invalid @Test: " + m);
                }
            }
        }
        
        System.out.println("3. TEST RESULTS:");
        System.out.println("   Tests run: " + tests);
        System.out.println("   Tests passed: " + passed);
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use annotations instead of naming patterns");
        System.out.println("2. Annotations are type-safe and tool-friendly");
        System.out.println("3. Can pass parameters to annotations");
        System.out.println("4. Use @Retention and @Target appropriately");
    }
}

