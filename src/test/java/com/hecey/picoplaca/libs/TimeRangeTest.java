/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class TimeRangeTest {
    
    public TimeRangeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of setTimeRange method, of class TimeRange.
     */
   

    /**
     * Test of setParser method, of class TimeRange.
     */
    @Test
    public void setParser() {
        System.out.println("setParser");
        SimpleDateFormat parser = new SimpleDateFormat("HH:mm");;
        TimeRange.setParser(parser);
        
    }
    
     @Test(expected= DOException.class)
    public void TimeRange_Invalid_Data() throws DOException {
        System.out.println("TimeRange_Invalid_Data");
       TimeRange timeRange = new TimeRange("", "");
        
        
    }
    
    
    

   
}
