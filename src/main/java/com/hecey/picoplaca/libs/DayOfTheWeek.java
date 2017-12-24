/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

import com.hecey.picoplaca.libs.exception.DOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author katrina
 */
public class DayOfTheWeek implements IDate {

    private SimpleDateFormat formatter;
    private Date date;

    //Returns day of week as int, Week starts from Sunday as 1.
    @Override
    public int getDayOfTheWeek(String dateAsString) throws DOException {
        if (dateAsString == null || dateAsString.length() == 0) {
            throw new IllegalArgumentException();
        }
        formatter = new SimpleDateFormat("dd-MM-yyyy");
        date = null;
        int dayOfWeek = 0;

        try {
            date = formatter.parse(dateAsString);
        } catch (ParseException ex) {
            throw new DOException(ex);

        }

        Calendar c;
        c = new GregorianCalendar();

        c.setTime(date);

        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek;
    }
}
