package com.effectivejava.item40.useoverride;

import java.util.HashSet;
import java.util.Set;

/**
 * Item 40: Consistently use the Override annotation.
 * 
 * This demonstrates the importance of @Override annotation.
 * 
 * PROBLEM: Without @Override, typos in method names aren't caught.
 * SOLUTION: Always use @Override when overriding methods.
 */
public class Bigram {
    private final char first;
    private final char second;
    
    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }
    
    /**
     * BAD: Missing @Override annotation.
     * This doesn't actually override equals - it's a new method!
     * The typo (Bigram instead of Object) isn't caught.
     */
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }
    
    /**
     * GOOD: With @Override annotation.
     * Compiler would catch the error if we had a typo.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) {
            return false;
        }
        Bigram b = (Bigram) o;
        return b.first == first && b.second == second;
    }
    
    @Override
    public int hashCode() {
        return 31 * first + second;
    }
    
    /**
     * Example showing the problem.
     */
    public static void demonstrate() {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new Bigram(ch, ch));
            }
        }
        System.out.println("Set size: " + s.size());  // Should be 26, but would be 260 without @Override
    }
}

