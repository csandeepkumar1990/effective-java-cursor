package com.effectivejava.item39.preferannotations;

/**
 * Example class using annotations instead of naming patterns.
 */
public class Sample {
    
    @Test
    public static void m1() {
        // Test should pass
    }
    
    public static void m2() {
        // Not a test
    }
    
    @Test
    public static void m3() {
        // Test should fail
        throw new RuntimeException("Boom");
    }
    
    public static void m4() {
        // Not a test
    }
    
    @Test
    public void m5() {
        // Invalid: non-static
    }
    
    public static void m6() {
        // Not a test
    }
    
    @Test
    public static void m7() {
        // Test should fail
        throw new RuntimeException("Crash");
    }
    
    public static void m8() {
        // Not a test
    }
    
    @ExceptionTest(ArithmeticException.class)
    public static void m9() {
        int i = 0;
        i = i / i;  // Should throw ArithmeticException
    }
    
    @ExceptionTest(ArithmeticException.class)
    public static void m10() {
        int[] a = new int[0];
        int i = a[1];  // Should throw ArrayIndexOutOfBoundsException
    }
}

