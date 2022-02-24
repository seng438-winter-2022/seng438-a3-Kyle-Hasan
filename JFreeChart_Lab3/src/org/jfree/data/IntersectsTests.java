package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntersectsTests {
    private Range positiveRange;
    private Range testRange;
    private double testValue1;
    private double testValue2;
    private double testValue3;
    private double testValue4;
    private double testValue5;

    @Before
	public void setUp() throws Exception {
        positiveRange = new Range(5.6,20.8);
        testRange = new Range(-10.0,20.0);        
        testValue1 = 4.9;
        testValue2 = 7.9;
        testValue3 = 27.9;
        testValue4 = -10.2;
        testValue5 = 27.9;
	}

    @Test 
    public void b0LowerOrEqualsB1HigherThan(){
        boolean expected = true;
        boolean actual = positiveRange.intersects(testValue1, testValue2);
        assertEquals(expected, actual);
    }

    @Test 
    public void b0LowerOrEqualsB1LowerThan(){
        boolean expected = false;
        boolean actual = positiveRange.intersects(testValue2, testValue1);
        assertEquals(expected, actual);
    }

    @Test 
    public void b0LowerOrEqualsB1LowerThanNegative(){
        boolean expected = false;
        boolean actual = testRange.intersects(testValue2, testValue4);
        assertEquals(expected, actual);
    }

    @Test 
    public void elseTrueFalseTest(){
        boolean expected = false;
        boolean actual = testRange.intersects(testValue2, testValue1);
        assertEquals(expected, actual);
    }

    @Test 
    public void elseFalseTrueTest(){
        boolean expected = false;
        boolean actual = testRange.intersects(testValue3, testValue5);
        assertEquals(expected, actual);
    }

    @Test 
    public void elseTrueTrueTest(){
        boolean expected = true;
        boolean actual = testRange.intersects(testValue1, testValue3);
        assertEquals(expected, actual);
    }
        
    @After
    public void tearDown() throws Exception {}

}
