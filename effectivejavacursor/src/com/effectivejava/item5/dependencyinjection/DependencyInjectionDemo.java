package com.effectivejava.item5.dependencyinjection;

import java.util.Set;

/**
 * Demonstration of Item 5: Prefer dependency injection to hardwiring resources.
 * 
 * This demo shows:
 * 1. The problem with hardwired dependencies
 * 2. How dependency injection solves the problem
 * 3. Benefits: testability, flexibility, reusability
 */
public class DependencyInjectionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 5: Prefer Dependency Injection ===\n");
        
        System.out.println("1. PROBLEM WITH HARDWIRED DEPENDENCIES:");
        System.out.println("   - Class creates its own dependencies");
        System.out.println("   - Cannot be tested with different implementations");
        System.out.println("   - Cannot be reused in different contexts");
        System.out.println("   - Violates dependency inversion principle");
        System.out.println();
        
        // Bad example
        System.out.println("2. BAD EXAMPLE (Hardwired Dependency):");
        System.out.println("   class SpellCheckerBad {");
        System.out.println("       private final Dictionary dict = new SimpleDictionary();");
        System.out.println("   }");
        System.out.println("   Problems:");
        System.out.println("   - Cannot test with mock dictionary");
        System.out.println("   - Cannot use different dictionary implementations");
        System.out.println("   - Tightly coupled to specific implementation");
        System.out.println();
        
        // Good example with dependency injection
        System.out.println("3. GOOD EXAMPLE (Dependency Injection):");
        Set<String> englishWords = Set.of("hello", "world", "java", "effective", "programming");
        SpellChecker.Dictionary englishDict = new SpellChecker.SimpleDictionary(englishWords);
        SpellChecker spellChecker = new SpellChecker(englishDict);
        
        System.out.println("   Dictionary dict = new SimpleDictionary(words);");
        System.out.println("   SpellChecker checker = new SpellChecker(dict);");
        System.out.println();
        
        System.out.println("   Testing spell checker:");
        System.out.println("   isValid(\"hello\") = " + spellChecker.isValid("hello"));
        System.out.println("   isValid(\"xyz\") = " + spellChecker.isValid("xyz"));
        System.out.println();
        
        // Different dictionary
        System.out.println("4. FLEXIBILITY - DIFFERENT DICTIONARIES:");
        Set<String> frenchWords = Set.of("bonjour", "monde", "java", "efficace");
        SpellChecker.Dictionary frenchDict = new SpellChecker.SimpleDictionary(frenchWords);
        SpellChecker frenchChecker = new SpellChecker(frenchDict);
        
        System.out.println("   Using French dictionary:");
        System.out.println("   isValid(\"bonjour\") = " + frenchChecker.isValid("bonjour"));
        System.out.println("   isValid(\"hello\") = " + frenchChecker.isValid("hello"));
        System.out.println();
        
        // Testing with mock
        System.out.println("5. TESTABILITY - MOCK DICTIONARY:");
        Set<String> testWords = Set.of("test", "mock");
        SpellChecker.Dictionary mockDict = new SpellChecker.MockDictionary(testWords);
        SpellChecker testChecker = new SpellChecker(mockDict);
        
        System.out.println("   Using mock dictionary for testing:");
        System.out.println("   isValid(\"test\") = " + testChecker.isValid("test"));
        System.out.println("   isValid(\"production\") = " + testChecker.isValid("production"));
        System.out.println();
        
        // Static factory with dependency injection
        System.out.println("6. STATIC FACTORY WITH DEPENDENCY INJECTION:");
        SpellChecker factoryChecker = createSpellChecker(englishWords);
        System.out.println("   SpellChecker checker = createSpellChecker(words);");
        System.out.println("   Still uses dependency injection, but through factory method");
        System.out.println("   isValid(\"java\"): " + factoryChecker.isValid("java"));
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Dependencies should be injected, not created internally");
        System.out.println("2. Use constructor injection for required dependencies");
        System.out.println("3. Use setter injection or builder for optional dependencies");
        System.out.println("4. Dependency injection enables:");
        System.out.println("   - Testability (can inject mocks)");
        System.out.println("   - Flexibility (can use different implementations)");
        System.out.println("   - Reusability (can be used in different contexts)");
        System.out.println("5. Avoid static utility classes and singletons for dependencies");
        System.out.println("   (unless the dependency is truly immutable and stateless)");
    }
    
    /**
     * Static factory method that still uses dependency injection.
     * The factory creates the dependency, but the class still receives it via injection.
     */
    private static SpellChecker createSpellChecker(Set<String> words) {
        SpellChecker.Dictionary dict = new SpellChecker.SimpleDictionary(words);
        return new SpellChecker(dict);
    }
}

