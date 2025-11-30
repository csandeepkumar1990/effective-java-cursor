package com.effectivejava.item2;

/**
 * Demonstration class showing the three approaches to handling many constructor parameters:
 * 1. Telescoping constructor pattern
 * 2. JavaBeans pattern
 * 3. Builder pattern (recommended)
 */
public class BuilderPatternDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 2: Builder Pattern Demo ===\n");
        
        // 1. Telescoping Constructor Pattern
        System.out.println("1. TELESCOPING CONSTRUCTOR PATTERN:");
        System.out.println("   Problems:");
        System.out.println("   - Hard to read: what do all those values mean?");
        System.out.println("   - Must carefully count parameters");
        System.out.println("   - Easy to mix up parameters of same type");
        System.out.println("   - Forced to pass values for parameters you don't want to set");
        System.out.println();
        
        NutritionFactsTelescoping cocaCola1 = 
            new NutritionFactsTelescoping(240, 8, 100, 0, 35, 27);
        System.out.println("   Example:");
        System.out.println("   new NutritionFactsTelescoping(240, 8, 100, 0, 35, 27)");
        System.out.println("   What does each number mean? Hard to tell!");
        System.out.println("   Result: " + cocaCola1);
        System.out.println();
        
        // 2. JavaBeans Pattern
        System.out.println("2. JAVABEANS PATTERN:");
        System.out.println("   Problems:");
        System.out.println("   - Object may be in inconsistent state during construction");
        System.out.println("   - Cannot make class immutable");
        System.out.println("   - Requires thread safety effort");
        System.out.println("   - Verbose (multiple method calls)");
        System.out.println();
        
        NutritionFactsJavaBeans cocaCola2 = new NutritionFactsJavaBeans();
        cocaCola2.setServingSize(240);
        cocaCola2.setServings(8);
        cocaCola2.setCalories(100);
        cocaCola2.setSodium(35);
        cocaCola2.setCarbohydrate(27);
        System.out.println("   Example:");
        System.out.println("   NutritionFactsJavaBeans cocaCola = new NutritionFactsJavaBeans();");
        System.out.println("   cocaCola.setServingSize(240);");
        System.out.println("   cocaCola.setServings(8);");
        System.out.println("   cocaCola.setCalories(100);");
        System.out.println("   cocaCola.setSodium(35);");
        System.out.println("   cocaCola.setCarbohydrate(27);");
        System.out.println("   Result: " + cocaCola2);
        System.out.println();
        
        // 3. Builder Pattern (Recommended)
        System.out.println("3. BUILDER PATTERN (RECOMMENDED):");
        System.out.println("   Advantages:");
        System.out.println("   - Easy to write and read");
        System.out.println("   - Class is immutable");
        System.out.println("   - All defaults in one place");
        System.out.println("   - Fluent API with method chaining");
        System.out.println("   - Can enforce invariants");
        System.out.println("   - Simulates named optional parameters");
        System.out.println();
        
        NutritionFacts cocaCola3 = new NutritionFacts.Builder(240, 8)
            .calories(100)
            .sodium(35)
            .carbohydrate(27)
            .build();
        System.out.println("   Example:");
        System.out.println("   NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8)");
        System.out.println("       .calories(100)");
        System.out.println("       .sodium(35)");
        System.out.println("       .carbohydrate(27)");
        System.out.println("       .build();");
        System.out.println("   Result: " + cocaCola3);
        System.out.println();
        
        // Show flexibility of builder pattern
        System.out.println("4. BUILDER PATTERN FLEXIBILITY:");
        System.out.println("   - Can set only the parameters you need");
        System.out.println("   - Order doesn't matter");
        System.out.println("   - Easy to add more optional parameters");
        System.out.println();
        
        NutritionFacts water = new NutritionFacts.Builder(250, 1)
            .calories(0)
            .build();
        System.out.println("   Water (minimal parameters):");
        System.out.println("   new NutritionFacts.Builder(250, 1).calories(0).build()");
        System.out.println("   Result: " + water);
        System.out.println();
        
        NutritionFacts fullMeal = new NutritionFacts.Builder(300, 2)
            .calories(500)
            .fat(25)
            .sodium(800)
            .carbohydrate(60)
            .build();
        System.out.println("   Full meal (all parameters):");
        System.out.println("   new NutritionFacts.Builder(300, 2)");
        System.out.println("       .calories(500).fat(25).sodium(800).carbohydrate(60)");
        System.out.println("       .build()");
        System.out.println("   Result: " + fullMeal);
        System.out.println();
        
        // Show validation
        System.out.println("5. VALIDATION EXAMPLE:");
        try {
            new NutritionFacts.Builder(-1, 8)
                .calories(100)
                .build();
        } catch (IllegalArgumentException e) {
            System.out.println("   Caught expected exception: " + e.getMessage());
        }
        System.out.println();
        
        System.out.println("=== Key Takeaway ===");
        System.out.println("Use the Builder pattern when you have many optional parameters.");
        System.out.println("It combines the safety of constructors with the readability");
        System.out.println("of JavaBeans, while allowing immutability.");
        System.out.println();
        System.out.println("=== Next: Hierarchical Builders ===");
        System.out.println("See HierarchicalBuilderDemo for examples of Builder pattern");
        System.out.println("with class hierarchies (Pizza, NyPizza, Calzone).");
    }
}

