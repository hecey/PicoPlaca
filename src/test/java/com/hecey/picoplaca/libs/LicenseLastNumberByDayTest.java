/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class LicenseLastNumberByDayTest {
    
    public LicenseLastNumberByDayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isRestricted method, of class LicenseLastNumberByDay.
     */
    @Test
    public void IsRestricted_Should_Be_True() {
        System.out.println("IsRestricted_Should_Be_True");
        int d = Day.Monday.getValue();
        int licenseLastNumber = 1;
        LicenseLastNumberByDay instance = new LicenseLastNumberByDay();
        
        boolean result = instance.isRestricted(d, licenseLastNumber);
        assertTrue( result);
        
    }
    
    /**
     * Test of isRestricted method, of class LicenseLastNumberByDay.
     */
    @Test
    public void IsRestricted_Should_Be_False() {
        System.out.println("IsRestricted_Should_Be_False");
        int d = Day.Tuesday.getValue();
        int licenseLastNumber = 5;
        LicenseLastNumberByDay instance = new LicenseLastNumberByDay();
        
        boolean result = instance.isRestricted(d, licenseLastNumber);
        assertEquals(false,result);
        
    }
    
}
