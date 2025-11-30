package com.effectivejava.item2;

/**
 * Builder Pattern - combines safety of telescoping constructor with readability of JavaBeans
 * 
 * Advantages:
 * 1. Class is immutable
 * 2. All parameter default values are in one place
 * 3. Builder's setter methods return builder itself for method chaining (fluent API)
 * 4. Easy to write and read client code
 * 5. Simulates named optional parameters as found in Python and Scala
 * 6. Can enforce invariants in build() method
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    
    public static class Builder {
        // Required parameters
        private final int servingSize;
        private final int servings;
        
        // Optional parameters - initialized to default values
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;
        
        public Builder(int servingSize, int servings) {
            // Validate required parameters
            if (servingSize <= 0) {
                throw new IllegalArgumentException("Serving size must be positive: " + servingSize);
            }
            if (servings <= 0) {
                throw new IllegalArgumentException("Servings must be positive: " + servings);
            }
            this.servingSize = servingSize;
            this.servings = servings;
        }
        
        public Builder calories(int val) {
            if (val < 0) {
                throw new IllegalArgumentException("Calories cannot be negative: " + val);
            }
            calories = val;
            return this;
        }
        
        public Builder fat(int val) {
            if (val < 0) {
                throw new IllegalArgumentException("Fat cannot be negative: " + val);
            }
            fat = val;
            return this;
        }
        
        public Builder sodium(int val) {
            if (val < 0) {
                throw new IllegalArgumentException("Sodium cannot be negative: " + val);
            }
            sodium = val;
            return this;
        }
        
        public Builder carbohydrate(int val) {
            if (val < 0) {
                throw new IllegalArgumentException("Carbohydrate cannot be negative: " + val);
            }
            carbohydrate = val;
            return this;
        }
        
        public NutritionFacts build() {
            // Check invariants involving multiple parameters here
            // For example, total calories should be reasonable
            if (calories > 0 && fat > 0) {
                int estimatedCaloriesFromFat = fat * 9; // 9 calories per gram of fat
                if (estimatedCaloriesFromFat > calories) {
                    throw new IllegalArgumentException(
                        "Calories from fat (" + estimatedCaloriesFromFat + 
                        ") cannot exceed total calories (" + calories + ")");
                }
            }
            
            return new NutritionFacts(this);
        }
    }
    
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
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


