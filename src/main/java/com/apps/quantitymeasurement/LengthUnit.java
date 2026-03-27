/*
 * UC8: Standalone LengthUnit Enum
 *
 * Responsibility:
 * - Handle ALL unit conversions
 * - Convert TO base unit (INCHES)
 * - Convert FROM base unit (INCHES)
 */

package com.apps.quantitymeasurement;

public enum LengthUnit {

    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }

    /**
     * Convert value from this unit → base unit (INCHES)
     */
    public double convertToBaseUnit(double value) {
        double result = value * conversionFactor;
        return Math.round(result * 100.0) / 100.0;
    }

    /**
     * Convert value from base unit (INCHES) → this unit
     */
    public double convertFromBaseUnit(double baseValue) {
        double result = baseValue / conversionFactor;
        return Math.round(result * 100.0) / 100.0;
    }
}