package com.effectivejava.item62.avoidstrings;

/**
 * Item 62: Avoid strings where other types are more appropriate.
 * 
 * Don't use strings as:
 * - Types (use enums, classes, or interfaces)
 * - Capability keys (use separate types)
 * - Aggregate types (use classes)
 * 
 * Strings are poor substitutes for:
 * - Types
 * - Enumerations
 * - Aggregate types
 * - Capabilities
 */
public class ThreadLocal {
    
    /**
     * BAD: Using String as a type.
     * No type safety, no compile-time checking.
     */
    public static class BadThreadLocal {
        private String value;
        
        public void set(String value) {
            this.value = value;
        }
        
        public String get() {
            return value;
        }
    }
    
    /**
     * GOOD: Using a proper type parameter.
     * Type-safe and checked at compile time.
     */
    public static class GoodThreadLocal<T> {
        private T value;
        
        public void set(T value) {
            this.value = value;
        }
        
        public T get() {
            return value;
        }
    }
    
    /**
     * BAD: Using String for aggregate type.
     */
    public static String compoundKeyBad(String className, String methodName) {
        return className + "#" + methodName;  // Fragile!
    }
    
    /**
     * GOOD: Using a proper class.
     */
    public static class CompoundKey {
        private final String className;
        private final String methodName;
        
        public CompoundKey(String className, String methodName) {
            this.className = className;
            this.methodName = methodName;
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof CompoundKey)) return false;
            CompoundKey ck = (CompoundKey) o;
            return ck.className.equals(className) && ck.methodName.equals(methodName);
        }
        
        @Override
        public int hashCode() {
            return className.hashCode() * 31 + methodName.hashCode();
        }
    }
}

