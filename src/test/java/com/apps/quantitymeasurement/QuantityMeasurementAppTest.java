/**
 * QuantityMeasurementAppTest - UC5: Unit-to-Unit Conversion tests
 */

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.apps.quantitymeasurement.Length.LengthUnit;

public class QuantityMeasurementAppTest {

    private static final double EPSILON = 1e-2;

    // ==================== EQUALITY TESTS (UC1-UC4) ====================

    @Test
    public void testFeetEquality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(1.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(12.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInequality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(2.0, LengthUnit.FEET);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testInchesInequality() {
        Length l1 = new Length(1.0, LengthUnit.INCHES);
        Length l2 = new Length(2.0, LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testCrossUnitInequality() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void testMultipleFeetComparison() {
        Length l1 = new Length(2.0, LengthUnit.FEET);
        Length l2 = new Length(24.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void yardEquals36Inches() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(36.0, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void centimeterEquals39Point3701Inches() {
        Length l1 = new Length(1.0, LengthUnit.CENTIMETERS);
        Length l2 = new Length(0.393701, LengthUnit.INCHES);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void threeFeetEqualsOneYard() {
        Length l1 = new Length(3.0, LengthUnit.FEET);
        Length l2 = new Length(1.0, LengthUnit.YARDS);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void thirtyPoint48CmEqualsOneFoot() {
        Length l1 = new Length(30.48, LengthUnit.CENTIMETERS);
        Length l2 = new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l2));
    }

    @Test
    public void yardNotEqualToInches() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(1.0, LengthUnit.INCHES);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void referenceEqualitySameObject() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        assertTrue(l1.equals(l1));
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Length l1 = new Length(1.0, LengthUnit.FEET);
        assertFalse(l1.equals(null));
    }

    @Test
    public void reflexiveSymmetricAndTransitiveProperty() {
        Length yard = new Length(1.0, LengthUnit.YARDS);
        Length feet = new Length(3.0, LengthUnit.FEET);
        Length inches = new Length(36.0, LengthUnit.INCHES);
        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(yard));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }

    @Test
    public void differentValuesSameUnitNotEqual() {
        Length l1 = new Length(1.0, LengthUnit.YARDS);
        Length l2 = new Length(2.0, LengthUnit.YARDS);
        assertFalse(l1.equals(l2));
    }

    @Test
    public void crossUnitEqualityDemonstrateMethod() {
        assertTrue(QuantityMeasurementApp.demonstrateLengthComparison(
                1.0, LengthUnit.FEET, 12.0, LengthUnit.INCHES));
    }

    // ==================== CONVERSION TESTS (UC5) ====================

    @Test
    public void convertFeetToInches() {
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                3.0, LengthUnit.FEET, LengthUnit.INCHES);
        Length expected = new Length(36.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void convertYardsToInchesUsingOverloadedMethod() {
        Length yards = new Length(2.0, LengthUnit.YARDS);
        Length result = QuantityMeasurementApp.demonstrateLengthConversion(
                yards, LengthUnit.INCHES);
        Length expected = new Length(72.0, LengthUnit.INCHES);
        assertTrue(QuantityMeasurementApp.demonstrateLengthEquality(result, expected));
    }

    @Test
    public void testConversion_FeetToInches() {
        Length result = new Length(1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        assertEquals(12.0, result.convertTo(LengthUnit.INCHES)
                .convertTo(LengthUnit.FEET).convertTo(LengthUnit.INCHES)
                .equals(new Length(12.0, LengthUnit.INCHES)) ? 12.0 : 0.0, EPSILON);
        assertTrue(result.equals(new Length(12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_InchesToFeet() {
        Length result = new Length(24.0, LengthUnit.INCHES).convertTo(LengthUnit.FEET);
        assertTrue(result.equals(new Length(2.0, LengthUnit.FEET)));
    }

    @Test
    public void testConversion_YardsToInches() {
        Length result = new Length(1.0, LengthUnit.YARDS).convertTo(LengthUnit.INCHES);
        assertTrue(result.equals(new Length(36.0, LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_InchesToYards() {
        Length result = new Length(72.0, LengthUnit.INCHES).convertTo(LengthUnit.YARDS);
        assertTrue(result.equals(new Length(2.0, LengthUnit.YARDS)));
    }

    @Test
    public void testConversion_FeetToYards() {
        Length result = new Length(6.0, LengthUnit.FEET).convertTo(LengthUnit.YARDS);
        assertTrue(result.equals(new Length(2.0, LengthUnit.YARDS)));
    }

    @Test
    public void testConversion_CentimetersToInches() {
        Length result = new Length(2.54, LengthUnit.CENTIMETERS).convertTo(LengthUnit.INCHES);
        assertTrue(result.equals(new Length(1.0, LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_ZeroValue() {
        Length result = new Length(0.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        assertTrue(result.equals(new Length(0.0, LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_NegativeValue() {
        Length result = new Length(-1.0, LengthUnit.FEET).convertTo(LengthUnit.INCHES);
        assertTrue(result.equals(new Length(-12.0, LengthUnit.INCHES)));
    }

    @Test
    public void testConversion_SameUnit() {
        Length result = new Length(5.0, LengthUnit.FEET).convertTo(LengthUnit.FEET);
        assertTrue(result.equals(new Length(5.0, LengthUnit.FEET)));
    }

    @Test
    public void testConversion_NullTargetUnit_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Length(1.0, LengthUnit.FEET).convertTo(null);
        });
    }

    @Test
    public void testConversion_RoundTrip() {
        Length original = new Length(3.0, LengthUnit.FEET);
        Length converted = original.convertTo(LengthUnit.INCHES).convertTo(LengthUnit.FEET);
        assertTrue(original.equals(converted));
    }
}