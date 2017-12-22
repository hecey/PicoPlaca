/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca;

/**
 *
 * @author katrina
 */
public class PlateLastDigits implements LastDigits{

    public int extractLastDigits(String licensePlateNumber, int numberOfDigits) {
        String string = "";
        string = licensePlateNumber.trim().substring(licensePlateNumber.length()-numberOfDigits, licensePlateNumber.length());
        
        return Integer.parseInt(string);
    }

}
