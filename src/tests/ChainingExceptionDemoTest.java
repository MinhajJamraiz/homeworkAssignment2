package tests;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import exceptions.ChainingExceptionDemo;

public class ChainingExceptionDemoTest {
    ChainingExceptionDemo demo = new ChainingExceptionDemo();

    
    @Test
    void testExceptionThrown() {
        assertThrows(Exception.class, demo::execute);
    }

    @Test
    void testExceptionMessage() {
        Exception e = assertThrows(Exception.class, demo::execute);
        assertEquals("Execution failed", e.getMessage());
    }

    @Test
    void testCauseExists() {
        Exception e = assertThrows(Exception.class, demo::execute);
        assertNotNull(e.getCause());
    }

    @Test
    void testCauseType() {
        Exception e = assertThrows(Exception.class, demo::execute);
        assertTrue(e.getCause() instanceof IllegalStateException);
    }

    @Test
    void testCauseMessage() {
        Exception e = assertThrows(Exception.class, demo::execute);
        assertEquals("Root cause occurred", e.getCause().getMessage());
    }

}
