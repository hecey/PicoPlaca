/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

import com.hecey.picoplaca.libs.Predictor;
import com.hecey.picoplaca.libs.TimeSchedule;
import com.hecey.picoplaca.libs.PlateLastDigits;
import com.hecey.picoplaca.libs.DateOfTheWeek;
import com.hecey.picoplaca.libs.exception.DOException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 *
 * @author katrina
 */
public class PredictorTest {
    
    @Mock
    private static TimeSchedule timeSchedule;
    @Mock
    private static PlateLastDigits lastDigit;
    @Mock
    private static DateOfTheWeek dateOfTheWeek;
    
    private static Predictor instance;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @BeforeClass
    public static void setUpClass() {
        timeSchedule = Mockito.mock(TimeSchedule.class);
        lastDigit = Mockito.mock(PlateLastDigits.class);
        dateOfTheWeek = Mockito.mock(DateOfTheWeek.class);
        
        instance = new Predictor();
    }
    
    @AfterClass
    public static void tearDownClass() {
        instance = null;
    }
    
    @Test
    public void CanBeOnTheRoad_Verified_Valid_ScheduleTime() throws DOException {
        System.out.println("CanBeOnTheRoad_Verified_Valid_ScheduleTime");
        
        when(timeSchedule.insideRestrictedSchedule(instance.getTime())).thenReturn(false);
        when(lastDigit.extractLastDigits(instance.getLicensePlateNumber(), 1)).thenReturn(new Integer(1));
        when(dateOfTheWeek.getDayOfTheWeek(instance.getDate())).thenReturn(2);
        
        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);
        
        assertTrue(result);
    }
    
    @Test
    public void CanBeOnTheRoad_Verify_Invalid_ScheduleTime() throws DOException {
        System.out.println("CanBeOnTheRoad_Verify_Invalid_ScheduleTime");
        
        when(timeSchedule.insideRestrictedSchedule(instance.getTime())).thenReturn(true);
        when(lastDigit.extractLastDigits(instance.getLicensePlateNumber(), 1)).thenReturn(new Integer(1));
        when(dateOfTheWeek.getDayOfTheWeek(instance.getDate())).thenReturn(new Integer(2));
        
        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);
        assertFalse(result);
        verify(timeSchedule).insideRestrictedSchedule(instance.getTime());
        verify(lastDigit).extractLastDigits(instance.getLicensePlateNumber(), 1);
        verify(dateOfTheWeek).getDayOfTheWeek(instance.getDate());
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void CanBeOnTheRoad_Should_Get_Exception_For_Null() throws DOException {
        System.out.println("CanBeOnTheRoad_Should_Get_Exception_For_Null");
        
        when(timeSchedule.insideRestrictedSchedule("")).thenThrow(IllegalArgumentException.class);
        when(lastDigit.extractLastDigits("", 1)).thenThrow(IllegalArgumentException.class);
        when(dateOfTheWeek.getDayOfTheWeek(null)).thenThrow(IllegalArgumentException.class);
        
        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);
        
        verify(timeSchedule).insideRestrictedSchedule(instance.getTime());
        verify(lastDigit).extractLastDigits(instance.getLicensePlateNumber(), 1);
        verify(dateOfTheWeek).getDayOfTheWeek(instance.getDate());
        
    }
    
    @Test(expected = DOException.class)
    public void CanBeOnTheRoad_Should_Get_Exception_For_InvalidadInput() throws DOException {
        System.out.println("CanBeOnTheRoad_Should_Get_Exception_For_InvalidadInput");
        
        when(timeSchedule.insideRestrictedSchedule(anyString())).thenThrow(DOException.class);
        when(lastDigit.extractLastDigits("", 1)).thenThrow(DOException.class);
        
        instance.setLicensePlateNumber("invalidData");
        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);
        
        verify(timeSchedule).insideRestrictedSchedule(instance.getTime());
        verify(lastDigit).extractLastDigits(instance.getLicensePlateNumber(), 1);

    }
}
