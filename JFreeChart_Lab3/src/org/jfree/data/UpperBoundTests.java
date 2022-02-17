package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class UpperBoundTests {

		private Range negativeRange;
	    private Range positiveRange;
	    private Range zeroRange;
	    private Range mixedRange;
	    private Range boundaryRange;
	   
	    @Before
	    public void setUp()  { 
	        negativeRange = new Range(-0.4,-0.1);
	        positiveRange = new Range(8.01,24.11);
	        zeroRange = new Range(0,0);
	        mixedRange = new Range(-1,2);
			boundaryRange = new Range(-Double.MIN_VALUE,Double.MAX_VALUE);
	    }

	    @Test
	    public void testNegativeRangeGetUpper(){
	        assertEquals("Upper bound of negative range",-0.1,negativeRange.getUpperBound(),.000000001d);

	    }
	    @Test
	    public void testPositiveRangeGetUpper(){
	        assertEquals("Upper bound of positive range",24.11,positiveRange.getUpperBound(),.000000001d);

	    }
	    
	    @Test
	    public void testZeroRangeGetUpper(){
	        assertEquals("Upper bound of zero range",0,zeroRange.getUpperBound(),.000000001d);

	    }
	    
	    @Test
	    public void testMixedRangeGetUpper(){
	        assertEquals("Upper bound of mixed range",2,mixedRange.getUpperBound(),0.0);

	    }

		@Test
		public void testFloatRangeGetUpper(){

			assertEquals("Upper bound of boundary range",Double.MAX_VALUE,boundaryRange.getUpperBound(),0.0);
		}
}
