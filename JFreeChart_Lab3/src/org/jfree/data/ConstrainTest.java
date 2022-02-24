package org.jfree.data;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConstrainTest {

    private Range negativeRange;
    private Range positiveRange;
    private Range zeroRange;
    private Range mixedRange;
    private double positiveValue;
    private double negativeValue;
    private double zeroValue;

    @Before
	public void setUp() throws Exception {
        negativeRange = new Range(-10,-1);
        positiveRange = new Range(5.6,20.8);
        zeroRange = new Range(0,0);
        mixedRange = new Range(-10,20);
        positiveValue = 7.9;
        negativeValue = -6.9;
        zeroValue = 0.0;
	}

    @Test
    public void testFirstConditionFalse(){
        //using the mixed range to test this
        double expected = 7.9;
        double actual = mixedRange.constrain(positiveValue);
        assertEquals(expected, actual, 0.000001d);
    }

    @Test
    public void testSecondConditionIf(){
        double expected = -1;
        double actual = negativeRange.constrain(positiveValue);
        assertEquals(expected, actual, 0.000001d);
    }

    @Test
    public void testSecondConditionElseif(){
        double expected = 5.6;
        double actual = positiveRange.constrain(negativeValue);
        assertEquals(expected, actual, 0.000001d);
    }

    @Test
    public void zeroTestConstrain(){
        double expected = 0.0;
        double actual = zeroRange.constrain(zeroValue);
        assertEquals(expected, actual, 0.000001d);
    }
    
    @After
    public void tearDown() throws Exception {}
}
