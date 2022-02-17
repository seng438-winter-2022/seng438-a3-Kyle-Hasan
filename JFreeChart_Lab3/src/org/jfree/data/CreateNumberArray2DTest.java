package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreateNumberArray2DTest {
	@Test(expected = InvalidParameterException.class)
	public void testNull() {
		Number[][] actual = DataUtilities.createNumberArray2D(null);
	}

	@Test
	public void testIntegerDoubleArray() {
		double[][] input = new double[][] {{1, 2}, {3, 4}};
		Number[][] expected = new Number[][] {{1.0, 2.0}, {3.0, 4.0}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testDoubleDecimalArray() {
		double[][] input = new double[][] {{1.25, 2.25}, {3.25, 4.25}};
		Number[][] expected = new Number[][] {{1.25, 2.25}, {3.25, 4.25}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testEmptyArray() {
		double[][] input = new double[][] {{}};
		Number[][] expected = new Number[][] {{}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testNegativeArray() {
		double[][] input = new double[][] {{-1.25, 2.25}, {-3.25, 4.25}};
		Number[][] expected = new Number[][] {{-1.25, 2.25}, {-3.25, 4.25}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
	@Test
	public void testZeroArray() {
		double[][] input = new double[][] {{0.0, 0.0}, {0.0, 0.0}};
		Number[][] expected = new Number[][] {{0.0, 0.0}, {0.0, 0.0}};
		Number[][] actual = DataUtilities.createNumberArray2D(input);
		assertEquals("The two arrays do not match", expected, actual);
	}
	
}
