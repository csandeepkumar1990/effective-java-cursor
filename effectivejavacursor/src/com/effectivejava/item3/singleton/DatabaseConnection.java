package com.effectivejava.item3.singleton;

/**
 * Example of a singleton representing a system component that is intrinsically unique.
 * This demonstrates a practical use case for singletons.
 * 
 * Uses the enum approach (preferred) for maximum safety.
 */
public enum DatabaseConnection {
    INSTANCE;
    
    private boolean connected = false;
    
    public void connect() {
        if (!connected) {
            System.out.println("Connecting to database...");
            connected = true;
            System.out.println("Database connected!");
        } else {
            System.out.println("Already connected to database.");
        }
    }
    
    public void disconnect() {
        if (connected) {
            System.out.println("Disconnecting from database...");
            connected = false;
            System.out.println("Database disconnected!");
        } else {
            System.out.println("Not connected to database.");
        }
    }
    
    public boolean isConnected() {
        return connected;
    }
    
    public void executeQuery(String query) {
        if (!connected) {
            throw new IllegalStateException("Not connected to database");
        }
        System.out.println("Executing query: " + query);
    }
}

