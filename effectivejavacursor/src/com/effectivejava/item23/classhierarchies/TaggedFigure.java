package com.effectivejava.item23.classhierarchies;

/**
 * BAD EXAMPLE: Tagged class.
 * 
 * This demonstrates the anti-pattern - a class with a tag field.
 * Problems:
 * - Verbose and error-prone
 * - Inefficient (carries unused fields)
 * - Not type-safe
 * - Hard to extend
 */
class TaggedFigure {
    enum Shape { RECTANGLE, CIRCLE }
    
    // Tag field
    final Shape shape;
    
    // Fields for RECTANGLE
    double length;
    double width;
    
    // Fields for CIRCLE
    double radius;
    
    // Constructor for RECTANGLE
    TaggedFigure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }
    
    // Constructor for CIRCLE
    TaggedFigure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }
    
    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * radius * radius;
            default:
                throw new AssertionError(shape);
        }
    }
}

