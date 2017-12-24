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
public interface ILicenseLastNumberByDay {

    public boolean isRestricted(int d, int licenseLastNumber);
}
