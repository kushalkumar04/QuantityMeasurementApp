/**
 * QuantityMeasurementApp - UC5: Unit-to-Unit Conversion
 *
 * Extends UC4 to provide explicit unit conversion between length units.
 * Uses method overloading for demonstrateLengthConversion().
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    /**
     * Demonstrates equality between two Length instances.
     */
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    /**
     * Demonstrates equality using raw values and units.
     */
    public static boolean demonstrateLengthComparison(
            double value1, LengthUnit unit1,
            double value2, LengthUnit unit2) {
        Length l1 = new Length(value1, unit1);
        Length l2 = new Length(value2, unit2);
        return demonstrateLengthEquality(l1, l2);
    }

    /**
     * Method Overload 1: Convert using raw value and units.
     * demonstrateLengthConversion(3.0, FEET, INCHES)
     */
    public static Length demonstrateLengthConversion(
            double value, LengthUnit fromUnit, LengthUnit toUnit) {
        if (fromUnit == null || toUnit == null) {
            throw new IllegalArgumentException("Units must not be null");
        }
        Length source = new Length(value, fromUnit);
        return source.convertTo(toUnit);
    }

    /**
     * Method Overload 2: Convert using existing Length instance.
     * demonstrateLengthConversion(lengthInYards, INCHES)
     */
    public static Length demonstrateLengthConversion(Length length, LengthUnit toUnit) {
        if (toUnit == null) {
            throw new IllegalArgumentException("Target unit must not be null");
        }
        return length.convertTo(toUnit);
    }

    public static void main(String[] args) {
        // Overload 1: convert 3.0 feet to inches
        Length result1 = demonstrateLengthConversion(3.0, LengthUnit.FEET, LengthUnit.INCHES);
        System.out.println("3.0 FEET to INCHES: " + result1);

        // Overload 2: convert yards object to inches
        Length yards = new Length(2.0, LengthUnit.YARDS);
        Length result2 = demonstrateLengthConversion(yards, LengthUnit.INCHES);
        System.out.println("2.0 YARDS to INCHES: " + result2);

        // Conversion examples
        System.out.println("1.0 FEET to INCHES: " +
                demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES));
        System.out.println("36.0 INCHES to YARDS: " +
                demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS));
        System.out.println("1.0 CM to INCHES: " +
                demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES));
    }
}