package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;


public class ContainsTest {
    private Range negativeRange;
    private Range positiveRange;
    private Range zeroRange;
    private Range mixedRange;

    @BeforeClass public static void setUpBeforeClass()throws Exception {
    }

    @Before
    public void setUp() throws Exception { 
        negativeRange = new Range(-10,-1);
        positiveRange = new Range(5.6,20.8);
        zeroRange = new Range(0,0);
        mixedRange = new Range(-10,20);
    }


    //zero tests [0,0]
    @Test
    public void zeroContainsMethodTest(){
        assertTrue(zeroRange.contains(0) == true);
    }

    @Test
    public void zeroNotContainsMethodTest(){
        assertTrue(zeroRange.contains(5) == false);
    }

    //Mixed tests [-10,20]
    @Test
    public void mixedContainsMethodTest(){
        assertTrue(mixedRange.contains(0) == true);
    }

    @Test
    public void mixedNotContainsMethodTest(){
        assertTrue(mixedRange.contains(21) == false);
    }

    @Test
    public void mixedLowerBoundContainTest(){
        assertTrue(mixedRange.contains(-10) == true);
    }

    @Test
    public void mixedUpperBoundContainTest(){
        assertTrue(mixedRange.contains(2) == true);
    }

    //positive tests [5.6,20.8]
    @Test
    public void positiveContainsMethodTest(){
        assertEquals(true, positiveRange.contains(5.8));
    }

    @Test
    public void positiveNotContainsMethodTest(){
        assertTrue(positiveRange.contains(5) == false);
    }

    @Test
    public void positiveLowerBoundContainTest(){
        assertTrue(positiveRange.contains(5.6) == true);
    }

    @Test
    public void positiveUpperBoundContainTest(){
        assertTrue(positiveRange.contains(20.8) == true);
    }

    //negative tests [-10,-1]
    @Test
    public void negativeContainsMethodTest(){
        assertTrue(negativeRange.contains(-6.4) == true);
    }

    @Test
    public void negativeNotContainsMethodTest(){
        assertTrue(negativeRange.contains(5) == false);
    }

    @Test
    public void negativeLowerBoundContainTest(){
        assertTrue(negativeRange.contains(-10) == true);
    }

    @Test
    public void negativeUpperBoundContainTest(){
        assertTrue(negativeRange.contains(-1) == true);
    }

    @After
        public void tearDown() throws Exception {}

    @AfterClass
        public static void tearDownAfterClass() throws Exception {}
}
