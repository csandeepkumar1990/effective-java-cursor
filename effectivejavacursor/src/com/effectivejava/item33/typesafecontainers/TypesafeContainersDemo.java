package com.effectivejava.item33.typesafecontainers;

/**
 * Demonstration of Item 33: Consider typesafe heterogeneous containers.
 */
public class TypesafeContainersDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 33: Typesafe Heterogeneous Containers ===\n");
        
        System.out.println("1. CONCEPT:");
        System.out.println("   A container that can hold different types");
        System.out.println("   while preserving type safety");
        System.out.println();
        
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);
        
        System.out.println("2. EXAMPLE:");
        System.out.println("   Favorites f = new Favorites();");
        System.out.println("   f.putFavorite(String.class, \"Java\");");
        System.out.println("   f.putFavorite(Integer.class, 0xcafebabe);");
        System.out.println();
        
        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);
        
        System.out.println("   String: " + favoriteString);
        System.out.println("   Integer: " + Integer.toHexString(favoriteInteger));
        System.out.println("   Class: " + favoriteClass.getName());
        System.out.println("   (All type-safe, no casting needed)");
        System.out.println();
        
        System.out.println("3. KEY:");
        System.out.println("   Use Class<T> as the key type");
        System.out.println("   This preserves type information");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Use Class<T> as key for typesafe heterogeneous containers");
        System.out.println("2. This pattern allows type-safe storage of multiple types");
        System.out.println("3. Useful when you need a container that can hold different types");
        System.out.println("4. Limitations: Can't use non-reifiable types (e.g., List<String>)");
    }
}

