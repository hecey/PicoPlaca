/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs.exception;

import java.text.ParseException;

/**
 *
 * @author kat
 */
public class DOException extends Exception {
 
    public DOException(ParseException ex) {
        super(ex);
    }

  
    
}
