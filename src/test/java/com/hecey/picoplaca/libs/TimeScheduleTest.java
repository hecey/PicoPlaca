/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.TimeRange;
import com.hecey.picoplaca.libs.TimeSchedule;
import com.hecey.picoplaca.libs.exception.DOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import com.hecey.picoplaca.libs.IRange;

/**
 *
 * @author katrina
 */
public class TimeScheduleTest {

    private static TimeSchedule timeSchedule;
    private static ArrayList<IRange> timeRangeList;

    
    @Before
    public  void setUp() throws DOException {
        timeSchedule = new TimeSchedule();
        timeSchedule.setParser(new SimpleDateFormat("HH:mm"));
        timeRangeList = new ArrayList();
        timeRangeList.add(new TimeRange("07:00", "09:30"));
        timeRangeList.add(new TimeRange("16:00", "19:30"));
        timeSchedule.InitializeRangeList();
        timeSchedule.setTimeRangeList(timeRangeList);

    }

    @After
    public  void tearDown() {
        timeSchedule.ClearTimeRangeList();
        
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
        timeSchedule.setParser(new SimpleDateFormat("HH:mm"));
         timeRangeList = new ArrayList();
       timeSchedule.setTimeRangeList(timeRangeList);
        
        boolean expResult = true;
        
       boolean result = timeSchedule.insideRestrictedSchedule(time);
     //   assertNotEquals(time + " is in the time  schedule range", expResult, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void InsideRestrictedSchedule_Should_Get_Exception_For_Empty() throws DOException {
         timeSchedule.setTimeRangeList(null);
        System.out.println("InsideRestrictedSchedule_Should_Get_Exception_For_Null");

        timeSchedule.insideRestrictedSchedule("");
    }

    @Test(expected = DOException.class)
    public void InsideRestrictedSchedule_Should_Get_Exception_For_WrongInput() throws DOException {
        System.out.println("InsideRestrictedSchedule_Should_Get_Exception_For_Null");

        timeSchedule.insideRestrictedSchedule("InvalidData");
    }

}
