/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;
import org.junit.After;
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
    private static DayOfTheWeek dateOfTheWeek;
    
    private static Predictor instance;
    private static LicenseLastNumberByDay l;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Before
    public void setUp() {
        timeSchedule = Mockito.mock(TimeSchedule.class);
        lastDigit = Mockito.mock(PlateLastDigits.class);
        dateOfTheWeek = Mockito.mock(DayOfTheWeek.class);
         l=new LicenseLastNumberByDay();
       // instance.setLicenseLastNumberByDay(l);
        instance = new Predictor();
    }
    
    @After
    public void tearDown() {
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
    public void CanBeOnTheRoad_Verify_Invalid_ScheduleTime_Wednesday() throws DOException {
        System.out.println("CanBeOnTheRoad_Verify_Invalid_ScheduleTime_Wednesday");
        
        when(timeSchedule.insideRestrictedSchedule(instance.getTime())).thenReturn(true);
        when(lastDigit.extractLastDigits(instance.getLicensePlateNumber(), 1)).thenReturn(new Integer(1));
        when(dateOfTheWeek.getDayOfTheWeek(instance.getDate())).thenReturn(new Integer(2));
          l=new LicenseLastNumberByDay();
        instance.setLicenseLastNumberByDay(l);
        
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
