/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

import com.hecey.picoplaca.libs.PlateLastDigits;
import com.hecey.picoplaca.libs.exception.DOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class PlateLastDigitsTest {

    private String licensePlateNumber;
    private static int numberOfDigits;
    private int expResult;

    @BeforeClass
    public static void setUpClass() {
        numberOfDigits = 1;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of extractLastDigits method, of class PlateLastDigits.
     */
    @Test
    public void PlateLastDigits_Should_Get_A_Valid_Return() {
        System.out.println("PlateLastDigits_Should_Get_A_Valid_Return");
        licensePlateNumber = "ABC-1234";

        expResult = 4;
        int result = new PlateLastDigits().extractLastDigits(licensePlateNumber, numberOfDigits);
        assertEquals("Expected result is 4", expResult, result);

    }

    @Test(expected = NumberFormatException.class)
    public void PlateLastDigits_Should_Get_A_Valid_Return_I() {
        System.out.println("PlateLastDigits_Should_Get_A_Valid_Return");
        licensePlateNumber = "ABC";

        new PlateLastDigits().extractLastDigits(licensePlateNumber, numberOfDigits);

    }

    @Test(expected = IllegalArgumentException.class)
    public void PlateLastDigits_Should_Get_Exception_For_PlateIsNull() throws DOException {
        System.out.println("PlateLastDigits_Should_Get_Exception_For_PlateIsNull");
        new PlateLastDigits().extractLastDigits(null, numberOfDigits);
    }
}
