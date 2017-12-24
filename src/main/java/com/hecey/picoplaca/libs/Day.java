/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hecey.picoplaca.libs;

/**
 *
 * @author katrina
 */
public enum Day {

    Sunday(1),
    Monday(2),
    Tuesday(3),
    Wednesday(4),
    Thursday(5),
    Friday(6),
    Saturday(7);
    
    private int value;

    private Day(int value) {

        this.value = value;

    }
    public int getValue() {
        return value;
    }
}
