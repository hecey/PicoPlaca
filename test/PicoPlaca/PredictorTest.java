/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author katrina
 */
public class PredictorTest {

    @Test
    public void testCanBeOnTheRoadWhenValidScheduleTime() {
        System.out.println("canBeOnTheRoad");

        Predictor instance = new Predictor();

        instance.setDate("20-11-2017");
        instance.setLicensePlateNumber("ABC-1231");
        instance.setTime("9:50");

        boolean expResult = true;
        boolean result = instance.canBeOnTheRoad();
        assertEquals("Licence number: " + instance.getLicensePlateNumber() + " should not be allowed to run", expResult, result);

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testCanBeOnTheRoadWhenInvalidScheduleTime() {
        System.out.println("canBeOnTheRoad");

        Predictor instance = new Predictor();

        instance.setDate("20-11-2017");
        instance.setLicensePlateNumber("ABC-1231");
        instance.setTime("07:30");

        boolean expResult = false;
        boolean result = instance.canBeOnTheRoad();
        assertEquals("Licence number: " + instance.getLicensePlateNumber() + " should be allowed to run", expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}
