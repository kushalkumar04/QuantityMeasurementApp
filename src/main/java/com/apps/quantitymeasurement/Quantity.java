package com.apps.quantitymeasurement;

/*
 * Generic quantity class supporting
 * measurable unit conversions and equality.
 */

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {

        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }

        this.value = value;
        this.unit = unit;
    }

    /*
     * Converts quantity to base unit.
     */
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    /*
     * Converts quantity to target unit.
     */
    public Quantity<U> convertTo(U targetUnit) {

        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double baseValue = convertToBaseUnit();

        double convertedValue =
                targetUnit.convertFromBaseUnit(baseValue);

        double rounded =
                Math.round(convertedValue * 100.0) / 100.0;

        return new Quantity<>(rounded, targetUnit);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        Quantity<?> that = (Quantity<?>) o;

        if (!this.unit.getClass().equals(that.unit.getClass())) {
            return false;
        }

        return Double.compare(
                this.convertToBaseUnit(),
                that.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, unit);
    }
}