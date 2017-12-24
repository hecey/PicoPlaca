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
public enum PlateNumbersByDay {

    Sunday(new int[]{}),
    Monday(new int[]{1, 2}),
    Tuesday(new int[]{3, 4}),
    Wednesday(new int[]{5, 6}),
    Thursday(new int[]{7, 8}),
    Friday(new int[]{9, 0}),
    Saturday(new int[]{});

    private int[] value;

    private PlateNumbersByDay(int[] value) {

        this.value = value;

    }
    
    public int[] getValue() {
        return value;
    }
}
