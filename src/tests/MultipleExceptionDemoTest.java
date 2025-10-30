package tests;

import org.junit.jupiter.api.Test;

import exceptions.MultipleExceptionDemo;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleExceptionDemoTest {

    MultipleExceptionDemo demo = new MultipleExceptionDemo();

    @Test 
    void testValidCase(){
        String result = demo.devideAndAccess(10, 2, new int[]{5,10,15}, 1);
        assertTrue(result.contains("Value"));
    }

    @Test
    void testDivideByZero(){
        String result = demo.devideAndAccess(10,0,new int[]{5,10,15},1);
        assertTrue(result.startsWith("Error"));
    }

    @Test
    void testInvalidIndex(){
        String result = demo.devideAndAccess(10, 2, new int[]{5,10,15}, 3);
        assertTrue(result.startsWith("Error"));
    }

    @Test
    void testEmptyArray(){
        String result = demo.devideAndAccess(10, 2, new int[]{}, 0);
        assertTrue(result.startsWith("Error"));
    }

    @Test
    void testNegativeValues(){
        String result = demo.devideAndAccess(-10, -2, new int[]{1,2,3}, 2);
        assertTrue(result.contains("Value"));
    }
    
}
