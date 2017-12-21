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
public class TimeRange {

    private static SimpleDateFormat parser;
    private Date timeToStart;
    private Date timeToFinish;

    public TimeRange(Date timeToStart, Date timeToFinish) {
        this.timeToStart = timeToStart;
        this.timeToFinish = timeToFinish;
    }
    
    public TimeRange(String timeToStart, String timeToFinish) {
        parser = new SimpleDateFormat("HH:mm");
        try {
            this.timeToStart = parser.parse(timeToStart);
            this.timeToFinish = parser.parse(timeToFinish);
        } catch (ParseException ex) {
            Logger.getLogger(TimeRange.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void setParser(SimpleDateFormat parser) {
        TimeRange.parser = parser;
    }

    public static SimpleDateFormat getParser() {
        return parser;
    }

    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

    public Date getTimeToFinish() {
        return timeToFinish;
    }

    public void setTimeToFinish(Date timeToFinish) {
        this.timeToFinish = timeToFinish;
    }

}
