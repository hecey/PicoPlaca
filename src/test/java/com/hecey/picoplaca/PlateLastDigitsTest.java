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
public class PlateLastDigitsTest {

    private static String licensePlateNumber;
    private static int numberOfDigits;

    @BeforeClass
    public static void setUpClass() {
        licensePlateNumber = "ABC-1234";
        numberOfDigits = 1;
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of extractLastDigits method, of class PlateLastDigits.
     */
    @Test
    public void extractLastDigits_Should_Return_A_Digits() {
        System.out.println("extractLastDigits");

        int expResult = 4;
        int result = new PlateLastDigits().extractLastDigits(licensePlateNumber, numberOfDigits);
        assertEquals("Expeted result is 4", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
