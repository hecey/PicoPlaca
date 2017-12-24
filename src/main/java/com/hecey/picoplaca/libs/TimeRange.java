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
public class TimeRange implements IRange {

    private static SimpleDateFormat parser;
    private Date timeToStart;
    private Date timeToFinish;

    public TimeRange(String timeToStart, String timeToFinish) throws DOException {
        parser = new SimpleDateFormat("HH:mm");
        try {
            setTimeRange(parser.parse(timeToStart), parser.parse(timeToFinish));

        } catch (ParseException ex) {
            throw new DOException(ex);
        }

    }

    public void setTimeRange(Date timeToStart, Date timeToFinish) {
        this.timeToStart = timeToStart;
        this.timeToFinish = timeToFinish;
    }

    public static void setParser(SimpleDateFormat parser) {
        TimeRange.parser = parser;
    }

    

    @Override
    public Date getTimeToStart() {
        return timeToStart;
    }

    
    @Override
    public Date getTimeToFinish() {
        return timeToFinish;
    }

    

}
