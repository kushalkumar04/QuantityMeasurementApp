/**
 * QuantityMeasurementAppTest - UC3: Generic Quantity Class tests
 */

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 ft should equal 1.0 ft");
    }

    @Test
    public void testInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(inch1.equals(inch2), "1.0 inch should equal 1.0 inch");
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet1.equals(inch1), "1.0 ft should equal 12.0 inches");
    }

    @Test
    public void testInchToFeet_EquivalentValue() {
        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        assertTrue(inch1.equals(feet1), "12.0 inches should equal 1.0 ft (symmetry)");
    }

    @Test
    public void testFeetInequality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 ft should not equal 2.0 ft");
    }

    @Test
    public void testInchesInequality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(2.0, LengthUnit.INCHES);
        assertFalse(inch1.equals(inch2), "1.0 inch should not equal 2.0 inch");
    }

    @Test
    public void testCrossUnitInequality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(feet1.equals(inch1), "1.0 ft should not equal 1.0 inch");
    }

    @Test
    public void testSameReference() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet1), "A Length object should equal itself");
    }

    @Test
    public void testNullComparison() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        assertFalse(feet1.equals(null), "A Length object should not equal null");
    }

    @Test
    public void testMultipleFeetComparison() {
        Length feet1 = new Length(2.0, LengthUnit.FEET);
        Length inch1 = new Length(24.0, LengthUnit.INCHES);
        assertTrue(feet1.equals(inch1), "2.0 ft should equal 24.0 inches");
    }
}