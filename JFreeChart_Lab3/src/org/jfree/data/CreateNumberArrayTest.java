package org.jfree.data;
import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;

import org.junit.Test;
import java.security.InvalidParameterException;

public class CreateNumberArrayTest {
	
	@Test(expected = InvalidParameterException.class)
	public void testNull() {
		Number[] actual = DataUtilities.createNumberArray(null);
	}
	
	@Test
	public void testIntegerDoubleArray() {
		double[] input = new double[] {1, 2, 3};
		Number[] expected = new Number[] {1.0, 2.0, 3.0};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testDoubleDecimalArray() {
		double[] input = new double[] {1.25, 2.25, 3.25};
		Number[] expected = new Number[] {1.25, 2.25, 3.25};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testEmptyArray() {
		double[] input = new double[] {};
		Number[] expected = new Number[] {};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("The two arrays do not match", expected, actual);
	}

	@Test
	public void testNegativeArray() {
		double[] input = new double[] {-1.25, 2.25, -3.25, -4.5};
		Number[] expected = new Number[] {-1.25, 2.25, -3.25, -4.5};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testZeroArray() {
		double[] input = new double[] {0.0, 0.0, 0.0, 0.0};
		Number[] expected = new Number[] {0.0, 0.0, 0.0, 0.0};
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("The two arrays do not match", expected, actual);
	}

}
