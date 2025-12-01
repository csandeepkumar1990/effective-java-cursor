package com.effectivejava.item33.typesafecontainers;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Item 33: Consider typesafe heterogeneous containers.
 * 
 * This demonstrates a typesafe heterogeneous container pattern.
 * The container can hold different types, and the type is preserved.
 * 
 * Key: Use Class<T> as the key type.
 */
public class Favorites {
    private Map<Class<?>, Object> favorites = new HashMap<>();
    
    /**
     * Put a favorite instance of type T.
     * Type safety is ensured by the Class<T> key.
     */
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }
    
    /**
     * Get a favorite instance of type T.
     * Type safety is ensured by the Class<T> key.
     */
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
    
    /**
     * Example usage:
     * Favorites f = new Favorites();
     * f.putFavorite(String.class, "Java");
     * f.putFavorite(Integer.class, 0xcafebabe);
     * String favoriteString = f.getFavorite(String.class);
     * int favoriteInteger = f.getFavorite(Integer.class);
     */
}

