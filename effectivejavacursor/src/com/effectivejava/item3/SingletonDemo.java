package com.effectivejava.item3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Demonstration of the three singleton implementation approaches.
 */
public class SingletonDemo {
    
    public static void main(String[] args) {
        System.out.println("=== Item 3: Singleton Pattern Demo ===\n");
        
        // 1. Public Field Approach
        System.out.println("1. PUBLIC FIELD APPROACH:");
        System.out.println("   Advantages:");
        System.out.println("   - API makes it clear class is singleton");
        System.out.println("   - Simpler (direct field access)");
        System.out.println();
        
        ElvisPublicField elvis1 = ElvisPublicField.INSTANCE;
        ElvisPublicField elvis2 = ElvisPublicField.INSTANCE;
        System.out.println("   ElvisPublicField.INSTANCE (first call)");
        System.out.println("   ElvisPublicField.INSTANCE (second call)");
        System.out.println("   Same instance? " + (elvis1 == elvis2));
        elvis1.leaveTheBuilding();
        System.out.println();
        
        // 2. Static Factory Approach
        System.out.println("2. STATIC FACTORY APPROACH:");
        System.out.println("   Advantages:");
        System.out.println("   - Flexibility to change implementation");
        System.out.println("   - Can return per-thread instances if needed");
        System.out.println("   - Method reference usable as Supplier");
        System.out.println();
        
        ElvisStaticFactory elvis3 = ElvisStaticFactory.getInstance();
        ElvisStaticFactory elvis4 = ElvisStaticFactory.getInstance();
        System.out.println("   ElvisStaticFactory.getInstance() (first call)");
        System.out.println("   ElvisStaticFactory.getInstance() (second call)");
        System.out.println("   Same instance? " + (elvis3 == elvis4));
        elvis3.leaveTheBuilding();
        System.out.println();
        
        // 3. Enum Approach (Preferred)
        System.out.println("3. ENUM APPROACH (PREFERRED):");
        System.out.println("   Advantages:");
        System.out.println("   - More concise");
        System.out.println("   - Serialization for free");
        System.out.println("   - Ironclad guarantee against multiple instantiation");
        System.out.println("   - Immune to reflection attacks");
        System.out.println("   - Immune to serialization attacks");
        System.out.println();
        
        ElvisEnum elvis5 = ElvisEnum.INSTANCE;
        ElvisEnum elvis6 = ElvisEnum.INSTANCE;
        System.out.println("   ElvisEnum.INSTANCE (first call)");
        System.out.println("   ElvisEnum.INSTANCE (second call)");
        System.out.println("   Same instance? " + (elvis5 == elvis6));
        elvis5.leaveTheBuilding();
        System.out.println();
        
        // Reflection attack demonstration
        System.out.println("4. REFLECTION ATTACK PROTECTION:");
        demonstrateReflectionAttack();
        System.out.println();
        
        // Practical example
        System.out.println("5. PRACTICAL EXAMPLE - Database Connection:");
        DatabaseConnection db1 = DatabaseConnection.INSTANCE;
        DatabaseConnection db2 = DatabaseConnection.INSTANCE;
        System.out.println("   Same instance? " + (db1 == db2));
        db1.connect();
        db2.executeQuery("SELECT * FROM users");
        db1.disconnect();
        System.out.println();
        
        // Summary
        System.out.println("=== Summary ===");
        System.out.println("Use enum singleton when possible (preferred approach).");
        System.out.println("Use public field or static factory if you need to extend a class.");
        System.out.println("Always implement readResolve() for serializable singletons");
        System.out.println("(except enum singletons which handle it automatically).");
    }
    
    /**
     * Demonstrates reflection attack and how different approaches handle it.
     */
    private static void demonstrateReflectionAttack() {
        System.out.println("   Attempting reflection attack on ElvisPublicField...");
        try {
            Constructor<ElvisPublicField> constructor = 
                ElvisPublicField.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            ElvisPublicField fakeElvis = constructor.newInstance();
            System.out.println("   Reflection attack succeeded? " + 
                (fakeElvis != ElvisPublicField.INSTANCE));
        } catch (Exception e) {
            System.out.println("   Reflection attack blocked: " + e.getMessage());
        }
        
        System.out.println("   Attempting reflection attack on ElvisEnum...");
        try {
            Constructor<ElvisEnum> constructor = 
                ElvisEnum.class.getDeclaredConstructor(String.class, int.class);
            constructor.setAccessible(true);
            ElvisEnum fakeElvis = constructor.newInstance("FAKE", 0);
            System.out.println("   Reflection attack succeeded? " + 
                (fakeElvis != ElvisEnum.INSTANCE));
        } catch (Exception e) {
            System.out.println("   Reflection attack blocked: " + e.getMessage());
            System.out.println("   (Enums are immune to reflection attacks)");
        }
    }
}

