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
public class TimeScheduleTest {

    public TimeScheduleTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insideRestrictedSchedule method, of class TimeSchedule.
     */
    @Test
    public void testInsideRestrictedScheduleForTrue() {
        System.out.println("insideRestrictedSchedule for True is valid");
        String time = "07:30";
        boolean expResult = true;
        boolean result = TimeSchedule.insideRestrictedSchedule(time);
        assertEquals(time + " is not in the time  schedule range", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testInsideRestrictedScheduleForFalse() {
        System.out.println("insideRestrictedSchedule for False is valid");
        String time = "9:40";
        boolean expResult = true;
        boolean result = TimeSchedule.insideRestrictedSchedule(time);
        assertNotEquals(time + " is in the time  schedule range", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
