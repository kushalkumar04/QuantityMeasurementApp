/**
 * Length - UC5: Unit-to-Unit Conversion
 *
 * A generic class for representing and comparing lengths in different units.
 * All conversions use INCHES as the base unit.
 * Values are rounded to two decimal places for deterministic equality checks.
 */

package com.apps.quantitymeasurement;

public class Length {

    private double value;
    private LengthUnit unit;

    /**
     * Enum representing different length units and their conversion factors.
     * Base unit is INCHES. All factors are relative to inches.
     * Example: 1 FOOT = 12.0 inches, 1 YARD = 36.0 inches, 1 CM = 0.393701 inches
     */
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
    }

    /**
     * Constructor to initialize length value and unit.
     */
    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    /**
     * Private utility method: converts this length to base unit (inches) with rounding.
     * Rounds to 2 decimal places for consistent equality checks.
     */
    private double convertToBaseUnit() {
        double result = value * unit.getConversionFactor();
        return Math.round(result * 100.0) / 100.0;
    }

    /**
     * Private helper method: compares two Length objects by their base unit values.
     */
    private boolean compare(Length thatLength) {
        return Double.compare(this.convertToBaseUnit(), thatLength.convertToBaseUnit()) == 0;
    }

    /**
     * Converts this length to the specified target unit.
     * Returns a new Length instance (immutability guaranteed).
     *
     * @param targetUnit the unit to convert to (must not be null)
     * @return new Length instance in the target unit
     * @throws IllegalArgumentException if targetUnit is null
     */
    public Length convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit must not be null");
        }
        // Convert to base unit (inches) first, then to target unit
        double inBaseUnit = value * unit.getConversionFactor();
        double convertedValue = inBaseUnit / targetUnit.getConversionFactor();
        double rounded = Math.round(convertedValue * 100.0) / 100.0;
        return new Length(rounded, targetUnit);
    }
    /**
     * UC6: Adds another Length to this Length.
     * Result is returned in the unit of the FIRST operand.
     *
     * Steps:
     * 1. Convert both values to base unit (INCHES)
     * 2. Add them
     * 3. Convert result back to this.unit
     * 4. Return new Length object
     */
    public Length add(Length thatLength) {

        // Validation
        if (thatLength == null) {
            throw new IllegalArgumentException("Second length must not be null");
        }

        // Step 1: Convert both to base unit (INCHES)
        double base1 = this.convertToBaseUnit();
        double base2 = thatLength.convertToBaseUnit();

        // Step 2: Add
        double sumBase = base1 + base2;

        // Step 3: Convert back to THIS unit
        double result = sumBase / this.unit.getConversionFactor();

        // Round to 2 decimal places (VERY IMPORTANT for your tests)
        double rounded = Math.round(result * 100.0) / 100.0;

        // Step 4: Return new object (immutability)
        return new Length(rounded, this.unit);
    }
    /**
     * Overridden equals() method.
     * Two lengths are equal if their base unit values (rounded) are the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Length thatLength = (Length) o;
        return this.compare(thatLength);
    }

    /**
     * Overridden toString() for readable output.
     * Format: "value UNIT" e.g. "12.00 INCHES"
     */
    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }

    // Main method for standalone testing
    public static void main(String[] args) {
        Length feet = new Length(1.0, LengthUnit.FEET);
        Length inches = feet.convertTo(LengthUnit.INCHES);
        System.out.println("1.0 FEET converted to INCHES: " + inches);

        Length yards = new Length(3.0, LengthUnit.YARDS);
        Length feetConverted = yards.convertTo(LengthUnit.FEET);
        System.out.println("3.0 YARDS converted to FEET: " + feetConverted);
    }
}