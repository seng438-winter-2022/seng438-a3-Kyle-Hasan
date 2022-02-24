package org.jfree.data;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.*;

public class DataUtilitiesCloneTest {
	
	double[][] output;
	
	double[][] arr0 = null;
	double[][] arr1 = new double[1][1];
	double[][] arr2 = new double[2][2];
	double[][] arr3 = new double[2][2];
	
	@Before
	public void setUp() throws Exception {
		// Creates two 2D arrays:
		// 1
		arr1[0][0] = 1;
				
		// Creates two 2D arrays:
		// 1 2
		// 1 2
		arr2[0][0] = 1;
		arr2[0][1] = 2;
		arr2[1][0] = 1;
		arr2[1][1] = 2;
		
		// Creates two 2D arrays:
		// 1 2
		// 1 2
		arr3[0][0] = 1;
		arr3[0][1] = 2;
		arr3[1] = null;
	}
	
	@Test
	public void testCloneSingleton() {
		output = DataUtilities.clone(arr1);
		assertTrue("Arrays should be equal", Arrays.equals(arr1, output));
	}
	
	@Test
	public void testCloneNonSingleton() {
		output = DataUtilities.clone(arr2);
		assertTrue("Arrays should be equal", Arrays.equals(arr2, output));
	}
	
	@Test
	public void testCloneNullColumn() {
		output = DataUtilities.clone(arr3);
		assertTrue("Arrays should be equal", Arrays.equals(arr3, output));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testCloneNullArray() {
		output = DataUtilities.clone(arr0);
	}
	
	@After
    public void tearDown() throws Exception {

    }
}
