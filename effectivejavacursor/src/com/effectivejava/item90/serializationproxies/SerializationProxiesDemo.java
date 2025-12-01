package com.effectivejava.item90.serializationproxies;

import java.util.Date;

/**
 * Demonstration of Item 90: Consider serialization proxies.
 */
public class SerializationProxiesDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 90: Consider Serialization Proxies ===\n");
        
        System.out.println("1. SERIALIZATION PROXY PATTERN:");
        System.out.println("   1. Create private static nested class (SerializationProxy)");
        System.out.println("   2. Implement writeReplace() to return proxy");
        System.out.println("   3. Implement readResolve() in proxy to return real object");
        System.out.println("   4. Make class final and throw InvalidObjectException in readObject");
        System.out.println();
        
        System.out.println("2. BENEFITS:");
        System.out.println("   - Eliminates extralinguistic attack surface");
        System.out.println("   - Allows fields to be final");
        System.out.println("   - Handles versioning better");
        System.out.println("   - More secure");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        Date start = new Date();
        Date end = new Date(start.getTime() + 86400000);
        Period period = new Period(start, end);
        System.out.println("   Period created: " + period.start() + " to " + period.end());
        System.out.println("   (Serialization uses proxy pattern)");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Consider serialization proxy pattern");
        System.out.println("2. More secure than direct serialization");
        System.out.println("3. Allows final fields");
        System.out.println("4. Better versioning support");
    }
}

