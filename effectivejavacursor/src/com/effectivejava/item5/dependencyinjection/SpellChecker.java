package com.effectivejava.item5.dependencyinjection;

import java.util.Objects;
import java.util.Set;

/**
 * Item 5: Prefer dependency injection to hardwiring resources.
 * 
 * This class demonstrates dependency injection - a pattern where dependencies
 * are provided to a class rather than the class creating them itself.
 * 
 * BAD APPROACH (hardwired dependency):
 * - SpellChecker creates its own dictionary
 * - Cannot be tested with different dictionaries
 * - Cannot be reused with different dictionaries
 * 
 * GOOD APPROACH (dependency injection):
 * - Dictionary is passed to constructor
 * - Can be tested with mock dictionaries
 * - Can be reused with different dictionaries
 * - More flexible and testable
 */
public class SpellChecker {
    
    private final Dictionary dictionary;
    
    /**
     * Constructor with dependency injection.
     * The dictionary is injected rather than created internally.
     * 
     * @param dictionary the dictionary to use for spell checking
     * @throws NullPointerException if dictionary is null
     */
    public SpellChecker(Dictionary dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary, "Dictionary cannot be null");
    }
    
    /**
     * Checks if a word is valid according to the dictionary.
     * 
     * @param word the word to check
     * @return true if the word is in the dictionary, false otherwise
     */
    public boolean isValid(String word) {
        return dictionary.contains(word);
    }
    
    /**
     * Suggests corrections for a misspelled word.
     * 
     * @param word the misspelled word
     * @return set of suggested corrections
     */
    public Set<String> suggestCorrections(String word) {
        return dictionary.getSuggestions(word);
    }
    
    /**
     * Interface for dictionary implementations.
     * This allows different dictionary implementations to be injected.
     */
    public interface Dictionary {
        boolean contains(String word);
        Set<String> getSuggestions(String word);
    }
    
    /**
     * Simple dictionary implementation using a set of words.
     */
    public static class SimpleDictionary implements Dictionary {
        private final Set<String> words;
        
        public SimpleDictionary(Set<String> words) {
            this.words = Objects.requireNonNull(words);
        }
        
        @Override
        public boolean contains(String word) {
            return words.contains(word.toLowerCase());
        }
        
        @Override
        public Set<String> getSuggestions(String word) {
            // Simple implementation - return words that start with same letter
            return words.stream()
                .filter(w -> w.toLowerCase().startsWith(word.toLowerCase().substring(0, 1)))
                .limit(5)
                .collect(java.util.stream.Collectors.toSet());
        }
    }
    
    /**
     * Mock dictionary for testing purposes.
     */
    public static class MockDictionary implements Dictionary {
        private final Set<String> words;
        
        public MockDictionary(Set<String> words) {
            this.words = Objects.requireNonNull(words);
        }
        
        @Override
        public boolean contains(String word) {
            return words.contains(word.toLowerCase());
        }
        
        @Override
        public Set<String> getSuggestions(String word) {
            return java.util.Collections.emptySet();
        }
    }
}

