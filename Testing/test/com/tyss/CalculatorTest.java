package com.tyss;


import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import main.com.tyss.Calculator;

public class CalculatorTest {
	
    Calculator c = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, c.add(2, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, c.subtract(3, 2));
    }
    @Test
    public void testMultiply() {
    	assertEquals(6,c.multiply(2, 3));
    	assertEquals(8,c.multiply(4, 2));
    }
    @Test
    public void testisEven() {
    	assertTrue(c.isEven(4));
    	assertFalse(c.isEven(7));
    }
    @Test
    public void testDivide() {
   	assertEquals(2,c.divide(5, 2));
    }
    @Test
    public void testisOdd() {
    	assertTrue(c.isOdd(5));
    	assertFalse(c.isOdd(6));
    }
    @Test
    public void testdividebyzero() {
    	assertThrows(ArithmeticException.class, () -> {
    		c.divide(4, 0);
    	});
    }
    @Test
    public void testAssertNull() {
    	String name = null;
    	assertNull(name);
    }
    @Test
    public void testAssertNotNull() {
    	String name = "Murali";
    	assertNotNull(name);
    }
    @ParameterizedTest
    @CsvSource({
    	"2, 3, 5",
    	"0, 0, 0",
    	"-5, 10, 5",
    	"100, 200, 300"
    })
    public void testAddParameterized(int a,int b,int expected) {
    	assertEquals(expected, c.add(a,b));
    }
    public void testSubParameterized(int a,int b,int expected) {
    	assertEquals(expected, c.subtract(a, b));
    }
    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8,10,0,-2,-4})
    public void testIsEvenReturnsTrue(int number) {
    	assertTrue(c.isEven(number));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1,3,5,7,9,-1,-3})
    public void testIsEvenReturnsFalse(int number) {
    	assertFalse(c.isEven(number));
    }

    @ParameterizedTest
    @CsvFileSource(files = "test-data/add.csv",numLinesToSkip = 1)
    public void simpleAddTest(int a ,int b,int expeted) {
    	System.out.println("Simple @CsvFileSource test: "+a+ " + "+b);
    	assertEquals(expeted, c.add(a, b));
    }
    @ParameterizedTest
    @CsvFileSource(files = "test-data/mul.csv",numLinesToSkip = 1)
    public void simpleMulTest(int a,int b,int expected) {
    	System.out.println("Simple @CsvFileSource test: "+a+" * "+b);
    	assertEquals(expected, c.multiply(a, b));
    }
    
}
