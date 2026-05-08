package com.apps.quantitymeasurement;

/*
 * Enum representing volume units.
 * Base unit is MILLILITRE.
 */


public enum VolumeUnit implements IMeasurable {

    MILLILITRE(1.0),
    LITRE(1000.0),
    GALLON(3780.0);

    private final double conversionFactor;

    VolumeUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    @Override
    public double convertToBaseUnit(double value) {
        return value * conversionFactor;
    }

    @Override
    public double convertFromBaseUnit(double value) {
        return value / conversionFactor;
    }
}