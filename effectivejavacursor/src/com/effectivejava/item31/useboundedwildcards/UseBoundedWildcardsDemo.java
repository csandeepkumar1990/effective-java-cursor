package com.effectivejava.item31.useboundedwildcards;

/**
 * Demonstration of Item 31: Use bounded wildcards to increase API flexibility.
 */
public class UseBoundedWildcardsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 31: Use Bounded Wildcards ===\n");
        
        System.out.println("1. PECS: producer-extends, consumer-super");
        System.out.println("   - If a parameterized type represents a T producer,");
        System.out.println("     use <? extends T>");
        System.out.println("   - If a parameterized type represents a T consumer,");
        System.out.println("     use <? super T>");
        System.out.println();
        
        System.out.println("2. PRODUCER-EXTENDS:");
        System.out.println("   void pushAll(Iterable<? extends E> src)");
        System.out.println("   Can pushAll from Collection<Integer> to Stack<Number>");
        System.out.println();
        
        System.out.println("3. CONSUMER-SUPER:");
        System.out.println("   void popAll(Collection<? super E> dst)");
        System.out.println("   Can popAll from Stack<Number> to Collection<Object>");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use bounded wildcards to increase API flexibility");
        System.out.println("2. Remember PECS: producer-extends, consumer-super");
        System.out.println("3. Don't use wildcards in return types");
        System.out.println("4. If a type parameter appears only once, use wildcard");
    }
}

