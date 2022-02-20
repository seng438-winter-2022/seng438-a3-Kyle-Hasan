package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ScaleTest {

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
		Range actual = Range.scale(null,1.0);
	}
    
    @Test(expected = InvalidParameterException.class)
	public void testNegativeFactorNegativeRange() {
		Range actual = Range.scale(negativeRange,-1);
	}
    
    @Test(expected = InvalidParameterException.class)
   	public void testNegativeFactorPositiveRange() {
   		Range actual = Range.scale(positiveRange,-1);
   	}
    @Test(expected = InvalidParameterException.class)
   	public void testNegativeFactorZeroRange() {
   		Range actual = Range.scale(zeroRange,-1);
   	}
    @Test(expected = InvalidParameterException.class)
   	public void testNegativeFactorMixedRange() {
   		Range actual = Range.scale(mixedRange,-1);
   	}
    /*note that the positive factor tests use 2 assert statements and don't compare objects directly to deal with floating point precision
    also note that the getUpperBound and getLowerBound methods were already tested*/
    @Test
    public void testPositiveFactorNegativeRange() {
    	
    	 Range actual = Range.scale(negativeRange, 1.5);
    	 assertEquals("Lower bound of negative range after scaling by 1.5",-0.6,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after scaling by 1.5",-0.15,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveFactorPositiveRange() {
    	 
    	 Range actual = Range.scale(positiveRange, 1.5);
    	 assertEquals("Lower bound of positive range after scaling by 1.5",12.015,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after scaling by 1.5",36.165,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveFactorZeroRange() {
    	 
    	 Range actual = Range.scale(zeroRange, 1.5);
    	 assertEquals("Lower bound of zero range after scaling by 1.5",0,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after scaling by 1.5",0,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveFactorMixedRange() {
    	 
    	 Range actual = Range.scale(mixedRange, 1.5);
    	 assertEquals("Lower bound of mixed range after scaling by 1.5",-1.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of mixed range after scaling by 1.5",3,actual.getUpperBound(),.000000001d);
    
    }
    
    //compare objects directly here because there is no floating point imprecision to worry about
    
    @Test
    public void testZeroFactorNegativeRange() {
    	 assertEquals("Testing negative range scale with factor of 0", zeroRange,Range.scale(negativeRange, 0));
    	
    }
    @Test
    public void testZeroFactorPositiveRange() {
    	 assertEquals("Testing positive range scale with factor of 0", zeroRange,Range.scale(positiveRange, 0));
    	
    }
    @Test
    public void testZeroFactorMixedRange() {
    	 assertEquals("Testing mixed range scale with factor of 0", zeroRange,Range.scale(mixedRange, 0));
    	
    }
    @Test
    public void testZeroFactorZeroRange() {
    	 assertEquals("Testing zero range scale with factor of 0", zeroRange,Range.scale(zeroRange, 0));
    	
    }
    


}
