package cse360assign2;

/**
 * Connor Richards
 * Assignment 2
 * Class ID: 137
 * Description: This file contains the class SimpleListTest. It outlines all the test methods needed to ensure
 * that assign1.SimpleList methods are working correctly and outputting the expected results using JUnits.
 **/

import org.junit.Test;
import static org.junit.Assert.*;

public class SimpleListTest {

    /** Test for constructor **/
    @Test
    public void testConstructor() {
        SimpleList list = new SimpleList();
        assertNotNull(list);    //ensure the constructor works
    }

    /** Tests for add method **/
    @Test
    public void testAdd1() {
        SimpleList list = new SimpleList();
        list.add(1);
        assertEquals("1", list.toString());         //ensure function adds num to list
    }

    @Test
    public void testAdd2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals("3 2 1", list.toString());     //ensure the elements are added in the right order
    }

    @Test
    public void testAdd3() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        assertEquals("11 10 9 8 7 6 5 4 3 2 1", list.toString());     //tests to ensure add still works with 10+ numbers
    }

    @Test
    public void testAdd4() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        assertEquals(15, list.size());          //ensure add also increases the list size
    }

    /** Tests for remove method **/
    @Test
    public void testRemove1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.remove(30);
        assertEquals("1", list.toString());         //test to be sure removing a number that isn't there still works
    }

    @Test
    public void testRemove2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.remove(1);
        assertEquals("2", list.toString());         //ensure the right element is removed
    }

    @Test
    public void testRemove3() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.remove(2);
        assertEquals("1", list.toString());         //ensure the all occurrences are removed
    }

    @Test
    public void testRemove4() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(4);
        assertEquals(7, list.size());       //ensure remove adjusts size correctly
    }

    @Test
    public void testRemove5() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.remove(4);
        list.remove(2);
        assertEquals(5, list.size());       //ensure remove adjusts size correctly

    }

    /** Tests for count method **/
    @Test
    public void testCount1() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(3);
        assertEquals(2, list.count());              //make sure count keeps track of all elements
    }

    @Test
    public void testCount2() {
        SimpleList list = new SimpleList();
        assertEquals(0, list.count());              //edge case with 0 elements
    }

    /** Tests for search method **/
    @Test
    public void testSearch1() {
        SimpleList list = new SimpleList();
        list.add(1);
        assertEquals(-1, list.search(100));      //test for an element not in list
    }

    @Test
    public void testSearch2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(100);
        list.add(2);
        assertEquals(1, list.search(100));      //ensure search correctly finds the specified number
    }

    /** Tests for toString method **/
    @Test
    public void testToString1() {
        SimpleList list = new SimpleList();
        assertEquals("", list.toString());             //empty list case
    }

    @Test
    public void testToString2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.add(2);
        assertEquals("2 1", list.toString());       //ensure the toString lists the assign1.SimpleList correctly
    }

    /** Tests for append **/
    @Test
    public void testAppend1() {
        SimpleList list = new SimpleList();
        list.append(1);
        list.append(2);
        assertEquals("1 2", list.toString());       //ensure append in right order
    }

    @Test
    public void testAppend2() {
        SimpleList list = new SimpleList();
        list.append(10);
        assertEquals("10", list.toString());        //ensure append with only 1 element
    }

    /** Tests for size **/
    @Test
    public void testSize1() {
        SimpleList list = new SimpleList();
        assertEquals(10, list.size());          //ensure default size works
    }


    /** Tests for first **/
    @Test
    public void testFirst1() {
        SimpleList list = new SimpleList();
        assertEquals(-1, list.first());      //first element should always be 0
    }

    @Test
    public void testFirst2() {
        SimpleList list = new SimpleList();
        list.add(1);
        list.append(2);
        list.add(5);
        assertEquals(5, list.first());      //ensure first works
    }
}
