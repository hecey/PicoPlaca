/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class DateOfTheWeekTest {
    
    public DateOfTheWeekTest() {
    }
    
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
        String dateAsString = "20-11-2017";
        int expResult = 2;
        int result = DateOfTheWeek.getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    public void testGetDayOfTheWeekFriday() {
        System.out.println("getDayOfTheWeek");
        String dateAsString = "24-11-2017";
        int expResult = 6;
        int result = DateOfTheWeek.getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
