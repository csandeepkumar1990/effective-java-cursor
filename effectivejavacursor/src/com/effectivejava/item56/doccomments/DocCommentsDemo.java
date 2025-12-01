package com.effectivejava.item56.doccomments;

/**
 * Demonstration of Item 56: Write doc comments for all exposed API elements.
 */
public class DocCommentsDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 56: Write Doc Comments ===\n");
        
        System.out.println("1. RULE:");
        System.out.println("   Every exported class, interface, constructor,");
        System.out.println("   method, and field should have a doc comment");
        System.out.println();
        
        System.out.println("2. JAVADOC CONVENTIONS:");
        System.out.println("   - Summary sentence (first sentence)");
        System.out.println("   - Detailed description");
        System.out.println("   - @param for parameters");
        System.out.println("   - @return for return values");
        System.out.println("   - @throws for exceptions");
        System.out.println("   - @since for version");
        System.out.println("   - @see for references");
        System.out.println();
        
        System.out.println("3. EXAMPLE:");
        System.out.println("   See MathUtils.gcd() and MathUtils.factorial()");
        System.out.println("   for examples of proper JavaDoc comments");
        System.out.println();
        
        int result = MathUtils.gcd(48, 18);
        System.out.println("   gcd(48, 18) = " + result);
        System.out.println();
        
        System.out.println("4. BEST PRACTICES:");
        System.out.println("   - Use {@code} for code elements");
        System.out.println("   - Use {@link} for cross-references");
        System.out.println("   - Use HTML tags sparingly");
        System.out.println("   - Keep it concise but complete");
        System.out.println();
        
        System.out.println("=== Key Takeaways ===");
        System.out.println("1. Document all exported API elements");
        System.out.println("2. Follow JavaDoc conventions");
        System.out.println("3. Include summary, description, and tags");
        System.out.println("4. Keep comments up to date with code");
    }
}

