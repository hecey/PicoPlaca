/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katrina
 */
public class TimeSchedule {

    private static ArrayList<TimeRange> timeRangeList = new ArrayList();
    private static SimpleDateFormat parser = new SimpleDateFormat("HH:mm");

    public static void Schedule(ArrayList<TimeRange> timeRangeListNew) {
        timeRangeList = timeRangeListNew;

    }

    public static void InitializeRangeList() {

        timeRangeList.add(new TimeRange("07:00", "09:30"));
        timeRangeList.add(new TimeRange("16:00", "19:30"));

    }

    public static void setTimeRangeList(ArrayList<TimeRange> timeRangeListNew) {
        timeRangeList = timeRangeListNew;
    }

    public static void setParser(SimpleDateFormat parser) {
        parser = parser;
    }

    public static boolean insideRestrictedSchedule(String time) {
        if (timeRangeList == null) {
            InitializeRangeList();
        }
        Date userTime = null;
        try {
            userTime = parser.parse(time);
        } catch (ParseException ex) {
            Logger.getLogger(TimeSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

        return insideRestrictedSchedule(userTime);

    }

    public static boolean insideRestrictedSchedule(Date userTime) {
        if (timeRangeList.isEmpty()) {
            InitializeRangeList();
        }
        for (TimeRange timeRange : timeRangeList) {
            if (userTime.after(timeRange.getTimeToStart()) && userTime.before(timeRange.getTimeToFinish())) {
                return true;
            }
        }

        return false;
    }

    public static void ClearTimeRangeList() {
        timeRangeList = null;
    }
}
