/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author katrina
 */
public class LicenseLastNumberByDay implements ILicenseLastNumberByDay {

    Map<Integer, int[]> lastNumberByDay;

    public LicenseLastNumberByDay() {
        lastNumberByDay = new HashMap();
        lastNumberByDay.put(Day.Monday.getValue(), PlateNumbersByDay.Monday.getValue());
        lastNumberByDay.put(Day.Tuesday.getValue(), PlateNumbersByDay.Tuesday.getValue());
        lastNumberByDay.put(Day.Thursday.getValue(), PlateNumbersByDay.Thursday.getValue());
        lastNumberByDay.put(Day.Wednesday.getValue(), PlateNumbersByDay.Wednesday.getValue());
        lastNumberByDay.put(Day.Friday.getValue(), PlateNumbersByDay.Friday.getValue());
    }

    public boolean isRestricted(int day, int licenseLastNumber) {

        int[] lastNumbers = lastNumberByDay.get(day);
        if (lastNumbers != null) {
            for (int lastNumber : lastNumbers) {
                if (licenseLastNumber == lastNumber) {
                    return true;
                }
            }
        }
        return false;
    }

}
