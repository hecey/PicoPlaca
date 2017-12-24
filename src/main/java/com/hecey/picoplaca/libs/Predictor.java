/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;

/**
 *
 * @author katrina
 */
public class Predictor {

    //params: the full license plate number, not the last digit), a date (as a String), and a time
    //Ecuador have three letters and three or four numbers ranging from 000 to 9999,
    //for serial formats of ABC-123 and ABC-1234.
    //Date expected format dd-mm-yyyy
    private String licensePlateNumber;
    private String date;
    private String time;
    private int licenseLastNumber;
    private ILicenseLastNumberByDay licenseLastNumberByDay;

    public void setLicenseLastNumberByDay(ILicenseLastNumberByDay licenseLastNumberByDay) {
        this.licenseLastNumberByDay = licenseLastNumberByDay;
    }

    public Predictor() {
        this.licensePlateNumber = "";
        this.date = "";
        this.time = "";
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    //Returns whether or not that car can be on the road.
    public boolean canBeOnTheRoad(ISchedule schedule, ILastDigits lastDigits, IDate dateOf) throws DOException {

        licenseLastNumber = lastDigits.extractLastDigits(licensePlateNumber, 1);
        int dayOfTheWeek = dateOf.getDayOfTheWeek(date);

        boolean insideRestrictedTime = schedule.insideRestrictedSchedule(time);

        if (insideRestrictedTime) {
            return !isRestrictedDayByLicenseNumber(dayOfTheWeek, licenseLastNumber);
        }

        return true;
    }

    private boolean isRestrictedDayByLicenseNumber(int dayOfTheWeek, int licenseLastNumber) {

        return licenseLastNumberByDay.isRestricted(dayOfTheWeek, licenseLastNumber);

    }

   
}
