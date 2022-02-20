package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CombineTest {
	private Range standardRange;
	private Range intersectingLower;
	private Range intersectingUpper;
	private Range largeRange;
	
	@Before
	public void setUp() throws Exception {
		standardRange = new Range(-2.5, 4.5);
		intersectingLower = new Range(-6.0, 0);
		intersectingUpper = new Range(3.0, 10.0);
		largeRange = new Range(-1000, 1000);
	}

	@Test
	public void intersectingLowerTest() {
		Range expected = new Range(-6.0, 4.5);
		assertEquals(expected, Range.combine(standardRange, intersectingLower));
	}
	
	@Test
	public void intersectingUpperTest() {
		Range expected = new Range(-2.5, 10.0);
		assertEquals(expected, Range.combine(standardRange, intersectingUpper));
	}
	
	@Test
	public void intersectingAllTest() {
		Range expected = new Range(-1000, 1000);
		assertEquals(expected, Range.combine(standardRange, largeRange));
	}
	
	@Test
	public void nullLower() {
		assertEquals(standardRange, Range.combine(null, standardRange));
	}
	
	@Test
	public void nullUpper() {
		assertEquals(standardRange, Range.combine(standardRange, null));
	}

}
