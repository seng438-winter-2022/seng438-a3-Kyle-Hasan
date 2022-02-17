package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class LengthTests {
	private Range negativeRange;
	private Range positiveRange;
	private Range zeroRange;
	private Range mixedRange;
	private Range boundaryLengthRange;
   
	@Before
	public void setUp()  { 
		negativeRange = new Range(-0.4,-0.1);
		positiveRange = new Range(8.01,24.11);
		zeroRange = new Range(0,0);
		mixedRange = new Range(-1,2);
		boundaryLengthRange = new Range(0,Double.MAX_VALUE);
	}

	    
	    @Test
	    public void testNegativeRangeGetLength(){
	        assertEquals("Length of negative range",0.3,negativeRange.getLength(),.000000001d);

	    }


	    @Test
	    public void testPositiveRangeGetLength(){
	        assertEquals("Length of positive range",16.10,positiveRange.getLength(),.000000001d);

	    }

	    @Test
	    public void testZeroRangeGetLength(){
	        assertEquals("Length of zero range",0,zeroRange.getLength(),.000000001d);

	    }
	    @Test
	    public void testMixedRangeGetLength(){
	        assertEquals("Length of mixed range",3,mixedRange.getLength(),.000000001d);

	    }

		@Test
		public void testFloatBoundaryRangeLengthGetLength(){

			assertEquals("Length of boundary range",Double.MAX_VALUE,boundaryLengthRange.getLength(),.000000001d);
		}
	    

}
