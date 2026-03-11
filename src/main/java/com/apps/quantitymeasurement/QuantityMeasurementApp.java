/**
 * QuantityMeasurementApp - UC3: Unified Quantity Measurement System
 *
 * Addresses the DRY principle violations from UC1 and UC2.
 * Now uses the single Length class for all measurements.
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementApp {

    // Generic method to demonstrate Length equality check
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Static method to demonstrate Feet equality check
    public static void demonstrateFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        System.out.println("Are 1.0 ft and 1.0 ft equal? " + feet1.equals(feet2));
    }

    // Static method to demonstrate Inches equality check
    public static void demonstrateInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);
        System.out.println("Are 1.0 inch and 1.0 inch equal? " + inch1.equals(inch2));
    }

    // Static method to demonstrate Feet and Inches comparison
    public static void demonstrateFeetInchesComparison() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        System.out.println("Are 1.0 ft and 12.0 inches equal? " + feet1.equals(inch1));
    }

    // Main method
    public static void main(String[] args) {
        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}