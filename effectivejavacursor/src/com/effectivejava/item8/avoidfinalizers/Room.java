package com.effectivejava.item8.avoidfinalizers;

/**
 * Item 8: Avoid finalizers and cleaners.
 * 
 * This class demonstrates the problems with finalizers and cleaners,
 * and shows the preferred alternatives.
 * 
 * PROBLEMS WITH FINALIZERS:
 * 1. Unpredictable timing - may never run
 * 2. Performance cost - significant overhead
 * 3. No guarantee of execution order
 * 4. Can hide exceptions
 * 5. Security issues - finalizer attacks
 * 
 * PROBLEMS WITH CLEANERS:
 * 1. Still unpredictable timing
 * 2. Still performance overhead
 * 3. Still no guarantee of execution
 * 
 * SOLUTION:
 * - Implement AutoCloseable interface
 * - Use try-with-resources
 * - Explicit cleanup is better than implicit
 */
public class Room implements AutoCloseable {
    
    private static int numRooms = 0;
    private final int roomNumber;
    
    // Cleaner - BAD approach (shown for illustration)
    // NOTE: Cleaners are better than finalizers, but still not recommended
    private static final java.lang.ref.Cleaner cleaner = java.lang.ref.Cleaner.create();
    
    // State object for cleaner
    private static class State implements Runnable {
        int roomNum;
        
        State(int roomNum) {
            this.roomNum = roomNum;
        }
        
        @Override
        public void run() {
            System.out.println("Cleaning room " + roomNum + " (via Cleaner)");
            // Cleanup logic here
        }
    }
    
    private final State state;
    private final java.lang.ref.Cleaner.Cleanable cleanable;
    
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.state = new State(roomNumber);
        this.cleanable = cleaner.register(this, state);
        numRooms++;
        System.out.println("Room " + roomNumber + " created. Total rooms: " + numRooms);
    }
    
    /**
     * Explicit cleanup method - PREFERRED APPROACH.
     * This is called explicitly by the client using try-with-resources.
     */
    @Override
    public void close() {
        cleanable.clean();  // Clean up immediately
        numRooms--;
        System.out.println("Room " + roomNumber + " closed explicitly. Remaining rooms: " + numRooms);
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }
    
    /**
     * BAD: Finalizer - DO NOT USE!
     * This is shown for illustration only.
     * Finalizers are deprecated and should never be used.
     */
    // @Override
    // protected void finalize() throws Throwable {
    //     System.out.println("Finalizing room " + roomNumber);
    //     // Finalizers are unpredictable and slow - DO NOT USE!
    //     super.finalize();
    // }
}

