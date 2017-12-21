/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import java.util.Date;

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
    
    

    public Predictor() {
        this.licensePlateNumber = "";
        this.date = "";
        this.time = "";
    }

    public Predictor(String licensePlateNumber, String date, String time) {
        this.licensePlateNumber = licensePlateNumber;
        this.date = date;
        this.time = time;
        
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

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    //Returns whether or not that car can be on the road.
    public boolean canBeOnTheRoad(Schedule schedule, LastDigits lastDigits) {
        
        licenseLastNumber = lastDigits.extractLastDigits(licensePlateNumber, 1);
        int dayOfTheWeek = DateOfTheWeek.getDayOfTheWeek(date);
        
        boolean insideRestrictedTime= schedule.insideRestrictedSchedule(time);
        
        if(insideRestrictedTime)
            return !isRestrictedDayByLicenseNumber(dayOfTheWeek,licenseLastNumber);
        
        return true;
    }

    private boolean isRestrictedDayByLicenseNumber(int dayOfTheWeek, int licenseLastNumber) {
        switch(dayOfTheWeek){
            case 2:
                //Monday Plates numbers 1 y 2
                if (licenseLastNumber ==1 || licenseLastNumber ==2)
                    return true;
                break;
            case 3:
                //Tuesday Plates numbers 3 y 4
                if (licenseLastNumber ==3 || licenseLastNumber ==4)
                    return true;
                break;
            case 4:
                //Thursday Plates numbers 5 y 6
                if (licenseLastNumber ==5 || licenseLastNumber ==6)
                    return true;
                break;
            case 5:
                //Wednesday Plates numbers 7 y 8
                if (licenseLastNumber ==7 || licenseLastNumber ==8)
                    return true;
                break;
            case 6:
                //Friday Plates numbers 9 y 0
                if (licenseLastNumber ==9 || licenseLastNumber ==0)
                    return true;
                break;

                
        }
        return false;
    }
}
