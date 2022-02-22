package org.jfree.data;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class DataUtilitiesEqualTest {
	
	double[][] arr0 = null;
	double[][] arr0_clone = null;
	double[][] arr1 = new double[1][1];
	double[][] arr1_clone = new double[1][1];
	double[][] arr2 = new double[2][2];
	double[][] arr2_clone = new double[2][2];
	double[][] arr3 = new double[1][1];
	double[][] arr3_clone = new double[1][1];
	
	@Before
	public void setUp() throws Exception {
		
		// Creates two 2D arrays:
		// 1
		arr1[0][0] = 1;
		arr1_clone[0][0] = 1;
		
		// Creates two 2D arrays:
		// 1
		arr3[0][0] = 2;
		arr3_clone[0][0] = 2;
		
		// Creates two 2D arrays:
		// 1 2
		// 1 2
		arr2[0][0] = 1;
		arr2[0][1] = 2;
		arr2[1][0] = 1;
		arr2[1][1] = 2;
		
		arr2_clone[0][0] = 1;
		arr2_clone[0][1] = 2;
		arr2_clone[1][0] = 1;
		arr2_clone[1][1] = 2;
	}
	
	@Test
	public void testEqualsBothNull() {
		assertEquals("Two different array objects have the same values of Null", true, DataUtilities.equal(arr0, arr0_clone));
	}
	
	@Test
	public void testEqualsNullA() {
		assertEquals("Two different array objects have different values, 'a' is Null", false, DataUtilities.equal(arr0, arr1));
	}
	
	@Test
	public void testEqualsNullB() {
		assertEquals("Two different array objects have different values, 'b' is Null", false, DataUtilities.equal(arr1, arr0));
	}
	
	@Test
	public void testEqualsDifferentSize() {
		assertEquals("Two arrays of different size", false, DataUtilities.equal(arr1, arr2));
	}
	
	@Test
	public void testEqualsSameSizeSameValue() {
		assertEquals("Two arrays of different size", true, DataUtilities.equal(arr1, arr1_clone));
	}
	
	@Test
	public void testEqualsSameSizeDifferentValue() {
		assertEquals("Two arrays of different size", false, DataUtilities.equal(arr1, arr3));
	}
	
	@After
    public void tearDown() throws Exception {

    }
}