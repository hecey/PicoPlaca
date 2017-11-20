/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PicoPlaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katrina
 */
public class TimeSchedule {

    private static Date[][] timeSchedule;
    private static SimpleDateFormat parser;
    private static int scheduleLenght;

    public static void Schedule() {
        parser = new SimpleDateFormat("HH:mm");
        scheduleLenght = 2;
        timeSchedule = new Date[scheduleLenght][2];

        try {
            timeSchedule[0][0] = parser.parse("07:00");
            timeSchedule[0][1] = parser.parse("09:30");
            timeSchedule[1][0] = parser.parse("16:00");
            timeSchedule[1][1] = parser.parse("19:30");
        } catch (ParseException ex) {
            Logger.getLogger(TimeSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TimeSchedule(int rangeQuantity) {
        timeSchedule = new Date[rangeQuantity][2];
    }

    public static boolean insideRestrictedSchedule(String time) {
       Schedule();
        Date userTime;

        try {
            userTime = parser.parse(time);
            for (int i = 0; i < scheduleLenght; i++) {
                if (userTime.after(timeSchedule[i][0]) && userTime.before(timeSchedule[i][1])) {
                    return true;
                }
            }

        } catch (ParseException ex) {
            Logger.getLogger(TimeSchedule.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
