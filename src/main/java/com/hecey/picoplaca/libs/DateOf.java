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
public interface DateOf {

    public int getDayOfTheWeek(String date) throws DOException;
    
}
