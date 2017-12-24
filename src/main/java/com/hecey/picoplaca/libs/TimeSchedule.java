/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author katrina
 */
public class TimeSchedule implements ISchedule{

    private static ArrayList<IRange> timeRangeList;
    private static SimpleDateFormat parser;

    public TimeSchedule() {
          timeRangeList = new ArrayList();
    }

    

    public  void InitializeRangeList() throws DOException {
        
       
        timeRangeList.add(new TimeRange("07:00", "09:30"));
        timeRangeList.add(new TimeRange("16:00", "19:30"));

    }

    public static void setTimeRangeList(ArrayList<IRange> timeRangeListNew) {
        timeRangeList = timeRangeListNew;
    }

    public static void setParser(SimpleDateFormat parserNew) {
        parser = parserNew;
    }

    @Override
    public  boolean insideRestrictedSchedule(String time) throws DOException{
        
        if (time == null || time.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        
        Date userTime = null;
        try {
            userTime = parser.parse(time);
        } catch (ParseException ex) {
            throw new DOException(ex);
        }

        return insideRestrictedSchedule(userTime);

    }

    public  boolean insideRestrictedSchedule(Date userTime) throws DOException{
        
        return timeRangeList.stream().anyMatch((timeRange) -> (userTime.after(timeRange.getTimeToStart()) && userTime.before(timeRange.getTimeToFinish())));
    }

    public static void ClearTimeRangeList() {
        timeRangeList = null;
    }
}
