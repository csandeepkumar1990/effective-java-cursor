package com.effectivejava.item1;

/**
 * Demonstration class showing various uses of static factory methods.
 * This class illustrates the advantages and use cases discussed in Item 1.
 */
public class StaticFactoryDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Static Factory Methods Demo ===\n");
        
        // 1. Boolean example - cached instances
        System.out.println("1. Boolean Example (Cached Instances):");
        BooleanExample.demonstrate();
        System.out.println();
        
        // 2. BigInteger example - named methods for clarity
        System.out.println("2. BigInteger Example (Named Methods for Clarity):");
        BigIntegerExample.demonstrate();
        System.out.println();
        
        // 3. Point example - named methods and flexibility
        System.out.println("3. Point Example (Named Methods):");
        Point cartesian = Point.fromCartesian(3.0, 4.0);
        Point polar = Point.fromPolar(5.0, Math.PI / 4);
        Point origin = Point.origin();
        Point fromString = Point.fromString("10, 20");
        Point invalid = Point.fromString(null);
        
        System.out.println("Cartesian: " + cartesian);
        System.out.println("Polar: " + polar);
        System.out.println("Origin: " + origin);
        System.out.println("From String: " + fromString);
        System.out.println("Invalid (null): " + invalid);
        System.out.println();
        
        // 4. Number example - returning subtypes
        System.out.println("3. Number Example (Returning Subtypes):");
        Number intNum = Number.valueOf("42");
        Number doubleNum = Number.valueOf("3.14");
        System.out.println("Integer number: " + intNum + " (type: " + intNum.getClass().getSimpleName() + ")");
        System.out.println("Double number: " + doubleNum + " (type: " + doubleNum.getClass().getSimpleName() + ")");
        System.out.println();
        
        // 5. Service Provider example
        System.out.println("5. Service Provider Example:");
        ServiceProvider.registerService("database", new ServiceProvider.DatabaseService());
        ServiceProvider.registerService("email", new ServiceProvider.EmailService());
        
        ServiceProvider.getService("database").execute();
        ServiceProvider.getService("email").execute();
        System.out.println();
        
        // 6. Advantages summary
        System.out.println("=== Advantages of Static Factory Methods ===");
        System.out.println("1. They have names (better readability)");
        System.out.println("2. They are not required to create a new object each time");
        System.out.println("3. They can return an object of any subtype of their return type");
        System.out.println("4. The class of the returned object can vary from call to call");
        System.out.println("5. The class of the returned object need not exist when the factory method is written");
        System.out.println();
        
        System.out.println("=== Disadvantages ===");
        System.out.println("1. Classes without public or protected constructors cannot be subclassed");
        System.out.println("2. They are harder to find in documentation (compared to constructors)");
    }
}

