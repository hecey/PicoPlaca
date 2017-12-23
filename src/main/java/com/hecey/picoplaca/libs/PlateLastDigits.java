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
public class PlateLastDigits implements LastDigits {

    @Override
    public int extractLastDigits(String licensePlateNumber, int numberOfDigits) {
        if (licensePlateNumber == null || licensePlateNumber.length() == 0) {
            throw new IllegalArgumentException();
        }

        String string = "";
        string = licensePlateNumber.trim().substring(licensePlateNumber.length() - numberOfDigits, licensePlateNumber.length());

        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {

            throw new NumberFormatException(e + " is invalid.");
        }
    }

}
