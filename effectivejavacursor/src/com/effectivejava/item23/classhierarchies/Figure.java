package com.effectivejava.item23.classhierarchies;

/**
 * Item 23: Prefer class hierarchies to tagged classes.
 * 
 * This demonstrates the class hierarchy approach - the preferred way.
 * 
 * A tagged class is a class with a tag field indicating what kind of instance it is.
 * Tagged classes are verbose, error-prone, and inefficient.
 * 
 * SOLUTION: Use a class hierarchy instead.
 */
public abstract class Figure {
    abstract double area();
}

/**
 * Circle is a type of Figure.
 */
class Circle extends Figure {
    final double radius;
    
    Circle(double radius) {
        this.radius = radius;
    }
    
    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

/**
 * Rectangle is a type of Figure.
 */
class Rectangle extends Figure {
    final double length;
    final double width;
    
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
    
    @Override
    double area() {
        return length * width;
    }
}

/**
 * Square is a type of Rectangle.
 * This demonstrates the flexibility of class hierarchies.
 */
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}

