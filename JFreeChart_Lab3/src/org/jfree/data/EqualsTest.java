package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EqualsTest {
    private Range upperRange;
    private Range lowerRange;
    private Range testRange;
    private Range sameRange;
    private Object notRange;

    @Before
	public void setUp() throws Exception {
        upperRange = new Range(5.0, 20);
        lowerRange = new Range(-10.0,0.0);
        testRange = new Range(-10.0,20.0);
        sameRange = new Range(-10.0,20.0);
	}

    @Test
    public void instanceOfRangeTest(){
        boolean expected = false;
        boolean actual = testRange.equals(notRange);
        assertEquals(expected, actual);
    }

    @Test
    public void lowerConditionNotEqualTest(){
        boolean expected = false;
        //testing when the lower range is not equal to the test range
        boolean actual = testRange.equals(upperRange);
        assertEquals(expected, actual);
    }

    @Test
    public void upperConditionNotEqualTest(){
        boolean expected = false;
        //testing when the upper range is not equal to the test range
        boolean actual = testRange.equals(lowerRange);
        assertEquals(expected, actual);
    }

    @Test
    public void elseReturnTrueTest(){
        boolean expected = true;
        boolean actual = testRange.equals(sameRange);
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {}
}
