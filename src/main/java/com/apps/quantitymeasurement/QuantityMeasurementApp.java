/**
 * QuantityMeasurementApp - UC4: Extended Unit Support
 * Adds Yards and Centimeters to the existing Length class.
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feet1.equals(feet2));
    }

    public static void demonstrateInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inch1.equals(inch2));
    }

    public static void demonstrateFeetInchesComparison() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are 1.0 ft and 12.0 inches equal? " + feet1.equals(inch1));
    }

    public static void demonstrateYardsComparison() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length feet1 = new Length(3.0, LengthUnit.FEET);
        System.out.println("Are 1.0 yard and 3.0 feet equal? " + yard1.equals(feet1));

        Length inch1 = new Length(36.0, LengthUnit.INCHES);
        System.out.println("Are 1.0 yard and 36.0 inches equal? " + yard1.equals(inch1));
    }

    public static void demonstrateCentimetersComparison() {
        Length cm1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch1 = new Length(0.393701, LengthUnit.INCHES);
        System.out.println("Are 1.0 cm and 0.393701 inches equal? " + cm1.equals(inch1));

        Length cm2 = new Length(2.0, LengthUnit.CENTIMETERS);
        Length cm3 = new Length(2.0, LengthUnit.CENTIMETERS);
        System.out.println("Are 2.0 cm and 2.0 cm equal? " + cm2.equals(cm3));
    }

    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
        demonstrateYardsComparison();
        demonstrateCentimetersComparison();
    }
}