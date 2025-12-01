package com.effectivejava.item25.singletoplevelclass;

/**
 * Item 25: Limit source files to a single top-level class.
 * 
 * This file contains only one top-level class - the correct approach.
 * 
 * PROBLEM: Multiple top-level classes in one file
 * - Can cause compilation errors
 * - Order of compilation matters
 * - Confusing and error-prone
 * 
 * SOLUTION: One top-level class per source file
 */
public class Utensil {
    static final String NAME = "pot";
}

