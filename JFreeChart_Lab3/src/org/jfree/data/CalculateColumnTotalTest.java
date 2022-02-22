package org.jfree.data;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jmock.*;
import org.junit.*;

public class CalculateColumnTotalTest {

    Mockery mockContext1;
    Mockery mockContext2;
    Values2D values1;
    Values2D values2;

    @Before
    public void setUp() throws Exception {

        // Mockery of 1 x 1 table
        mockContext1 = new Mockery();
        values1 = mockContext1.mock(Values2D.class);
        mockContext1.checking(new Expectations() {
            {
                one(values1).getRowCount();
                will(returnValue(1));
                one(values1).getColumnCount();
                will(returnValue(1));

                // Mock table with values
                // 3.3  null
                // null	null
                // Any values not at 0,0 should not be reached
                one(values1).getValue(0,0);
                will(returnValue(3.3));
                one(values1).getValue(0,1);
                will(returnValue(1.1));
                one(values1).getValue(1,0);
                will(returnValue(3.3));
                one(values1).getValue(1,1);
                will(returnValue(1.1));
            }
        });

        // Mockery of 2 x 2 table
        mockContext2 = new Mockery();
        values2 = mockContext2.mock(Values2D.class);
        mockContext2.checking(new Expectations() {
            {
                one(values2).getRowCount();
                will(returnValue(2));
                one(values2).getColumnCount();
                will(returnValue(2));

                // Mocks table with values
                // 1.1  1.1  null
                // 2.2  2.2  null
                // null null null
                // Last row and column are not valid and out of range
                one(values2).getValue(0,0);
                will(returnValue(1.1));
                one(values2).getValue(0,1);
                will(returnValue(1.1));
                one(values2).getValue(1,0);
                will(returnValue(2.2));
                one(values2).getValue(1,1);
                will(returnValue(2.2));
                one(values2).getValue(0,2);
                will(returnValue(null));
                one(values2).getValue(1,2);
                will(returnValue(null));
                one(values2).getValue(2,0);
                will(returnValue(null));
                one(values2).getValue(2,1);
                will(returnValue(null));
                one(values2).getValue(2,2);
                will(returnValue(null));
            }
        });
    }

    @Test
    public void testCalculateColumnTotalSingleton() {
        assertEquals("The sum of the singleton values column", 3.3, DataUtilities.calculateColumnTotal(values1, 0), .000000001d);
    }
    
    @Test
    public void testCalculateColumnTotalSingletonOutOfBounds() {
        assertEquals("The sum of the singleton values column out of bounds", 0, DataUtilities.calculateColumnTotal(values1, 1), .000000001d);
    }

    @Test
    public void testCalculateColumnTotalNonzeroPosition() {
        assertEquals("The sum of the table values column", 3.3, DataUtilities.calculateColumnTotal(values2, 1), .000000001d);
    }

    @Test
    public void testCalculateColumnTotalTableOutOfBounds() {
        assertEquals("The sum of the table values column", 0, DataUtilities.calculateColumnTotal(values2, 2), .000000001d);
    }
    
    @Test (expected = InvalidParameterException.class)
    public void testCalculateColumnTotalInvalidParemeter() {
        DataUtilities.calculateColumnTotal(null, 0);
    }

    @After
    public void tearDown() throws Exception {

    }
}
