/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author katrina
 */
class DateOfTheWeek implements DateOf {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    //Returns day of week as int, Week starts from Sunday as 1.
    @Override
    public int getDayOfTheWeek(String dateAsString) {

        Date date = null;
        int dayOfWeek = 0;

        try {
            date = formatter.parse(dateAsString);
        } catch (ParseException ex) {
            Logger.getLogger(DateOfTheWeek.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar c;
        c = new GregorianCalendar();

        c.setTime(date);

        dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        return dayOfWeek;
    }
}
