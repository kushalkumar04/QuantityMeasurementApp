package com.apps.quantitymeasurement;

/*
 * Interface representing measurable units.
 * Supports conversion to and from base units.
 */


public interface IMeasurable {

    double convertToBaseUnit(double value);

    double convertFromBaseUnit(double value);
}