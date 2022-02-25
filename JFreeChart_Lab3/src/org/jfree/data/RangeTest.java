package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest{

    private double upper;
    private double lower; 
    private Range testRange;

    @Before
    public void setUp() throws Exception{
        upper= 1.0;
        lower =10.0;
    }

    @Test(expected = Exception.class)
    public void correctConstructorRangeTest(){
        // Range expected = new Range (-10.0,10.0);
        testRange = new Range(lower, upper);

    }
            
    @After
    public void tearDown() throws Exception {}

}