package com.effectivejava.item1.staticfactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Example demonstrating service provider framework using static factory methods.
 * This pattern allows for flexible service registration and retrieval.
 */
public class ServiceProvider {
    private static final Map<String, Service> services = new HashMap<>();
    
    // Static factory method for getting service instances
    public static Service getService(String name) {
        Service service = services.get(name);
        if (service == null) {
            throw new IllegalArgumentException("Service not found: " + name);
        }
        return service;
    }
    
    // Static factory method for registering services
    public static void registerService(String name, Service service) {
        services.put(name, service);
    }
    
    // Interface for services
    public interface Service {
        void execute();
    }
    
    // Example service implementations
    public static class DatabaseService implements Service {
        @Override
        public void execute() {
            System.out.println("Executing database service");
        }
    }
    
    public static class EmailService implements Service {
        @Override
        public void execute() {
            System.out.println("Executing email service");
        }
    }
}


