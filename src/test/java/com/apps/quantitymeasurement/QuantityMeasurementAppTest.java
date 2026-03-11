/**
 * QuantityMeasurementAppTest - UC2: Feet and Inches measurement equality tests
 */

package com.apps.quantitymeasurement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.apps.quantitymeasurement.QuantityMeasurementApp.Feet;
import com.apps.quantitymeasurement.QuantityMeasurementApp.Inches;

public class QuantityMeasurementAppTest {

    // ==================== FEET TESTS (from UC1) ====================

    @Test
    public void testFeetEquality_SameValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(1.0);
        assertTrue(feet1.equals(feet2), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    public void testFeetEquality_DifferentValue() {
        Feet feet1 = new Feet(1.0);
        Feet feet2 = new Feet(2.0);
        assertFalse(feet1.equals(feet2), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    public void testFeetEquality_NullComparison() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals(null), "A Feet object should not be equal to null");
    }

    @Test
    public void testFeetEquality_DifferentClass() {
        Feet feet1 = new Feet(1.0);
        assertFalse(feet1.equals("one foot"), "A Feet object should not be equal to a String");
    }

    @Test
    public void testFeetEquality_SameReference() {
        Feet feet1 = new Feet(1.0);
        assertTrue(feet1.equals(feet1), "A Feet object should be equal to itself");
    }

    // ==================== INCHES TESTS (new in UC2) ====================

    @Test
    public void testInchesEquality_SameValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(1.0);
        assertTrue(inch1.equals(inch2), "1.0 inch should be equal to 1.0 inch");
    }

    @Test
    public void testInchesEquality_DifferentValue() {
        Inches inch1 = new Inches(1.0);
        Inches inch2 = new Inches(2.0);
        assertFalse(inch1.equals(inch2), "1.0 inch should not be equal to 2.0 inch");
    }

    @Test
    public void testInchesEquality_NullComparison() {
        Inches inch1 = new Inches(1.0);
        assertFalse(inch1.equals(null), "An Inches object should not be equal to null");
    }

    @Test
    public void testInchesEquality_DifferentClass() {
        Inches inch1 = new Inches(1.0);
        assertFalse(inch1.equals("one inch"), "An Inches object should not be equal to a String");
    }

    @Test
    public void testInchesEquality_SameReference() {
        Inches inch1 = new Inches(1.0);
        assertTrue(inch1.equals(inch1), "An Inches object should be equal to itself");
    }
}