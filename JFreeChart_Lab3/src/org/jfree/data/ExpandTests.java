package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

public class ExpandTests {

	private Range negativeRange;
    private Range positiveRange;
    private Range zeroRange;
    private Range mixedRange;
	
   
    @Before
    public void setUp()  { 
        negativeRange = new Range(-0.4,-0.1);
        positiveRange = new Range(8.01,24.11);
        zeroRange = new Range(0,0);
        mixedRange = new Range(-1,2);
       
		
    }
    @Test(expected = InvalidParameterException.class)
   	public void testNull() {
   		Range actual = Range.expand(null,0.5,0.5);
   	}
    
    
    @Test
    public void testNegativeMarginNegativeRange() {
    	
    	 Range actual = Range.expand(negativeRange, -0.5,-0.5);
    	 assertEquals("Lower bound of negative range after lower margin of -0.5",-0.25,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after upper margin of -0.5",-0.25,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeMarginPositiveRange() {
    	 
    	 Range actual = Range.expand(positiveRange, -0.5,-0.5);
    	 assertEquals("Lower bound of positive range after lower margin of -0.5",16.06,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after upper margin of -0.5",16.06,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeMarginZeroRange() {
    	 
    	 Range actual = Range.expand(zeroRange, -0.5,-0.5);
    	 assertEquals("Lower bound of zero range after lower margin of 0.5",0,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after upper margin of 0.5",0,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeMarginMixedRange() {
    	 
    	 Range actual = Range.expand(mixedRange, -0.5,-0.5);
    	 assertEquals("Lower bound of mixed range after lower margin of -0.5",0.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of mixed range after upper margin of -0.5",0.5,actual.getUpperBound(),.000000001d);
    
    }
    
    @Test
    public void testPositiveMarginNegativeRange() {
    	
    	 Range actual = Range.expand(negativeRange, 0.5,0.5);
    	 assertEquals("Lower bound of negative range after lower margin of 0.5",-0.55,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after upper margin of 0.5",0.05,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPostiveMarginPositiveRange() {
    	 
    	 Range actual = Range.expand(positiveRange, 0.5,0.5);
    	 assertEquals("Lower bound of positive range after lower margin of 0.5",-0.04,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after upper margin of 0.5",32.16,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveMarginZeroRange() {
    	 
    	 Range actual = Range.expand(zeroRange, 0.5,0.5);
    	 assertEquals("Lower bound of zero range after lower margin of 0.5",0,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after upper margin of 0.5",0,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveMarginMixedRange() {
    	 
    	 Range actual = Range.expand(mixedRange, 0.5,0.5);
    	 assertEquals("Lower bound of mixed range after lower margin of 0.5",-2.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of mixed range after upper margin of 0.5",3.5,actual.getUpperBound(),.000000001d);
    
    }
    
    @Test
    public void testPositiveMarginPositive2() {
    	 Range r2 = new Range(2,6);
    	 Range actual = Range.expand(r2,0.25,0.5);
    	 assertEquals("Lower bound of zero range after lower margin of 0.5",1,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after upper margin of 0.5",8,actual.getUpperBound(),.000000001d);
    }
    

}
