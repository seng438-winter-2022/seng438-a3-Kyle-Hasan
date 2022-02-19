package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {
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
   	public void testNullNoCrossing() {
   		Range actual = Range.shift(null,1.0,false);
   	}
    @Test(expected = InvalidParameterException.class)
    public void testNullCrossing() {
   		Range actual = Range.shift(null,1.0,true);
   	}
    /*note that the positive factor tests use 2 assert statements and don't compare objects directly to deal with floating point precision
    also note that the getUpperBound and getLowerBound methods were already tested*/
    //these tests are for no zero crossing
    @Test
    public void testNegativeShiftNegativeRange() {
    	
    	 Range actual = Range.shift(negativeRange, -0.15,false);
    	 assertEquals("Lower bound of negative range after shifting by -0.15",-0.55,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after shifting by -0.15",-0.25,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeShiftPositiveRange() {
    	 
    	 Range actual = Range.shift(positiveRange, -1.5,false);
    	 assertEquals("Lower bound of positive range after shifting by -1.5",6.51,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after shifting by -1.5",22.61,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeShiftZeroRange() {
    	 
    	 Range actual = Range.shift(zeroRange, -1.5,false);
    	 assertEquals("Lower bound of zero range after shifting by -1.5",-1.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after shifting by -1.5",-1.5,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testNegativeShiftMixedRange() {
    	 
    	 Range actual = Range.shift(mixedRange, -1.5,false);
    	 assertEquals("Lower bound of mixed range after shifting by -1.5",-2.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of mixed range after shifting by -1.5",0.5,actual.getUpperBound(),.000000001d);
    
    }
    //makes sure that zero crossing can't occur if allowZeroCrossing flag is false on positive Shift
    @Test
    public void testPositiveNoZeroCrossing() {
    	Range actual = Range.shift(negativeRange, 1.5,false);
    	assertEquals("Lower bound of negative range after shifting by 1.5(no crossing)",0,actual.getLowerBound(),.000000001d);
   	     assertEquals("Upper bound of negative range after shifting by 1.5(no crossing)",0,actual.getUpperBound(),.000000001d);
    }
    
    //makes sure zero crossing can occur if allowZeroCrossing flag is true
    public void testPositiveZeroCrossing() {
    	Range actual = Range.shift(negativeRange, 1.5,true);
    	 assertEquals("Lower bound of negative range after shifting by 1.5",1.1,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after shifting by 1.5",1.4,actual.getUpperBound(),.000000001d);
    }
    
    /*note that the positive factor tests use 2 assert statements and don't compare objects directly to deal with floating point precision
    also note that the getUpperBound and getLowerBound methods were already tested*/
    //these tests are for no zero crossing
    @Test
    public void testPositiveShiftNegativeRange() {
    	
    	 Range actual = Range.shift(negativeRange, 0.05,false);
    	 assertEquals("Lower bound of negative range after shifting by 0.05",-0.35,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of negative range after shifting by 0.05",-0.05,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveFactorPositiveRange() {
    	 
    	 Range actual = Range.shift(positiveRange, 1.5,false);
    	 assertEquals("Lower bound of positive range after shifting by 1.5",9.51,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after shifting by 1.5",25.61,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveFactorZeroRange() {
    	 
    	 Range actual = Range.shift(zeroRange, 1.5,false);
    	 assertEquals("Lower bound of zero range after shifting by 1.5",1.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of zero range after shifting by 1.5",1.5,actual.getUpperBound(),.000000001d);
    }
    @Test
    public void testPositiveShiftMixedRange() {
    	 
    	 Range actual = Range.shift(mixedRange, 0.5,false);
    	 assertEquals("Lower bound of mixed range after shifting by 1.5",-0.5,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of mixed range after shifting by 1.5",2.5,actual.getUpperBound(),.000000001d);
    
    }
  //makes sure that zero crossing can't occur if allowZeroCrossing flag is false on negative Shift
    @Test
    public void testPositiveRangeNoZeroCrossing() {
    	Range actual = Range.shift(positiveRange, -25,false);
    	assertEquals("Lower bound of positive range after shifting by -25(no crossing)",0,actual.getLowerBound(),.000000001d);
   	 assertEquals("Upper bound of positive range after shifting by -25(no crossing)",0,actual.getUpperBound(),.000000001d);
    }
    
    //makes sure zero crossing can occur if allowZeroCrossing flag is true
    public void testNegativeRangeZeroCrossing() {
    	Range actual = Range.shift(negativeRange, -25,true);
    	 assertEquals("Lower bound of positive range after shifting by -25",-16.99,actual.getLowerBound(),.000000001d);
    	 assertEquals("Upper bound of positive range after shifting by -25",-0.89,actual.getUpperBound(),.000000001d);
    }
    
   
}
