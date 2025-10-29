package tests;

import org.junit.jupiter.api.Test;

import exceptions.RethrowExceptionDemo;

import static org.junit.jupiter.api.Assertions.*;

public class RethrowExceptionDemoTest {
    
    RethrowExceptionDemo demo = new RethrowExceptionDemo();

    @Test
    void testRethrowException(){
        Exception e = assertThrows(Exception.class, demo::riskyMethod);
        assertEquals("Re-thrown exception" ,e.getMessage());
    }

    @Test
    void testCauseInNotNull(){
        Exception e = assertThrows(Exception.class, demo::riskyMethod);
        assertTrue(e.getCause() instanceof NullPointerException);
    }

    @Test
    void testCauseMessage(){
        Exception e = assertThrows(Exception.class, demo::riskyMethod);
        assertEquals("Some Error Found!" ,e.getCause().getMessage());
    }

    @Test
    void testCatchBlockExecutes(){
        try {
            demo.riskyMethod();
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Re-thrown"));
        }
    }

    @Test
    void testNoOtherExceptionType(){
        Exception e = assertThrows(Exception.class, demo::riskyMethod);
        assertFalse(e instanceof IllegalArgumentException);
    }
}
