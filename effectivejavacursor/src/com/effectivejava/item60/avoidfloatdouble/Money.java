package com.effectivejava.item60.avoidfloatdouble;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Item 60: Avoid float and double if exact answers are required.
 * 
 * PROBLEM: float and double use binary floating-point arithmetic.
 * They cannot represent many decimal values exactly.
 * 
 * SOLUTION: Use BigDecimal for exact decimal calculations.
 * 
 * Use float/double when:
 * - Performance is critical
 * - Exact precision isn't required
 * - Scientific calculations
 * 
 * Use BigDecimal when:
 * - Money calculations
 * - Exact decimal precision required
 * - Financial applications
 */
public class Money {
    
    /**
     * BAD: Using double for money.
     * This doesn't work correctly!
     */
    public static void badMoneyExample() {
        System.out.println("BAD: Using double for money");
        double funds = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; funds >= price; price += 0.10) {
            funds -= price;
            itemsBought++;
        }
        System.out.println("Items bought: " + itemsBought);
        System.out.println("Change: $" + funds);
        // Output: Items bought: 3, Change: $0.3999999999999999
        // WRONG! Should be $0.40
    }
    
    /**
     * GOOD: Using BigDecimal for money.
     * This works correctly!
     */
    public static void goodMoneyExample() {
        System.out.println("GOOD: Using BigDecimal for money");
        final BigDecimal TEN_CENTS = new BigDecimal("0.10");
        BigDecimal funds = new BigDecimal("1.00");
        int itemsBought = 0;
        for (BigDecimal price = TEN_CENTS; funds.compareTo(price) >= 0; 
             price = price.add(TEN_CENTS)) {
            funds = funds.subtract(price);
            itemsBought++;
        }
        System.out.println("Items bought: " + itemsBought);
        System.out.println("Change: $" + funds);
        // Output: Items bought: 3, Change: $0.40
        // CORRECT!
    }
    
    /**
     * Alternative: Use int or long for cents.
     * More efficient than BigDecimal for simple cases.
     */
    public static void centsExample() {
        System.out.println("ALTERNATIVE: Using int for cents");
        int fundsCents = 100;  // $1.00
        int itemsBought = 0;
        for (int priceCents = 10; fundsCents >= priceCents; priceCents += 10) {
            fundsCents -= priceCents;
            itemsBought++;
        }
        System.out.println("Items bought: " + itemsBought);
        System.out.println("Change: " + fundsCents + " cents");
    }
}

