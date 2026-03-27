/*
 * UC9: Weight Class
 *
 * Features:
 * - Equality
 * - Conversion
 * - Addition
 */

package com.apps.quantitymeasurement;

import java.util.Objects;

public class Weight {

    private final double value;
    private final WeightUnit unit;

    public Weight(double value, WeightUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    // 🔁 Convert to base (KG)
    private double convertToBaseUnit() {
        return unit.convertToBaseUnit(value);
    }

    // ✅ EQUALITY
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Weight that = (Weight) obj;

        double base1 = this.convertToBaseUnit();
        double base2 = that.convertToBaseUnit();

        return Double.compare(base1, base2) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    // ✅ CONVERSION
    public Weight convertTo(WeightUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }

        double base = this.convertToBaseUnit();
        double converted = targetUnit.convertFromBaseUnit(base);

        return new Weight(converted, targetUnit);
    }

    // ✅ ADD (default → this unit)
    public Weight add(Weight other) {
        if (other == null) {
            throw new IllegalArgumentException("Other weight cannot be null");
        }

        double baseSum = this.convertToBaseUnit() + other.convertToBaseUnit();
        double result = this.unit.convertFromBaseUnit(baseSum);

        return new Weight(result, this.unit);
    }

    // ✅ ADD (target unit)
    public Weight add(Weight other, WeightUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        double baseSum = this.convertToBaseUnit() + other.convertToBaseUnit();
        double result = targetUnit.convertFromBaseUnit(baseSum);

        return new Weight(result, targetUnit);
    }

    @Override
    public String toString() {
        return value + " " + unit;
    }
}