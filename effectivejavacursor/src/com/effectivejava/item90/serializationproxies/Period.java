package com.effectivejava.item90.serializationproxies;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Item 90: Consider serialization proxies instead of serialized instances.
 * 
 * Serialization proxy pattern:
 * 1. Create a private static nested class (SerializationProxy)
 * 2. Implement writeReplace() to return proxy
 * 3. Implement readResolve() in proxy to return real object
 * 4. Make Period class final and throw InvalidObjectException in readObject
 * 
 * Benefits:
 * - Eliminates extralinguistic attack surface
 * - Allows fields to be final
 * - Handles versioning better
 * - More secure
 */
public final class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final Date start;
    private final Date end;
    
    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
    }
    
    /**
     * writeReplace: Returns proxy for serialization.
     */
    private Object writeReplace() {
        return new SerializationProxy(this);
    }
    
    /**
     * readObject: Prevents direct deserialization.
     */
    private void readObject(ObjectInputStream stream) 
            throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
    
    /**
     * Serialization proxy.
     */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private final Date start;
        private final Date end;
        
        SerializationProxy(Period p) {
            this.start = p.start;
            this.end = p.end;
        }
        
        /**
         * readResolve: Returns real object.
         */
        private Object readResolve() {
            return new Period(start, end);  // Uses public constructor
        }
    }
    
    public Date start() {
        return new Date(start.getTime());
    }
    
    public Date end() {
        return new Date(end.getTime());
    }
}

