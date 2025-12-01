package com.effectivejava.item58.preferforeach;

import java.util.*;

/**
 * Item 58: Prefer for-each loops to traditional for loops.
 * 
 * Enhanced for loops (for-each) are:
 * - More concise
 * - Less error-prone
 * - No performance penalty
 * 
 * Use traditional for loops when:
 * - You need to remove elements
 * - You need to replace elements
 * - You need parallel iteration
 */
public class LoopExample {
    
    /**
     * BAD: Traditional for loop.
     * Error-prone and verbose.
     */
    public void traditionalLoop(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            // Process element
        }
    }
    
    /**
     * GOOD: Enhanced for loop.
     * Concise and safe.
     */
    public void enhancedLoop(List<String> list) {
        for (String element : list) {
            // Process element
        }
    }
    
    /**
     * BAD: Iterator with potential bug.
     */
    public void iteratorLoopBad(List<String> list) {
        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            String element = i.next();
            // Process element
        }
    }
    
    /**
     * GOOD: Enhanced for loop with iterator.
     */
    public void enhancedLoopGood(Collection<String> collection) {
        for (String element : collection) {
            // Process element
        }
    }
    
    /**
     * When you need index: Use traditional for loop.
     */
    public void withIndex(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ": " + list.get(i));
        }
    }
    
    /**
     * Nested loops example.
     */
    public void nestedLoops(List<Card> deck, List<Card> hand) {
        // BAD: Traditional nested loops
        for (Iterator<Card> i = deck.iterator(); i.hasNext(); ) {
            Card card = i.next();
            for (Iterator<Card> j = hand.iterator(); j.hasNext(); ) {
                Card handCard = j.next();
                if (card.equals(handCard)) {
                    // Bug: uses i instead of j!
                }
            }
        }
        
        // GOOD: Enhanced for loops
        for (Card card : deck) {
            for (Card handCard : hand) {
                if (card.equals(handCard)) {
                    // Clear and correct
                }
            }
        }
    }
    
    private static class Card {
        // Card implementation
    }
}

