/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.DayOfTheWeek;
import com.hecey.picoplaca.libs.exception.DOException;
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
    public void GetDayOfTheWeek_When_Monday() throws DOException {
        System.out.println("getDayOfTheWeek");
        dateAsString = "27-11-2017";
        int expResult = 2;

        int result = new DayOfTheWeek().getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);

    }

    @Test
    public void GetDayOfTheWeek_When_Friday() throws DOException {
        System.out.println("getDayOfTheWeek");
        dateAsString = "24-11-2017";
        int expResult = 6;
        int result = new DayOfTheWeek().getDayOfTheWeek(dateAsString);
        assertEquals(expResult, result);

    }

    @Test(expected = IllegalArgumentException.class)
    public void GetDayOfTheWeek_Should_Get_Exception_For_DateIsNull() throws DOException {
        System.out.println("GetDayOfTheWeek_Should_Get_Exception_For_Null");
        dateAsString = null;

        new DayOfTheWeek().getDayOfTheWeek(dateAsString);

    }

    @Test(expected = DOException.class)
    public void GetDayOfTheWeek_Should_Get_Exception_For_WrongInput() throws DOException {
        System.out.println("GetDayOfTheWeek_Should_Get_Exception_For_WrongInput");
        dateAsString = "12";;

        new DayOfTheWeek().getDayOfTheWeek(dateAsString);

    }

}
