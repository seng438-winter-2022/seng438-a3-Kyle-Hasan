package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CombineIgnoringNaNTest {
	private Range nanLower;
	private Range nanUpper;
	private Range nanBoth;
	private Range standardRange;
	private Range intersectingLower;
	private Range intersectingUpper;
	private Range largeRange;
	
	@Before
	public void setUp() throws Exception {
		nanLower = new Range(Double.NaN, 0);
		nanUpper = new Range(0, Double.NaN);
		nanBoth = new Range(Double.NaN, Double.NaN);
		standardRange = new Range(-2.5, 4.5);
		intersectingLower = new Range(-6.0, 0);
		intersectingUpper = new Range(3.0, 10.0);
		largeRange = new Range(-1000, 1000);
	}

	@Test
	public void intersectingLowerTest() {
		Range expected = new Range(-6.0, 4.5);
		assertEquals(expected, Range.combineIgnoringNaN(standardRange, intersectingLower));
	}
	
	@Test
	public void intersectingUpperTest() {
		Range expected = new Range(-2.5, 10.0);
		assertEquals(expected, Range.combineIgnoringNaN(standardRange, intersectingUpper));
	}
	
	@Test
	public void intersectingAllTest() {
		Range expected = new Range(-1000, 1000);
		assertEquals(expected, Range.combineIgnoringNaN(standardRange, largeRange));
	}
	
	@Test
	public void nullLower() {
		assertEquals(standardRange, Range.combineIgnoringNaN(null, standardRange));
	}
	
	@Test
	public void nullUpper() {
		assertEquals(standardRange, Range.combineIgnoringNaN(standardRange, null));
	}
	
	@Test
	public void nanLower() {
		Range expected = new Range(-2.5, 4.5);
		assertEquals(expected, Range.combineIgnoringNaN(standardRange, nanLower));
	}
	
	@Test
	public void nanUpper() {
		Range expected = new Range(-2.5, 4.5);
		assertEquals(expected, Range.combineIgnoringNaN(standardRange, nanUpper));
	}
	
	
	@Test
	public void nanRange1NullRange2Both() {
		assertEquals(null, Range.combineIgnoringNaN(null, nanBoth));
	}
	
	@Test
	public void nanRange2NullRange1Both() {
		assertEquals(null, Range.combineIgnoringNaN(nanBoth, null));
	}
	
	@Test
	public void allNan() {
		assertEquals(null, Range.combineIgnoringNaN(nanBoth, nanBoth));
	}
}



