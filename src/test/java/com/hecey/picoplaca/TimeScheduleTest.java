/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

import com.hecey.picoplaca.libs.TimeSchedule;
import com.hecey.picoplaca.libs.exception.DOException;
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
    public static void setUpClass() throws DOException {
        timeSchedule = new TimeSchedule();
        timeSchedule.InitializeRangeList();
    }

    @AfterClass
    public static void tearDownClass() {
        timeSchedule = null;
    }

    /**
     * Test of insideRestrictedSchedule method, of class TimeSchedule.
     *
     * @throws com.hecey.picoplaca.libs.exception.DOException
     */
    @Test
    public void InsideRestrictedSchedule_For_True() throws DOException {
        System.out.println("insideRestrictedSchedule for True is valid");
        String time = "07:30";
        boolean expResult = true;
        boolean result = timeSchedule.insideRestrictedSchedule(time);
        assertEquals(time + " is not in the time  schedule range", expResult, result);

    }

    @Test
    public void InsideRestrictedSchedule_For_False() throws DOException {
        System.out.println("insideRestrictedSchedule for False is valid");
        String time = "9:40";
        boolean expResult = true;
        boolean result = timeSchedule.insideRestrictedSchedule(time);
        assertNotEquals(time + " is in the time  schedule range", expResult, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void InsideRestrictedSchedule_Should_Get_Exception_For_Empty() throws DOException {
        System.out.println("InsideRestrictedSchedule_Should_Get_Exception_For_Null");
        
        timeSchedule.insideRestrictedSchedule("");
    }

}
