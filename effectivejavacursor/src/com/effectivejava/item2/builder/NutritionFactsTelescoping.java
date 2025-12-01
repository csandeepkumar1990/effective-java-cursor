package com.effectivejava.item2.builder;

/**
 * Telescoping constructor pattern - does not scale well!
 * 
 * This approach has serious problems:
 * 1. Hard to write client code when there are many parameters
 * 2. Hard to read - what do all those values mean?
 * 3. Must carefully count parameters to find out what each one means
 * 4. Long sequences of identically typed parameters can cause subtle bugs
 * 5. If client accidentally reverses two parameters, compiler won't complain
 *    but program will misbehave at runtime
 */
public class NutritionFactsTelescoping {
    private final int servingSize; // (mL) required
    private final int servings; // (per container) required
    private final int calories; // (per serving) optional
    private final int fat; // (g/serving) optional
    private final int sodium; // (mg/serving) optional
    private final int carbohydrate; // (g/serving) optional
    
    public NutritionFactsTelescoping(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }
    
    public NutritionFactsTelescoping(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }
    
    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }
    
    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }
    
    public NutritionFactsTelescoping(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
    
    // Getters
    public int getServingSize() { return servingSize; }
    public int getServings() { return servings; }
    public int getCalories() { return calories; }
    public int getFat() { return fat; }
    public int getSodium() { return sodium; }
    public int getCarbohydrate() { return carbohydrate; }
    
    @Override
    public String toString() {
        return String.format("NutritionFacts[servingSize=%d, servings=%d, calories=%d, fat=%d, sodium=%d, carbohydrate=%d]",
                servingSize, servings, calories, fat, sodium, carbohydrate);
    }
}


