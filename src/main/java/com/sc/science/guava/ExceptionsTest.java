package com.sc.science.guava;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Preconditions 类中很多断言的和校验参数的静态方法
 * 
 * @author Glen Smith (glen@bytecode.com.au)
 */
public class ExceptionsTest {
    
    private void bookTickets(String name, int age) {
        checkNotNull(name, "You must provide a name");
        checkArgument(age > 18, "Age must be over 18, not %s", age);
    }
    
    @Test
    public void nullChecking() {
        try {
            bookTickets(null, 21);
            fail("Should fail name test");
        } catch (NullPointerException npe) {
            assertEquals("You must provide a name", npe.getMessage());
        }
        
    }
    
    @Test
    public void argChecking() {
        try {
            bookTickets("Isaac", 10);
            fail("Should fail age test");
        } catch (IllegalArgumentException iae) {
            assertEquals("Age must be over 18, not 10", iae.getMessage());
        }
        
    }
    
    @Test
    public void exceptionalCode() {
        
        try {
            throw new RuntimeException("This is not looking good");
        } catch (Exception e) {
            String toString = Throwables.getStackTraceAsString(e);
            assertTrue(toString.indexOf("This is not looking good") > -1);
        }
        
    }
    
    private Optional<String> toLower(String incoming) {
        if (incoming != null) {
            return Optional.of(incoming.toLowerCase());
        } else {
            return Optional.absent();
        }
        
    }
    
    @Test
    public void workingWithOptional() {
        Optional<String> lower = toLower("HI");
        assertTrue(lower.isPresent());
        assertEquals("hi", lower.get());
        
        lower = toLower(null);
        assertFalse(lower.isPresent());        
        String defaultMe = lower.or("bye");
        assertEquals("bye", defaultMe);     
    }
    
}
