package com.effectivejava.item36.useenumset;

import java.util.EnumSet;
import java.util.Set;

/**
 * Item 36: Use EnumSet instead of bit fields.
 * 
 * BAD: Using bit fields (int constants with bit flags)
 * GOOD: Using EnumSet
 * 
 * Advantages of EnumSet:
 * - Type-safe
 * - More readable
 * - More efficient than HashSet
 * - Can be used in APIs that accept Set
 */
public enum Style {
    BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
}

class Text {
    /**
     * BAD: Using bit fields.
     * Not type-safe, hard to use, limited to 32 or 64 flags.
     */
    public static final int STYLE_BOLD = 1 << 0;  // 1
    public static final int STYLE_ITALIC = 1 << 1;  // 2
    public static final int STYLE_UNDERLINE = 1 << 2;  // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;  // 8
    
    // Parameter can be STYLE_BOLD | STYLE_ITALIC
    public void applyStylesBad(int styles) {
        // Implementation
    }
    
    /**
     * GOOD: Using EnumSet.
     * Type-safe, readable, efficient.
     */
    public void applyStyles(Set<Style> styles) {
        // Implementation
    }
    
    /**
     * Example usage:
     * text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
     */
}

