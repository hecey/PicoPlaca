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
public class TimeScheduleTest {

    private static TimeSchedule timeSchedule;

    
    @BeforeClass
    public static void setUpClass() {
         timeSchedule = new TimeSchedule();
         timeSchedule.InitializeRangeList();
    }

    @AfterClass
    public static void tearDownClass() {
        timeSchedule = null;
    }

    /**
     * Test of insideRestrictedSchedule method, of class TimeSchedule.
     */
    @Test
    public void InsideRestrictedSchedule_For_True() {
        System.out.println("insideRestrictedSchedule for True is valid");
        String time = "07:30";
        boolean expResult = true;
        boolean result = timeSchedule.insideRestrictedSchedule(time);
        assertEquals(time + " is not in the time  schedule range", expResult, result);
        
    }

    @Test
    public void InsideRestrictedSchedule_For_False() {
        System.out.println("insideRestrictedSchedule for False is valid");
        String time = "9:40";
        boolean expResult = true;
        boolean result = timeSchedule.insideRestrictedSchedule(time);
        assertNotEquals(time + " is in the time  schedule range", expResult, result);
        
    }

}
