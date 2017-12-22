/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class DateOfTheWeekTest {

    private static String dateAsString;

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDayOfTheWeek method, of class DateOfTheWeek.
     */
    @Test
    public void testGetDayOfTheWeekMonday() {
        System.out.println("getDayOfTheWeek");
        dateAsString = "27-11-2017";
        int expResult = 2;

        int result = new DateOfTheWeek().getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public void testGetDayOfTheWeekFriday() {
        System.out.println("getDayOfTheWeek");
        dateAsString = "24-11-2017";
        int expResult = 6;
        int result = new DateOfTheWeek().getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
