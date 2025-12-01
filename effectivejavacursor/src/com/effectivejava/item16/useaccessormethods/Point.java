package com.effectivejava.item16.useaccessormethods;

/**
 * Example of a class where public fields might be acceptable.
 * 
 * For package-private or private nested classes, public fields are acceptable
 * if they represent the abstraction directly.
 * 
 * However, even here, accessor methods are often better for consistency.
 */
class Point {
    // Package-private class - public fields might be acceptable
    // But accessor methods are still preferred for consistency
    public double x;
    public double y;
    
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

