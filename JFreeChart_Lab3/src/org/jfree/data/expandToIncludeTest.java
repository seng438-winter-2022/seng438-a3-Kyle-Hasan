package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class expandToIncludeTest {

    private Range nullRange;
    private Range normalRange;
	private Range largeRange;
    private Range negativeRange; 
    private double positiveValue;
    private double negativeValue;
    private double zeroValue;    

    @Before
	public void setUp() throws Exception {
        nullRange = null;
		normalRange = new Range(-5.5, 5.5);
		largeRange = new Range(-1000, 1000);
        negativeRange = new Range(-5.0, -1.0);
        positiveValue = 7.9;
        negativeValue = -6.9;
        zeroValue = 0.0;
	}

    @Test
    public void nullRangeTest(){
        Range expected = new Range(0.0, 0.0);
        Range actual = Range.expandToInclude(nullRange, zeroValue);
        assertEquals(expected, actual);
    }

    @Test
    public void lowerBoundTrueTest(){
        Range expected = new Range(-6.9, 5.5);
        Range actual = Range.expandToInclude(normalRange, negativeValue);
        assertEquals(expected, actual);
    }

    @Test
    public void upperBoundTrueTest(){
        Range expected = new Range(-5.0, 7.9);
        Range actual = Range.expandToInclude(negativeRange, positiveValue);
        assertEquals(expected, actual);
    }


    @Test
    public void elseReturnRangeTest(){
        Range expected = new Range(-1000, 1000);
        Range actual = Range.expandToInclude(largeRange, positiveValue);
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {}
}
