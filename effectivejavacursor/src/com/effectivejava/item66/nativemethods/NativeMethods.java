package com.effectivejava.item66.nativemethods;

/**
 * Item 66: Use native methods judiciously.
 * 
 * Native methods (JNI) have disadvantages:
 * - Not portable
 * - Hard to debug
 * - Performance overhead (JNI boundary crossing)
 * - Security risks
 * - Hard to maintain
 * 
 * Use native methods only when:
 * - Accessing platform-specific features
 * - Accessing legacy code
 * - Performance-critical code (but measure first!)
 * 
 * Modern Java has better alternatives for most use cases.
 */
public class NativeMethods {
    
    /**
     * BAD: Using native method unnecessarily.
     * Modern Java has better alternatives.
     */
    // public native void doSomething();  // BAD - use Java instead
    
    /**
     * GOOD: Using Java API.
     * Portable, maintainable, and often faster.
     */
    public void doSomethingGood() {
        // Use Java API instead
        System.out.println("Using Java API");
    }
    
    /**
     * When native methods might be appropriate:
     * - Accessing platform-specific libraries
     * - Legacy code integration
     * - Performance-critical operations (after profiling)
     */
    // Example: Accessing native library
    // static {
    //     System.loadLibrary("nativeLib");
    // }
    // public native int nativeOperation(int input);
}

