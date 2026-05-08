package com.apps.quantitymeasurement;

/*
 * Enum representing weight units.
 * Base unit is GRAM.
 */


public enum WeightUnit implements IMeasurable {

    GRAM(1.0),
    KILOGRAM(1000.0),
    TONNE(1000000.0);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
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