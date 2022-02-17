package org.jfree.data;

import static org.junit.Assert.*;


import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;

import org.junit.*; 

public class GetCumulativePercentagesTest {
    Mockery mock1;
    Mockery mock2;
    KeyedValues positiveValues;
    KeyedValues negativeValues;



    @BeforeClass public static void setUpBeforeClass()throws Exception {
    }

    @Before
    public void setUp() throws Exception { 

        Mockery mocingContext1 = new Mockery();
        positiveValues = mocingContext1.mock(KeyedValues.class);
        mocingContext1.checking(new Expectations() {
            { 
                one(positiveValues).getIndex(0);
                will(returnValue(0));
                one(positiveValues).getIndex(1);
                will(returnValue(1));
                one(positiveValues).getIndex(2);
                will(returnValue(2)); 
                one(positiveValues).getIndex(3);
                will(returnValue(3));
                
                
                one(positiveValues).getKey(0);
                will(returnValue(0));
                one(positiveValues).getKey(1);
                will(returnValue(1));
                one(positiveValues).getKey(2);
                will(returnValue(2));
                one(positiveValues).getKey(3);
                will(returnValue(3));
                
                atLeast(1).of(positiveValues).getValue(0);
                will(returnValue(5));
                atLeast(1).of(positiveValues).getValue(1);
                will(returnValue(9));
                atLeast(1).of(positiveValues).getValue(2);
                will(returnValue(2));
                atLeast(1).of(positiveValues).getValue(3);
                will(returnValue(4));


                atLeast(1).of(positiveValues).getItemCount();
                will(returnValue(4));
            }
        });

        Mockery mockingContext2 = new Mockery();
        negativeValues = mockingContext2.mock(KeyedValues.class);
        mockingContext2.checking(new Expectations() {
            { 
                one(negativeValues).getIndex(0);
                will(returnValue(0));
                one(negativeValues).getIndex(1);
                will(returnValue(1));
                one(negativeValues).getIndex(2);
                will(returnValue(2)); 
                
                one(negativeValues).getKey(0);
                will(returnValue(0));
                one(negativeValues).getKey(1);
                will(returnValue(1));
                one(negativeValues).getKey(2);
                will(returnValue(2));
                
                atLeast(1).of(negativeValues).getValue(0);
                will(returnValue(-5));
                atLeast(1).of(negativeValues).getValue(1);
                will(returnValue(-7));
                atLeast(1).of(negativeValues).getValue(2);
                will(returnValue(-4));
                
                atLeast(1).of(negativeValues).getItemCount();
                will(returnValue(3));
            }
        });

    }



    @Test
    public void positiveGetItemCountTest(){
        
        KeyedValues result =  DataUtilities.getCumulativePercentages(positiveValues);
        assertEquals(4, result.getItemCount());
    }

    @Test
    public void negativeGetItemCountTest(){
        
        KeyedValues result =  DataUtilities.getCumulativePercentages(negativeValues);
        assertEquals(3, result.getItemCount());
    }

    @Test
    public void positiveGetTotalTest(){
        double total = 0.0;
        for (int i = 0; i < positiveValues.getItemCount(); i++){
            Number result = positiveValues.getValue(i); 
            if (result != null){
                System.out.print(result.doubleValue());
                total += result.doubleValue();
            }
        }
        assertEquals(20.0, total, 0.00001d);
    }

    @Test
    public void negativeGetTotalTest(){
        double total = 0.0;
        for (int i = 0; i < negativeValues.getItemCount(); i++){
            Number result = negativeValues.getValue(i); 
            if (result != null){
                System.out.print(result.doubleValue());
                total += result.doubleValue();
            }
        }
        assertEquals(-16.0, total, 0.00001d);
    }

    @Test
    public void getValuesWithKey(){
        assertEquals(5.0, positiveValues.getValue(0).doubleValue(), 0.0001d);
        assertEquals(9.0, positiveValues.getValue(1).doubleValue(), 0.0001d);
        assertEquals(2.0, positiveValues.getValue(2).doubleValue(), 0.0001d);
        assertEquals(4.0, positiveValues.getValue(3).doubleValue(), 0.0001d);
        assertEquals(-5.0, negativeValues.getValue(0).doubleValue(), 0.0001d);
        assertEquals(-7.0, negativeValues.getValue(1).doubleValue(), 0.0001d);
        assertEquals(-4.0, negativeValues.getValue(2).doubleValue(), 0.0001d);
    }

    @Test
    public void getKeyWithIndex(){
        assertEquals(0, positiveValues.getKey(0));
        assertEquals(1, positiveValues.getKey(1));
        assertEquals(2, positiveValues.getKey(2));
        assertEquals(3, positiveValues.getKey(3));
        assertEquals(0, negativeValues.getKey(0));
        assertEquals(1, negativeValues.getKey(1));
        assertEquals(2, negativeValues.getKey(2));
    }

    @Test
    public void getIndexWithKey(){
        assertEquals(0, positiveValues.getIndex(0));
        assertEquals(1, positiveValues.getIndex(1));
        assertEquals(2, positiveValues.getIndex(2));
        assertEquals(3, positiveValues.getIndex(3));
        assertEquals(0, negativeValues.getIndex(0));
        assertEquals(1, negativeValues.getIndex(1));
        assertEquals(2, negativeValues.getIndex(2));
    }

    @Test
    public void getPositiveCumulativePercentagesWithValue(){
        KeyedValues result = DataUtilities.getCumulativePercentages(positiveValues);
        double [] expected = {5.0/20.0, 14.0/20.0, 16.0/20.0, 20.0/20.0};
        double [] actual = {result.getValue(0).doubleValue(), result.getValue(1).doubleValue(), result.getValue(2).doubleValue(), result.getValue(3).doubleValue()};

        for (int i = 0; i < actual.length; i++){
            System.out.print(actual[i]+ ", ");
        }
        System.out.print("\n");
        for (int i = 0; i < expected.length; i++){
            System.out.print(expected[i] + ", ");
        }
        System.out.print("\n");
        assertArrayEquals(expected, actual, 0.00001d);
    }


    @Test
    public void getNegativeCumulativePercentagesWithValue(){
        KeyedValues result = DataUtilities.getCumulativePercentages(negativeValues);
        double [] expected = {-5.0/-16.0, -12.0/-16.0, -16.0/-16.0};
        double [] actual = {result.getValue(0).doubleValue(), result.getValue(1).doubleValue(), result.getValue(2).doubleValue()};
        for (int i = 0; i < actual.length; i++){
            System.out.print(actual[i]+ ", ");
        }
        System.out.print("\n");
        for (int i = 0; i < expected.length; i++){
            System.out.print(expected[i] + ", ");
        }

        assertArrayEquals(expected, actual, 0.00001d);
    }
    
    @After
    public void tearDown() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

}
