/*
 * DTO class used for transferring quantity data.
 */

package com.apps.quantitymeasurement.model;

import com.apps.quantitymeasurement.IMeasurable;

public class QuantityDTO<U extends IMeasurable> {

    private double value;
    private U unit;

    public QuantityDTO(double value, U unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }
}