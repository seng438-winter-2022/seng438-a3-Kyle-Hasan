/**
 * 
 */
package org.jfree.data;
import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Evyn710
 *
 */
public class ToStringTest {

	@Test
	public void testNegativeLowerRange() {
		Range range = new Range(-1, 2);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[-1.0,2.0]", actual);
	}
	
	@Test
	public void testNormalRange() {
		Range range = new Range(1, 2);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[1.0,2.0]", actual);
	}
	
	@Test
	public void testNegativeRange() {
		Range range = new Range(-3.0, -1.0);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[-3.0,-1.0]", actual);
	}
	
	@Test
	public void testLowerZeroRange() {
		Range range = new Range(0.0, 1.0);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[0.0,1.0]", actual);
	}
	
	@Test
	public void testUpperZeroRange() {
		Range range = new Range(-1.0, 0.0);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[-1.0,0.0]", actual);
	}
	
	@Test
	public void testNonZeroPositiveDecimalsRange() {
		Range range = new Range(8.11, 16.18);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[8.11,16.18]", actual);
		
	}
	
	@Test
	public void testNonZeroNegativeDecimalsRange() {
		Range range = new Range(-8.11, 4.02);
		String actual = range.toString();
		assertEquals("The string didn't match", "Range[-8.11,4.02]", actual);
		
	}
}
