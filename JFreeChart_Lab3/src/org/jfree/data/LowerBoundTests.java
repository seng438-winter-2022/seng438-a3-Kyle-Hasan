package org.jfree.data;
import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class LowerBoundTests {

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
			boundaryRange = new Range(-Double.MAX_VALUE,Double.MAX_VALUE);
	    }

	  

	    @Test
	    public void testNegativeRangeGetLower(){
	        assertEquals("Lower bound of negative range",-0.4,negativeRange.getLowerBound(),.000000001d);

	    }
	    
	    @Test
	    public void testPositiveRangeGetLower(){
	        assertEquals("Lower bound of positive range",8.01,positiveRange.getLowerBound(),.000000001d);

	    }

	    @Test
	    public void testZeroRangeGetLower(){
	        assertEquals("Lower bound of zero range",0,zeroRange.getLowerBound(),.000000001d);

	    }
	    @Test
	    public void testMixedRangeGetLower(){
	        assertEquals("Lower bound of mixed range",-1,mixedRange.getLowerBound(),.000000001d);

	    }

		@Test
		public void testBoundaryRangeGetLower(){

			assertEquals("Lower bound of boundary range",-Double.MAX_VALUE,boundaryRange.getLowerBound(),0.0);
		}

	
}
