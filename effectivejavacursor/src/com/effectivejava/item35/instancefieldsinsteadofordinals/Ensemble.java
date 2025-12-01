package com.effectivejava.item35.instancefieldsinsteadofordinals;

/**
 * Item 35: Use instance fields instead of ordinals.
 * 
 * BAD: Using ordinal() to derive values.
 * PROBLEM: If you reorder enum constants, the values change!
 * 
 * SOLUTION: Store the value in an instance field.
 */
public enum Ensemble {
    SOLO(1),
    DUET(2),
    TRIO(3),
    QUARTET(4),
    QUINTET(5),
    SEXTET(6),
    SEPTET(7),
    OCTET(8),
    DOUBLE_QUARTET(8),
    NONET(9),
    DECTET(10),
    TRIPLE_QUARTET(12);
    
    private final int numberOfMusicians;
    
    Ensemble(int size) {
        this.numberOfMusicians = size;
    }
    
    public int numberOfMusicians() {
        return numberOfMusicians;
    }
    
    /**
     * BAD: Don't do this!
     * If you reorder constants, values change.
     */
    // public int numberOfMusicians() {
    //     return ordinal() + 1;  // BAD!
    // }
}

