/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

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
    public void testCanBeOnTheRoadWhenValidScheduleTime() {
        System.out.println("canBeOnTheRoad");

        when(timeSchedule.insideRestrictedSchedule(instance.getTime())).thenReturn(false);
        when(lastDigit.extractLastDigits(instance.getLicensePlateNumber(), 1)).thenReturn(new Integer(1));
        when(dateOfTheWeek.getDayOfTheWeek(instance.getDate())).thenReturn(2);

        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);

        assertTrue(result);
    }

    @Test
    public void testCanBeOnTheRoadWhenInvalidScheduleTime() {
        System.out.println("canBeOnTheRoad");

        boolean expResult = false;

        when(timeSchedule.insideRestrictedSchedule(instance.getTime())).thenReturn(true);
        when(lastDigit.extractLastDigits(instance.getLicensePlateNumber(), 1)).thenReturn(new Integer(1));
        when(dateOfTheWeek.getDayOfTheWeek(instance.getDate())).thenReturn(new Integer(2));

        boolean result = instance.canBeOnTheRoad(timeSchedule, lastDigit, dateOfTheWeek);
        assertFalse(result);

    }
}
