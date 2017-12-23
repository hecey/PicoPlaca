/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author katrina
 */
public class TimeRange implements Range{

    private static SimpleDateFormat parser;
    private Date timeToStart;
    private Date timeToFinish;

    public TimeRange(Date timeToStart, Date timeToFinish) {
        this.timeToStart = timeToStart;
        this.timeToFinish = timeToFinish;
    }
    
    public TimeRange(String timeToStart, String timeToFinish) throws DOException {
        parser = new SimpleDateFormat("HH:mm");
        try {
            this.timeToStart = parser.parse(timeToStart);
            this.timeToFinish = parser.parse(timeToFinish);
        } catch (ParseException ex) {
            throw new DOException(ex);
        }
        
    }

    public static void setParser(SimpleDateFormat parser) {
        TimeRange.parser = parser;
    }

    public static SimpleDateFormat getParser() {
        return parser;
    }

    @Override
    public Date getTimeToStart() {
        return timeToStart;
    }

    public void setTimeToStart(Date timeToStart) {
        this.timeToStart = timeToStart;
    }

    @Override
    public Date getTimeToFinish() {
        return timeToFinish;
    }

    public void setTimeToFinish(Date timeToFinish) {
        this.timeToFinish = timeToFinish;
    }

}
