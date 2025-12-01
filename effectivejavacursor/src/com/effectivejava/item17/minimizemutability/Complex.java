package com.effectivejava.item17.minimizemutability;

/**
 * Item 17: Minimize mutability.
 * 
 * Rules for immutable classes:
 * 1. Don't provide methods that modify the object's state
 * 2. Ensure the class can't be extended
 * 3. Make all fields final
 * 4. Make all fields private
 * 5. Ensure exclusive access to any mutable components
 * 
 * Benefits:
 * - Thread-safe (no synchronization needed)
 * - Can be shared freely
 * - No defensive copies needed
 * - Can cache hash codes
 * - Make great map keys and set elements
 */
public final class Complex {
    private final double re;
    private final double im;
    
    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);
    
    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }
    
    // Accessors with no corresponding mutators
    public double realPart() { return re; }
    public double imaginaryPart() { return im; }
    
    // Functional approach - returns new instance instead of modifying
    public Complex plus(Complex c) {
        return new Complex(re + c.re, im + c.im);
    }
    
    public Complex minus(Complex c) {
        return new Complex(re - c.re, im - c.im);
    }
    
    public Complex times(Complex c) {
        return new Complex(re * c.re - im * c.im,
                          re * c.im + im * c.re);
    }
    
    public Complex dividedBy(Complex c) {
        double tmp = c.re * c.re + c.im * c.im;
        return new Complex((re * c.re + im * c.im) / tmp,
                          (im * c.re - re * c.im) / tmp);
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Complex)) return false;
        Complex c = (Complex) o;
        return Double.compare(c.re, re) == 0 &&
               Double.compare(c.im, im) == 0;
    }
    
    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }
    
    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }
}

