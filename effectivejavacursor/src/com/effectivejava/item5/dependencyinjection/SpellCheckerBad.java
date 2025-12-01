package com.effectivejava.item5.dependencyinjection;

import java.util.Set;

/**
 * BAD EXAMPLE: Spell checker with hardwired dependency.
 * 
 * This demonstrates the anti-pattern - the class creates its own dependency.
 * Problems:
 * 1. Cannot be tested with different dictionaries
 * 2. Cannot be reused with different dictionaries
 * 3. Hard to test (cannot inject mock dictionary)
 * 4. Violates dependency inversion principle
 */
public class SpellCheckerBad {
    
    // Hardwired dependency - BAD!
    private final SpellChecker.Dictionary dictionary = new SimpleDictionary();
    
    public boolean isValid(String word) {
        return dictionary.contains(word);
    }
    
    // Nested class - this is the hardwired dependency
    private static class SimpleDictionary implements SpellChecker.Dictionary {
        private final Set<String> words = Set.of("hello", "world", "java", "effective");
        
        @Override
        public boolean contains(String word) {
            return words.contains(word.toLowerCase());
        }
        
        @Override
        public Set<String> getSuggestions(String word) {
            return Set.of();
        }
    }
}

