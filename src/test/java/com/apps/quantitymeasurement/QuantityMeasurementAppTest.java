/**
 * QuantityMeasurementAppTest - UC4: Extended Unit Support tests
 */

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    // ==================== FEET & INCHES (UC1, UC2, UC3) ====================

    @Test
    public void testFeetEquality() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length feet2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2));
    }

    @Test
    public void testInchesEquality() {
        Length inch1 = new Length(1.0, LengthUnit.INCHES);
        Length inch2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(inch1.equals(inch2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        Length inch1 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(feet1.equals(inch1));
    }

    // ==================== YARDS (new in UC4) ====================

    @Test
    public void testEquality_YardToYard_SameValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard1.equals(yard2), "1.0 yard should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length yard2 = new Length(2.0, LengthUnit.YARDS);
        assertFalse(yard1.equals(yard2), "1.0 yard should not equal 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length feet1 = new Length(3.0, LengthUnit.FEET);
        assertTrue(yard1.equals(feet1), "1.0 yard should equal 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        Length feet1 = new Length(3.0, LengthUnit.FEET);
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(feet1.equals(yard1), "3.0 feet should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length inch1 = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard1.equals(inch1), "1.0 yard should equal 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        Length inch1 = new Length(36.0, LengthUnit.INCHES);
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(inch1.equals(yard1), "36.0 inches should equal 1.0 yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length feet1 = new Length(2.0, LengthUnit.FEET);
        assertFalse(yard1.equals(feet1), "1.0 yard should not equal 2.0 feet");
    }

    @Test
    public void testEquality_YardSameReference() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(yard1.equals(yard1), "A yard object should equal itself");
    }

    @Test
    public void testEquality_YardNullComparison() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        assertFalse(yard1.equals(null), "A yard object should not equal null");
    }

    // ==================== CENTIMETERS (new in UC4) ====================

    @Test
    public void testEquality_CentimetersToCentimeters_SameValue() {
        Length cm1 = new Length(2.0, LengthUnit.CENTIMETERS);
        Length cm2 = new Length(2.0, LengthUnit.CENTIMETERS);
        assertTrue(cm1.equals(cm2), "2.0 cm should equal 2.0 cm");
    }

    @Test
    public void testEquality_CentimetersToInches_EquivalentValue() {
        Length cm1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length inch1 = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(cm1.equals(inch1), "1.0 cm should equal 0.393701 inches");
    }

    @Test
    public void testEquality_CentimetersToFeet_NonEquivalentValue() {
        Length cm1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length feet1 = new Length(1.0, LengthUnit.FEET);
        assertFalse(cm1.equals(feet1), "1.0 cm should not equal 1.0 feet");
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        Length cm1 = new Length(1.0, LengthUnit.CENTIMETERS);
        assertTrue(cm1.equals(cm1), "A cm object should equal itself");
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        Length cm1 = new Length(1.0, LengthUnit.CENTIMETERS);
        assertFalse(cm1.equals(null), "A cm object should not equal null");
    }

    // ==================== TRANSITIVE / COMPLEX ====================

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        Length yard1 = new Length(1.0, LengthUnit.YARDS);
        Length feet1 = new Length(3.0, LengthUnit.FEET);
        Length inch1 = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard1.equals(feet1), "1 yard = 3 feet");
        assertTrue(feet1.equals(inch1), "3 feet = 36 inches");
        assertTrue(yard1.equals(inch1), "1 yard = 36 inches (transitive)");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        Length yard1 = new Length(2.0, LengthUnit.YARDS);
        Length feet1 = new Length(6.0, LengthUnit.FEET);
        Length inch1 = new Length(72.0, LengthUnit.INCHES);
        assertTrue(yard1.equals(feet1), "2 yards = 6 feet");
        assertTrue(feet1.equals(inch1), "6 feet = 72 inches");
        assertTrue(yard1.equals(inch1), "2 yards = 72 inches");
    }
}