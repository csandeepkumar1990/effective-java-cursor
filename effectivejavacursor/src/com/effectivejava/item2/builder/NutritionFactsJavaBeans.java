package com.effectivejava.item2.builder;

/**
 * JavaBeans Pattern - allows inconsistency, mandates mutability
 * 
 * This pattern has serious disadvantages:
 * 1. Construction is split across multiple calls, object may be in inconsistent state
 * 2. Class cannot enforce consistency by checking constructor parameters
 * 3. Precludes possibility of making class immutable
 * 4. Requires added effort to ensure thread safety
 * 5. Attempting to use object when inconsistent may cause failures far from bug location
 */
public class NutritionFactsJavaBeans {
    // Parameters initialized to default values (if any)
    private int servingSize = -1; // Required; no default value
    private int servings = -1; // Required; no default value
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;
    
    public NutritionFactsJavaBeans() { }
    
    // Setters
    public void setServingSize(int val) { servingSize = val; }
    public void setServings(int val) { servings = val; }
    public void setCalories(int val) { calories = val; }
    public void setFat(int val) { fat = val; }
    public void setSodium(int val) { sodium = val; }
    public void setCarbohydrate(int val) { carbohydrate = val; }
    
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


