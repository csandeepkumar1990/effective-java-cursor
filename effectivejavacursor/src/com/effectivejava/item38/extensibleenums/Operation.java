package com.effectivejava.item38.extensibleenums;

/**
 * Item 38: Emulate extensible enums with interfaces.
 * 
 * Since enums can't be extended, use interfaces to emulate extensibility.
 * 
 * This demonstrates the basic operation interface.
 */
public interface Operation {
    double apply(double x, double y);
}

/**
 * Basic operations enum implementing the interface.
 */
enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    TIMES("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };
    
    private final String symbol;
    
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return symbol;
    }
}

/**
 * Extended operations enum - can add new operations!
 */
enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) { return Math.pow(x, y); }
    },
    REMAINDER("%") {
        public double apply(double x, double y) { return x % y; }
    };
    
    private final String symbol;
    
    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }
    
    @Override
    public String toString() {
        return symbol;
    }
}

